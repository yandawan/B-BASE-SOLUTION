package com.muke.dao;

import com.muke.entity.SkillGood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillGoodRepository extends JpaRepository<SkillGood,Long> {
    @Query(value="select * from skill_goods where status=1 and num>0 and stock_count>0 and id not in (?1)",nativeQuery = true)
    List<SkillGood> findSkill(List<Long> ids);

    @Query(value="select * from skill_goods where status=1 and num>0 and stock_count>0",nativeQuery = true)
    List<SkillGood> findSkillAll();
}
