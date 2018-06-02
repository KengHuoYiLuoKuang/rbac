package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.City;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends PagingAndSortingRepository<City, Long>, JpaSpecificationExecutor {

}
