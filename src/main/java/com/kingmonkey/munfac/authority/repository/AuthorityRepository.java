package com.kingmonkey.munfac.authority.repository;

import com.kingmonkey.munfac.authority.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    @Override
    Optional<Authority> findById(Integer authorityNo);
}
