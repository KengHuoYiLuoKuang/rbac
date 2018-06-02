package cn.gson.crm.controller.system;

import cn.gson.crm.model.dao.ProvinceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    ProvinceDao provinceDao;

    @RequestMapping("/list")
    @ResponseBody
    public List list (){
        return provinceDao.findAll();
    }
}
