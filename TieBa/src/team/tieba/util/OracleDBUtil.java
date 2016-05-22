/**
 * 
 */
package team.tieba.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @Description 
 * @author WM
 * @date 2016-3-21 上午10:24:18
 * @version V1.0
 */
public class OracleDBUtil {
	
	private static String oracleDriver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String username = "tieba";
	private static String password = "tieba";
	
	public static Connection getODBconn(){
		
		Connection connection = null;
		
		try {
			
			Class.forName(oracleDriver);
			
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void CloseDBConn(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
