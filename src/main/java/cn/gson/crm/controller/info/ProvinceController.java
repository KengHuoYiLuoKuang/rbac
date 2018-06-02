package cn.gson.crm.controller.info;

import cn.gson.crm.common.AjaxResult;
import cn.gson.crm.common.DataGrid;
import cn.gson.crm.common.MySpecification;
import cn.gson.crm.controller.system.RoleController;
import cn.gson.crm.model.dao.ProvinceDao;
import cn.gson.crm.model.domain.Member;
import cn.gson.crm.model.domain.Province;
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

@RequestMapping("/info/province")
@Controller
public class ProvinceController {

    Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    private ProvinceDao provinceDao;

    @Value("${crm.system.super-user-id}")
    Long superUserId;

    @RequestMapping
    public String index() {
        return "/info/province";
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataGrid<Province> list(int page, int rows,  String province) {
        PageRequest pr = new PageRequest(page - 1, rows);

        Page pageData = provinceDao.findAll(new MySpecification<Province>().and(
                MySpecification.Cnd.like("province", province)
        ).asc("provinceCode"), pr);

        return new DataGrid<>(pageData);
    }
    @RequestMapping("/form")
    public void form(Long id, Model model) {

        if (id != null) {
            ObjectMapper mapper = new ObjectMapper();
            Province province = provinceDao.findOne(id);
            try {
                model.addAttribute("province", mapper.writeValueAsString(province));
            } catch (JsonProcessingException e) {
                logger.error("json转换错误", e);
            }
        }
    }



    @RequestMapping({"/save", "/update"})
    @Transactional
    @ResponseBody
    public AjaxResult save(@Valid Province Province) {

        provinceDao.save(Province);

        return new AjaxResult();
    }

    @RequestMapping("/departs")
    @ResponseBody
    public Iterable<Province> departs() {
        return provinceDao.findAll();
    }

    @RequestMapping("/delete")
    @Transactional
    @ResponseBody
    public AjaxResult delete(Long id) {
        try {
            provinceDao.delete(id);
        } catch (Exception e) {
            return new AjaxResult(false).setMessage(e.getMessage());
        }
        return new AjaxResult();
    }
}
