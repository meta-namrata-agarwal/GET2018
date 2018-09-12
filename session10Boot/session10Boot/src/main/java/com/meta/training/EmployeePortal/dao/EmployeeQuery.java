package com.meta.training.EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.meta.training.EmployeePortal.mappers.EmployeeMapper;
import com.meta.training.EmployeePortal.mappers.JobDetailsMapper;
import com.meta.training.EmployeePortal.modal.Employee;
import com.meta.training.EmployeePortal.modal.JobDetails;

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

	public static String searchEmpByName = "select * from employee where firstName= ?";

	public static String loginEmployee = "select * from employee where emailId=? and password=?";

	public static String editEmpProfile = "update employee set primaryContact= ?, secondaryContact=?, skypeId=?, password=? where empCode=?";

	public static String jobDetails = "select jd.dateOfJoining, jd.totalExp,jt.jobTitle,p.projectName,e1.firstName,e2.firstName from jobdetails jd"
			+ " inner join jobtitlemaster jt"
			+ " inner join project p"
			+ " inner join employee e1"
			+ " inner join employee e2 "
			+ " where jd.empCode=? and jt.jobCode=jd.jobCode and e1.empCode=jd.reportingManagerId and e2.empCode=jd.teamLeadId and p.projectId=jd.currProjId";
	
	public static String jobDetailsById="select * from jobtitlemaster where empCode=?";

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
				emp.getPrimaryContact(), emp.getEmailId(), emp.getPassword()) > 0;
	}

	@Override
	public List<Employee> empByName(String firstName) {
		return jdbcTemplate.query(searchEmpByName, new EmployeeMapper());
	}

	@Override
	public Employee loginParameter(String email, String password) {
		return jdbcTemplate.queryForObject(loginEmployee, new Object[] { email,
				password }, new EmployeeMapper());
	}

	@Override
	public boolean editEmpProfile(Employee emp) {
		return jdbcTemplate.update(editEmpProfile, emp.getPrimaryContact(),
				emp.getSecondaryContact(), emp.getSkypeId(), emp.getPassword(),
				emp.getEmpCode()) > 0;
	}
	@Override
	public JobDetails jobDetailsbyId(int id) {
		return jdbcTemplate.queryForObject(jobDetailsById, new Object[] {id }, new JobDetailsMapper());
	}
}
