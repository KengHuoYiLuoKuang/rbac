package cn.gson.crm.model.dao;

import cn.gson.crm.model.domain.LastName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LastNameDao extends JpaRepository<LastName,Integer> {
    LastName findByLastName(String lastName);
}
