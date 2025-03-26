package com.kingmonkey.munfac.munfac.repository;

import com.kingmonkey.munfac.munfac.Entity.Munjae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MunFacRepository extends JpaRepository<Munjae, Integer> {

    //문제 생성
    @Override
    <S extends Munjae> S save(S entity);

    //문제 삭제
    @Override
    void deleteById(Integer munNo);


    //문제 수정


    //문제 조회
    @Override
    Optional<Munjae> findById(Integer munNo);

}