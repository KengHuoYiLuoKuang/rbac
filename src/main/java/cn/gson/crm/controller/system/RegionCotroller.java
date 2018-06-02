package cn.gson.crm.controller.system;

import cn.gson.crm.model.dao.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/region")
public class RegionCotroller {
    @Autowired
    RegionDao regionDao;

    @RequestMapping("/findregion")
    @ResponseBody
    public List findByProvince(int cityCode){
        return regionDao.findByCityCode(cityCode);
    }
}
