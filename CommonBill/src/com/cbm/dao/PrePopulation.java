package com.cbm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cbm.bean.User;
import com.cbm.util.DBUtil;

public class PrePopulation {
	public ArrayList<User> getUserName() throws ClassNotFoundException, SQLException {
		ArrayList<User> al = new ArrayList<User>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String query = "SELECT * FROM user_details ORDER BY user_name";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setUserName(rs.getString(2));
				al.add(temp);
			}
			for (int i = 0; i < al.size(); i++) {
				System.out.println(al.get(i).getUserId() + " "
						+ al.get(i).getUserName());
			}
		} catch (SQLException e) {
		}
		finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(con);
		}
		return al;
	}
	
	public User getUserBean(int userId) throws ClassNotFoundException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		User user = new User();
		try {
			con = DBUtil.getConnection();
			String query = "SELECT * FROM user_details where user_id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
			}
			
		} catch (SQLException e) {
		}
		finally {
				DBUtil.closeResultSet(rs);
				DBUtil.closeStatement(ps);
				DBUtil.closeConnection(con);
		}
		return user;
	}
	
	public int getCurrentBalance(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		int balance=0;
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select account_balance from cb_tranx where "
					+"tranx_id in (select max(tranx_id) from cb_tranx)");
			rs = ps.executeQuery();
			if(rs.next()){
				balance = rs.getInt(1);
			}
		}catch(SQLException e){
			System.out.println("InsideCatchBlockOfGetCurrentBalance");
		}finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(con);
	}
		return balance;
	}
}
