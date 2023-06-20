package chucnang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ketnoisql {
public static void main (String[]args) {
	
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://localhost\\DESKTOP-NJOCC6G:1433;databaseName=da_cua_hang_tap_hoa;encrypt=false";
	     String username="sa";
	     String password="123456";
	     Connection connection=DriverManager.getConnection(url, username, password);
	 String sql="select * from tbl_hang_hoa";
	 Statement statement= connection.createStatement();
	 ResultSet cs=statement.executeQuery(sql);
	 while(cs.next())
	 {
		 System.out.println(cs.getString(1));
		 System.out.println(cs.getString(2));
	 }
	    
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
