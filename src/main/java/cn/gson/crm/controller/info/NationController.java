package cn.gson.crm.controller.info;

import cn.gson.crm.common.AjaxResult;
import cn.gson.crm.common.DataGrid;
import cn.gson.crm.common.MySpecification;
import cn.gson.crm.controller.system.RoleController;
import cn.gson.crm.model.dao.NationDao;
import cn.gson.crm.model.domain.Nation;
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
import java.util.List;

@Controller
@RequestMapping("/info/nation")
public class NationController {
    Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    private NationDao nationDao;

    @Value("${crm.system.super-user-id}")
    Long superUserId;

    @RequestMapping
    public String index() {
        return "/info/Nation";
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataGrid<Nation> list(int page, int rows, String nation) {
        PageRequest pr = new PageRequest(page - 1, rows);

        Page pageData = nationDao.findAll(new MySpecification<Nation>().and(
                MySpecification.Cnd.like("nation", nation)
        ).asc("nationCode"), pr);

        return new DataGrid<>(pageData);
    }
    @RequestMapping("/form")
    public void form(Integer id, Model model) {

        if (id != null) {
            ObjectMapper mapper = new ObjectMapper();
            Nation Nation = nationDao.findOne(id);
            try {
                model.addAttribute("nation", mapper.writeValueAsString(Nation));
            } catch (JsonProcessingException e) {
                logger.error("json转换错误", e);
            }
        }
    }



    @RequestMapping({"/save", "/update"})
    @Transactional
    @ResponseBody
    public AjaxResult save(Nation nation) {

        nationDao.save(nation);

        return new AjaxResult();
    }



    @RequestMapping("/delete")
    @Transactional
    @ResponseBody
    public AjaxResult delete(Integer id) {
        try {
            nationDao.delete(id);
        } catch (Exception e) {
            return new AjaxResult(false).setMessage(e.getMessage());
        }
        return new AjaxResult();
    }

    @RequestMapping("/findall")
    @ResponseBody
    public List list (){
        return nationDao.findAll();
    }
}
