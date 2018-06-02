package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceDao extends JpaRepository<Province,Integer> {
}
