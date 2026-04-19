package com.nomani.ordermanagement.dao;

import com.nomani.ordermanagement.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
