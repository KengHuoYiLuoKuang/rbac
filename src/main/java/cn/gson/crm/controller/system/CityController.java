package cn.gson.crm.controller.system;

import cn.gson.crm.model.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityDao cityDao;

    @RequestMapping("/findcity")
    @ResponseBody
    public List findByProvince(int provinceCode){
        return cityDao.findByProvinceCode(provinceCode);
    }
}
