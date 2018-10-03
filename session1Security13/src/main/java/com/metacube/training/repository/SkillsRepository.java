package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.model.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Integer>{


	@Modifying
	@Query("update Skills set isActive=false where id= ?1")
	public int deleteSkills(int id);
	
	public Skills findBySkillName(String skillName);
}
