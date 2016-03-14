package jersey.demo.util;
/**
 * Date 14.Mar.2016
 * @version 1.0
 * @author Murugesan Rathinam
 * @since 1.0
 *
 * Email : murugesamkce@gmail.com
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class JDBC {
	private static Logger logger = Logger.getLogger(JDBC.class);
	private static final Properties property = new Properties();
	/**
	 * @return Connection object
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws IOException,
			ClassNotFoundException, SQLException {
		Connection connection = null;
		InputStream jdbcResourceStream = null;
		try{
			jdbcResourceStream = JDBC.class
				.getResourceAsStream("/jdbc.properties");
		property.load(jdbcResourceStream);
		Class.forName(property.getProperty("IDNS_JDBC_DRIVER_CLASS"));
		connection = DriverManager.getConnection(
				property.getProperty("JDBC_URL"),
				property.getProperty("JDBC_USERNAME"),
				property.getProperty("JDBC_PASSWORD"));
		logger.info("Connection established successfully.");
		}catch(Exception e){
			logger.error("Error occurs while trying to establish SQL Connection",e);
		}finally{
			jdbcResourceStream.close();
		}
		return connection;
	}
}
