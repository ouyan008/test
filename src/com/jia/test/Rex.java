package com.jia.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class Rex {
	
	public static void main(String [] args) throws IOException {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521/pdborcl.localdomain";
		String user ="hr";
		String password = "hr";
//		String sql = "SELECT ? FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES WHERE SALARY = ? AND FIRST_NAME = ?";
//		try (Connection conn =  DriverManager.getConnection(url, user, password);
//			Statement stat = conn.createStatement()) {
//			ResultSet rs = stat.executeQuery(sql);
//			System.out.println(rs);
//			while(rs.next()) {
//				System.out.println(rs.getString(2));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Connection conn = null;
		PreparedStatement stat = null; 
		ResultSet rs = null;
		try {
			OracleDataSource ds = new OracleDataSource();
			ds.setURL(url);
			ds.setUser(user);
			ds.setPassword(password);
			conn = ds.getConnection();
			stat = conn.prepareStatement(sql);
			stat.setInt(1,  3000);
			stat.setString(2, "Kevin");
			rs = stat.executeQuery();
			System.out.println(rs);
			while(rs.next()) {			
			System.out.println(rs.getString(1));
		}									
		//	ResultSetMetaData rmd = rs.getMetaData();
			//	System.out.println(rmd.getColumnName(2));
			
						
			}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {			
				try {
					if (rs != null) rs.close();
		            if (stat !=null) stat.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			
		}

		
	
	} 
}