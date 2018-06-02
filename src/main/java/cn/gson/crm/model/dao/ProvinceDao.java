package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.Province;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceDao extends PagingAndSortingRepository<Province, Long>, JpaSpecificationExecutor {

}
