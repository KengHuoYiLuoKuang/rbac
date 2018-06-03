package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.People2016;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface People2016Dao extends JpaRepository<People2016,Integer> {
}
