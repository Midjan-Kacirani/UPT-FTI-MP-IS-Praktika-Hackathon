package com.hackathonpraktika.DevManagementSystem.repositories;

import com.hackathonpraktika.DevManagementSystem.model.DevSkillExp;
import com.hackathonpraktika.DevManagementSystem.model.DevSkillExpId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevSkillExpRepository extends JpaRepository<DevSkillExp, DevSkillExpId> {

    @Query(value = "SELECT * FROM DevSkillExp dse JOIN DevSkill ds ON dse.DevSkillId = ds.DevSkillId WHERE LOWER(ds.SkillName) = LOWER(:skillName)", nativeQuery = true)
    List<DevSkillExp> findBySkillName(@Param("skillName") String skillName);

    @Query(value = "SELECT dse.* FROM DevSkillExp dse " +
            "JOIN DevSkill ds ON dse.DevSkillId = ds.DevSkillId " +
            "WHERE LOWER(ds.SkillName) = LOWER(:skillName) " +
            "AND dse.YearOfExp >= :experience", nativeQuery = true)
    List<DevSkillExp> findBySkillAndExperience(@Param("skillName") String skillName, @Param("experience") int experience);
}
