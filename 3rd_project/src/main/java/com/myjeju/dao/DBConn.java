package com.myjeju.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
		//Field
		String url = "jdbc:oracle:thin:@localhost:1521";
		String user = "scott";
		String pass = "tiger";
		Connection conn;
		Statement stmt;
		PreparedStatement pstmt;
		ResultSet rs;
		
		//Constructor
		public DBConn() {
			try {
				//1�ܰ� - ����̹� �ε�
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2�ܰ� - Connection ��ü ����
				conn = DriverManager.getConnection(url,user,pass);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Method
		public void getStatement() {
			try {
				stmt = conn.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void getPreparedStatement(String sql) {
			try {
				pstmt = conn.prepareStatement(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//close
		public void close() {
			try {
				//6�ܰ� - ��������
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
