package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Modifying
	@Query("update Employee set isActive=false where empCode= ?1")
	public int deleteEmployee(int id);

	public Employee findByEmailIdAndPassword(String emailId, String password);

	public Employee findByEmailId(String emailId);

	@Query("select e from Employee e WHERE CONCAT(firstName,' ',lastName) LIKE :input AND isActive=1")
	public List<Employee> search(@Param("input")String input);
}
