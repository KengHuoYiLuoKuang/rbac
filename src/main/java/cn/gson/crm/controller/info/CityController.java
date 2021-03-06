package cn.gson.crm.controller.info;

import cn.gson.crm.common.AjaxResult;
import cn.gson.crm.common.DataGrid;
import cn.gson.crm.common.MySpecification;
import cn.gson.crm.controller.system.RoleController;
import cn.gson.crm.model.dao.CityDao;
import cn.gson.crm.model.domain.City;
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

@RequestMapping("/info/city")
@Controller
public class CityController {

    Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    private CityDao cityDao;

    @Value("${crm.system.super-user-id}")
    Long superUserId;

    @RequestMapping
    public String index() {
        return "/info/city";
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataGrid<City> list(int page, int rows, String city) {
        PageRequest pr = new PageRequest(page - 1, rows);

        Page pageData = cityDao.findAll(new MySpecification<City>().and(
                MySpecification.Cnd.like("city", city)
        ).asc("cityCode"), pr);

        return new DataGrid<>(pageData);
    }
    @RequestMapping("/form")
    public void form(Long id, Model model) {

        if (id != null) {
            ObjectMapper mapper = new ObjectMapper();
            City city = cityDao.findOne(id);
            try {
                model.addAttribute("city", mapper.writeValueAsString(city));
            } catch (JsonProcessingException e) {
                logger.error("json转换错误", e);
            }
        }
    }



    @RequestMapping({"/save", "/update"})
    @Transactional
    @ResponseBody
    public AjaxResult save(@Valid City city) {

        cityDao.save(city);

        return new AjaxResult();
    }

    @RequestMapping("/departs")
    @ResponseBody
    public Iterable<City> departs() {
        return cityDao.findAll();
    }

    @RequestMapping("/delete")
    @Transactional
    @ResponseBody
    public AjaxResult delete(Long id) {
        try {
            cityDao.delete(id);
        } catch (Exception e) {
            return new AjaxResult(false).setMessage(e.getMessage());
        }
        return new AjaxResult();
    }
    @RequestMapping("/findcity")
    @ResponseBody
    public List findByProvince(Long provinceCode){
        return cityDao.findByProvinceCode(provinceCode);
    }
}
