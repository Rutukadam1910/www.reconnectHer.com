package com.reconnectHer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reconnectHer.module.Funding;
@Repository
public interface FundingRepo extends JpaRepository<Funding, Integer>{

}
