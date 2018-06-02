package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDao extends JpaRepository<City,Integer> {
    List findByProvinceCode(Integer provinceCode);
}
