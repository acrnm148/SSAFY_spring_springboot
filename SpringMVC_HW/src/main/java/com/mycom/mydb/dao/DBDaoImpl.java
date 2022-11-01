package com.mycom.mydb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.mydb.dto.User;

@Repository
public class DBDaoImpl implements DBDao{
	
	@Autowired
	DataSource dataSource;

	@Override
	public User userDetail(int employeeId) {
		User dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append(" select * ")
			  .append(" from user where id = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, employeeId);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new User();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setAge(rs.getInt("age"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) { rs.close(); }
				if (pstmt != null) { pstmt.close(); }
				if (con != null) { con.close(); }
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}

	@Override
	public List<User> userList() {
		List<User> list = new ArrayList<User>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql=" select * from emp ";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User dto = new User();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setAge(rs.getInt("age"));
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (con!=null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	@Override
	public int userInsert(User dto) { //return : 성공실패값
		int ret = -1;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append(" insert into user ( id, password, name, email, age ) ")
			  .append(" values (?, ?, ?, ?, ?) ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setInt(5, dto.getAge());
			
			ret = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) { rs.close(); }
				if (pstmt != null) { pstmt.close(); }
				if (con != null) { con.close(); }
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	@Override
	public int userUpdate(User dto) { //return : 성공실패값
		int ret = -1;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append(" update user set password=?, name=?, age=? ")
			  .append(" where id=? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getId());
			
			ret = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) { rs.close(); }
				if (pstmt != null) { pstmt.close(); }
				if (con != null) { con.close(); }
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	@Override
	public int userDelete(int id) { //return : 성공실패값
		int ret = -1;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append(" delete from user ")
			  .append(" where id=? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, id);
			
			ret = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) { rs.close(); }
				if (pstmt != null) { pstmt.close(); }
				if (con != null) { con.close(); }
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
}
