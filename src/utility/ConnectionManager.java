package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
	String driver ,url,username,password;
	Connection con=null;
	Properties p= new Properties();
	p=loadPropertiesFile();
	driver=p.getProperty("driver");
	url=p.getProperty("url");
	username=p.getProperty("username");
	password=p.getProperty("password");
	Class.forName(driver);
	con=DriverManager.getConnection(url,username,password);
		return con;
		
	}
	public static Properties loadPropertiesFile() throws IOException {
		
		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
	in.close();
	return prop;
		
	}
}
