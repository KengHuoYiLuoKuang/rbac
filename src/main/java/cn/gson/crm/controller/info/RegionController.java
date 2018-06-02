package cn.gson.crm.controller.info;

import cn.gson.crm.common.AjaxResult;
import cn.gson.crm.common.DataGrid;
import cn.gson.crm.common.MySpecification;
import cn.gson.crm.controller.system.RoleController;
import cn.gson.crm.model.dao.RegionDao;
import cn.gson.crm.model.domain.Region;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@RequestMapping("/info/region")
@Controller
public class RegionController {

    Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    private RegionDao regionDao;

    @Value("${crm.system.super-user-id}")
    Long superUserId;

    @RequestMapping
    public String index() {
        return "/info/region";
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataGrid<Region> list(int page, int rows, String region) {
        PageRequest pr = new PageRequest(page - 1, rows);

        Page pageData = regionDao.findAll(new MySpecification<Region>().and(
                MySpecification.Cnd.like("region", region)
        ).asc("regionCode"), pr);

        return new DataGrid<>(pageData);
    }
    @RequestMapping("/form")
    public void form(Long id, Model model) {

        if (id != null) {
            ObjectMapper mapper = new ObjectMapper();
            Region region = regionDao.findOne(id);
            try {
                model.addAttribute("region", mapper.writeValueAsString(region));
            } catch (JsonProcessingException e) {
                logger.error("json转换错误", e);
            }
        }
    }



    @RequestMapping({"/save", "/update"})
    @Transactional
    @ResponseBody
    public AjaxResult save(@Valid Region region) {

        regionDao.save(region);

        return new AjaxResult();
    }

    @RequestMapping("/departs")
    @ResponseBody
    public Iterable<Region> departs() {
        return regionDao.findAll();
    }

    @RequestMapping("/delete")
    @Transactional
    @ResponseBody
    public AjaxResult delete(Long id) {
        try {
            regionDao.delete(id);
        } catch (Exception e) {
            return new AjaxResult(false).setMessage(e.getMessage());
        }
        return new AjaxResult();
    }
}
