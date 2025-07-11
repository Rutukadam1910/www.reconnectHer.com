package com.reconnectHer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reconnectHer.module.Register;
@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer>{
	Register findByUsername(String username);

}
