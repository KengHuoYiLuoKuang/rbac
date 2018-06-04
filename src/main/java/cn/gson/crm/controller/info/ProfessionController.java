package cn.gson.crm.controller.info;

import cn.gson.crm.common.AjaxResult;
import cn.gson.crm.common.DataGrid;
import cn.gson.crm.common.MySpecification;
import cn.gson.crm.controller.system.RoleController;
import cn.gson.crm.model.dao.ProfessionDao;
import cn.gson.crm.model.domain.Profession;
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

import java.util.List;

@Controller
@RequestMapping("/info/profession")
public class ProfessionController {
    Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    private ProfessionDao professionDao;

    @Value("${crm.system.super-user-id}")
    Long superUserId;

    @RequestMapping
    public String index() {
        return "/info/profession";
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataGrid<Profession> list(int page, int rows, String profession) {
        PageRequest pr = new PageRequest(page - 1, rows);

        Page pageData = professionDao.findAll(new MySpecification<Profession>().and(
                MySpecification.Cnd.like("profession", profession)
        ).asc("professionCode"), pr);

        return new DataGrid<>(pageData);
    }
    @RequestMapping("/form")
    public void form(Integer id, Model model) {

        if (id != null) {
            ObjectMapper mapper = new ObjectMapper();
            Profession profession = professionDao.findOne(id);
            try {
                model.addAttribute("profession", mapper.writeValueAsString(profession));
            } catch (JsonProcessingException e) {
                logger.error("json转换错误", e);
            }
        }
    }



    @RequestMapping({"/save", "/update"})
    @Transactional
    @ResponseBody
    public AjaxResult save(Profession profession) {

        professionDao.save(profession);

        return new AjaxResult();
    }

    @RequestMapping("/departs")
    @ResponseBody
    public Iterable<Profession> departs() {
        return professionDao.findAll();
    }

    @RequestMapping("/delete")
    @Transactional
    @ResponseBody
    public AjaxResult delete(Integer id) {
        try {
            professionDao.delete(id);
        } catch (Exception e) {
            return new AjaxResult(false).setMessage(e.getMessage());
        }
        return new AjaxResult();
    }

    @RequestMapping("/findall")
    @ResponseBody
    public List list (){
        return professionDao.findAll();
    }
}
