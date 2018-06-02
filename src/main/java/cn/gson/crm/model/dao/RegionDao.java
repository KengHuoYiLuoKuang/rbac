package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.City;
import cn.gson.crm.model.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionDao extends JpaRepository<Region,Integer> {
    List findByCityCode(int cityCode);
}
