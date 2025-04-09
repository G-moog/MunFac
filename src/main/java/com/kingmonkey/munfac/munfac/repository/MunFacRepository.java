package com.kingmonkey.munfac.munfac.repository;

import com.kingmonkey.munfac.munfac.Entity.Munjae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    List<Munjae> findAllById(Iterable<Integer> integers);

    @Query("SELECT a.munNo FROM Munjae a WHERE a.memberNo=?1 AND a.munNo=?2")	// jpql에서 엔티티 이름은 대소문자까지 완벽히 일치할 것
	List<String> selectMunListbyCate(int memberNo, int munNo);

}