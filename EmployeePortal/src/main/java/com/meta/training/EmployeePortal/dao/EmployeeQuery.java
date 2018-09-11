package com.meta.training.EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.meta.training.EmployeePortal.mappers.EmployeeMapper;
import com.meta.training.EmployeePortal.modal.Employee;

@Repository
public class EmployeeQuery implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeQuery(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	final static String insertEmployee = " insert into employee (firstName, lastName, dob, gender, primaryContact, emailId,password)"
			+ "values(?,?,?,?,?,?,?)";

	final static String getAllEmployee = "SELECT * FROM employee";

	public static String getAllEmployeeById = "SELECT * FROM employee WHERE empCode=?";

	public static String updateEmployee = "update employee set firstName = ? , lastName = ? , dob = ?, gender = ?  ,emailId= ?, password=?  where"
			+ " empCode = ? ";

	public static String deleteById = " update employee set isActive = false  where empCode = ? ";

	@Override
	public Employee getEmployeeById(int id) {
		return jdbcTemplate.queryForObject(getAllEmployeeById,
				new Object[] { id }, new EmployeeMapper());
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(getAllEmployee, new EmployeeMapper());
	}

	@Override
	public boolean deleteEmployee(int id) {
		return jdbcTemplate.update(deleteById, id) > 0;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		return jdbcTemplate.update(updateEmployee, emp.getFirstName(),
				emp.getLastName(), emp.getDob(), emp.getGender(),
				emp.getEmailId(), emp.getPassword(), emp.getEmpCode()) > 0;
	}

	@Override
	public boolean createEmployee(Employee emp) {
		return jdbcTemplate.update(insertEmployee, emp.getFirstName(),
				emp.getLastName(), emp.getDob(), emp.getGender(),
				emp.getPriamryContact(), emp.getEmailId(), emp.getPassword()) > 0;
	}
}
