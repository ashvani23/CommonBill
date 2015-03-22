package com.cbm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cbm.bean.Item;
import com.cbm.bean.ItemCategory;
import com.cbm.util.DBUtil;

public class PopulateItem {
	public ArrayList<Item> getItemName() throws ClassNotFoundException {
		ArrayList<Item> itemArrayList = new ArrayList<Item>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String str = "select item_id, item_name, category_id, category_name "
				+ "from daily_items NATURAL JOIN item_category "
				+ "ORDER BY item_name";

		try {
			con = DBUtil.getConnection();
			System.out.println("PopulateItemTryBlock");
			ps = con.prepareStatement(str);
			System.out.println("PopulateItemTryBlock2");
			rs = ps.executeQuery();
			System.out.println("PopulateItemTryBlock3");
			while (rs.next()) {
				Item item = new Item();
				ItemCategory iCategory = new ItemCategory();
				System.out.println("InsideWhileStatement");
				item.setItemId(rs.getInt(1));
				item.setItemName(rs.getString(2));
				iCategory.setCategoryId(rs.getInt(3));
				iCategory.setCategoryName(rs.getString(4));
				item.setItemCategory(iCategory);
				itemArrayList.add(item);
				System.out
						.println("PopulateItemTryBlockWhileLoop ItemAddedToList");
			}
			System.out.println(itemArrayList);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("InsideCatchBlock");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(con);
		}
		return itemArrayList;
	}

	public Item getItemBean(int itemId) throws ClassNotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String str = "select item_id, item_name, category_id, category_name "
				+ "from daily_items NATURAL JOIN item_category "
				+ "where item_id = ?";
		Item item = new Item();
		ItemCategory iCategory = new ItemCategory();

		try {
			con = DBUtil.getConnection();
			System.out.println("PopulateItemTryBlock");
			ps = con.prepareStatement(str);
			ps.setInt(1, itemId);
			rs = ps.executeQuery();
			while (rs.next()) {
				item.setItemId(rs.getInt(1));
				item.setItemName(rs.getString(2));
				iCategory.setCategoryId(rs.getInt(3));
				iCategory.setCategoryName(rs.getString(4));
				item.setItemCategory(iCategory);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("InsideCatchBlock");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(con);
		}
		return item;
	}
}
