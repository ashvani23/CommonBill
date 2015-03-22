package com.cbm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cbm.bean.Transaction;
import com.cbm.util.DBUtil;

public class TranxDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public int InsertTranx(Transaction transaction, int balance) {
		String query = "insert into cb_tranx (tranx_id,user_id,item_id,tranx_type,tranx_date,"
				+"tranx_amount,account_balance,tranx_summary)"
				+" values(tranx_seq.nextval,?,?,?,TO_DATE(SYSDATE, 'DD-MM-YYYY'),?,?,?)";
		int flag=0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, transaction.getUser().getUserId());
			ps.setInt(2, transaction.getItem().getItemId());
			ps.setInt(3, 0);
			ps.setInt(4, transaction.getAmount());
			ps.setInt(5, balance - transaction.getAmount());
			ps.setString(6, transaction.getTranxSummary());
			flag = ps.executeUpdate();
			con.commit();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(con);
	}
		return flag;
	}

}
