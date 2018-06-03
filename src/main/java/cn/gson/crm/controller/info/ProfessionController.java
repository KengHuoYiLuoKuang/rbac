package cn.gson.crm.controller.info;

import cn.gson.crm.model.dao.ProfessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/info/profession")
@Controller
public class ProfessionController {
    @Autowired
    ProfessionDao professionDao;

    @RequestMapping("/list")
    @ResponseBody
    public List list(){
        return professionDao.findAll();
    }
}
