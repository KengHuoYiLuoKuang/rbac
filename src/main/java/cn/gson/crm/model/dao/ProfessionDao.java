package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.Nation;
import cn.gson.crm.model.domain.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfessionDao extends PagingAndSortingRepository<Profession, Integer>,JpaRepository<Profession,Integer>, JpaSpecificationExecutor {
}
