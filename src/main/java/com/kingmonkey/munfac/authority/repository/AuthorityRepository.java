package com.kingmonkey.munfac.authority.repository;

import com.kingmonkey.munfac.authority.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    Authority findByAuthNo(int authNo);
}
