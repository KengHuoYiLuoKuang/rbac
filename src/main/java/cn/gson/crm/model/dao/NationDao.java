package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.Nation;
import cn.gson.crm.model.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationDao extends PagingAndSortingRepository<Nation, Integer>,JpaRepository<Nation,Integer>, JpaSpecificationExecutor {

}
