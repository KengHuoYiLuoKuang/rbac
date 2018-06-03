package cn.gson.crm.controller.info;

import cn.gson.crm.dto.People2016Dto;
import cn.gson.crm.model.dao.*;
import cn.gson.crm.model.domain.People2016;
import cn.gson.crm.model.domain.Province;
import cn.gson.crm.model.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/info/people2016")
@Controller
public class People2016Controller {
    @Autowired
    People2016Dao people2016Dao;
    @Autowired
    LastNameDao lastNameDao;
    @Autowired
    NationDao nationDao;
    @Autowired
    ProvinceDao provinceDao;
    @Autowired
    CityDao cityDao;
    @Autowired
    RegionDao regionDao;
    @Autowired
    ProfessionDao professionDao;

    @RequestMapping("/save")
    @ResponseBody
    public String save(People2016Dto people2016Dto){
        System.out.println(people2016Dto);
        People2016 people2016=new People2016();
        people2016.setIdNumber(people2016Dto.getIdCardNumber());
        people2016.setLastName(people2016Dto.getRealName().substring(0,1));
        people2016.setFirstName(people2016Dto.getRealName().substring(1));
        people2016.setLastNameCode(lastNameDao.findByLastName(people2016Dto.getRealName().substring(0,1)).getLastNameCode());
        people2016.setGender(people2016Dto.getGender());
        people2016.setAge(people2016Dto.getAge());
        people2016.setAgeRangeCode(people2016Dto.getAge()/4);
        //名族
        people2016.setNationCode(people2016Dto.getNation());
        people2016.setNation(nationDao.findOne(people2016Dto.getNation()).getNation());
        //县
        people2016.setProvinceCode(people2016Dto.getProvince());
        people2016.setProvince(provinceDao.findOne((long) people2016Dto.getProvince()).getProvince());
        //市
        people2016.setCityCode(people2016Dto.getCity());
        people2016.setCity(cityDao.findOne((long) people2016Dto.getCity()).getCity());
        //区
        people2016.setRegionCode(people2016Dto.getRegion());
        people2016.setRegion(regionDao.findOne((long) people2016Dto.getRegion()).getRegion());
        //职业
        people2016.setProfessionCode(people2016Dto.getProfession());
        people2016.setProfession(provinceDao.findOne((long) people2016Dto.getProvince()).getProvince());

        people2016.setUrban((byte) (people2016Dto.isUrban()?1:0));
        people2016.setFloating((byte) (people2016Dto.isFloating()?1:0));


        System.out.println(people2016);
        people2016Dao.save(people2016);
        return "成功";
    }
}
