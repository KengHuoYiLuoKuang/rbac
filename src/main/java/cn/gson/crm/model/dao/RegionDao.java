package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.City;
import cn.gson.crm.model.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RegionDao extends PagingAndSortingRepository<Region, Long>, JpaSpecificationExecutor {
    List findByCityCode(Long cityCode);
}
