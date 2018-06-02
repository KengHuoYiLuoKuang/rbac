package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.Depart;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartDao extends PagingAndSortingRepository<Depart, Long>, JpaSpecificationExecutor {

    int countByName(String departName);

    Depart findByName(String departName);
}
