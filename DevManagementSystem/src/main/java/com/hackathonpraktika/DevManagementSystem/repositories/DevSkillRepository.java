package com.hackathonpraktika.DevManagementSystem.repositories;

import com.hackathonpraktika.DevManagementSystem.model.DevSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DevSkillRepository extends JpaRepository<DevSkill, Long> {

    @Query(value = "SELECT * FROM DevSkill WHERE LOWER(SkillName) = LOWER(:skillName)", nativeQuery = true)
    DevSkill findBySkillNameIgnoreCase(@Param("skillName") String skillName);
}