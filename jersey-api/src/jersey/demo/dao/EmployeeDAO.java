package jersey.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import jersey.demo.dto.EmployeeDTO;

import org.apache.log4j.Logger;

/**
 * Date 14.Mar.2016
 * 
 * @version 1.0
 * @author Murugesan Rathinam
 * @since 1.0
 *
 *        Email : murugesamkce@gmail.com
 */
public class EmployeeDAO {
	private static Logger logger = Logger.getLogger(EmployeeDAO.class);
	private Connection connection = null;
	PreparedStatement prepareStatement = null;
	/**
	 * @param connection
	 */
	public EmployeeDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @return List of Employees
	 */
	public List<EmployeeDTO> getAllEmployees() throws Exception {
		List<EmployeeDTO> employees = null;
		String query = "select emp_id,emp_name,emp_email,emp_address from employee_t";
		try {
			prepareStatement = connection.prepareStatement(query);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				EmployeeDTO employee = new EmployeeDTO();
				employee.setId(resultSet.getInt("emp_id"));
				employee.setName(resultSet.getString("emp_name"));
				employee.setAddress(resultSet.getString("emp_address"));
				employee.setEmail(resultSet.getString("emp_email"));
			}
		} catch (Exception e) {
			logger.error("Error occurs , While trying to find all employees.",
					e);
		} finally {
			prepareStatement.close();
		}
		return employees;
	}

	/**
	 * @param id
	 * @return Employee 
	 */
	public void getEmployee(int id) {
		
		//get Employee by id stuff
	}
	

}
