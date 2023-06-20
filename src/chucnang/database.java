package chucnang;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
 
	public static Connection connectdb() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://localhost\\DESKTOP-NJOCC6G:1433;databaseName=da_cua_hang_tap_hoa;encrypt=false";
		     String username="sa";
		     String password="123456";
		     Connection connection=DriverManager.getConnection(url, username, password);
		     return connection;
			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
		
	}
}
