package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationDao extends JpaRepository<Nation,Integer> {
}
