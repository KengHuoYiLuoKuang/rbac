package cn.gson.crm.controller.info;

import cn.gson.crm.model.dao.NationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/info/nation")
public class NationController {
    @Autowired
    NationDao nationDao;

    @RequestMapping("/list")
    @ResponseBody
    public List list(){
       List list = nationDao.findAll();
       return list;
    }
}
