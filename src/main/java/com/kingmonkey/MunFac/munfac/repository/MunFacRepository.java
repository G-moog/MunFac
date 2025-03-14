package com.kingmonkey.MunFac.munfac.repository;

import com.kingmonkey.MunFac.munfac.Entity.Munjae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunFacRepository extends JpaRepository<Munjae, Integer> {

    //문제 생성
    @Override
    <S extends Munjae> S save(S entity);

    //문제 삭제

    @Override
    void deleteById(Integer id);


    //문제 수정


    //문제 조회

}
