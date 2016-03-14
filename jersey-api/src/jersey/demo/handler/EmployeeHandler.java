package jersey.demo.handler;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jersey.demo.dao.EmployeeDAO;
import jersey.demo.dto.EmployeeDTO;
import jersey.demo.util.JDBC;

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
@Path("/employee")
public class EmployeeHandler {
	private static Logger logger = Logger.getLogger(EmployeeHandler.class);
	private Connection connection = null;
	private EmployeeDAO epmloyeeDao = null;
	/**
	 * @return List of employees
	 * @throws Exception
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findAllEmployees")
	public List<EmployeeDTO> findAll() throws Exception {
		List<EmployeeDTO> employees = null;
		try {
			connection = JDBC.getConnection();
			epmloyeeDao = new EmployeeDAO(connection);
			employees = epmloyeeDao.getAllEmployees();
		} catch (Exception e) {
			logger.error("Error occurs while trying to get all employees.", e);
		} finally {
			if (!connection.isClosed()) {
				connection.close();
			}
		}
		return employees;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findById")
	public EmployeeDTO findById(int id) throws Exception{
		EmployeeDTO employee =null;
		try {
			connection = JDBC.getConnection();
			epmloyeeDao = new EmployeeDAO(connection);
			epmloyeeDao.getEmployee(id);
		} catch (Exception e) {
			logger.error("Error occurs , While trying to find employee by id.",e);
		} finally {
			connection.close();
		}
		return employee;
	}
}
