package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionDao extends JpaRepository<Profession,Integer> {
}
