package com.spaneos.online_shopping;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class load_products {

	public static ArrayList<productBean> load() throws SQLException, InstantiationException, IllegalAccessException {
		Connection con1 = null;
		PreparedStatement ps_sql = null;
		ResultSet rs = null;
		productBean pb = null;
		con1 = (Connection) JDBCHelper.getConnection();
		ArrayList<productBean> plist = new ArrayList<productBean>();
		ps_sql = con1.prepareStatement("select * from products");
		ps_sql.execute();
		rs = ps_sql.getResultSet();
		while (rs.next()) {
			pb = new productBean();
			pb.setPname(rs.getString("pname"));
			pb.setPcat(rs.getString("pcat"));
			plist.add(pb);
		}

		System.out.println(plist);
		return plist;
	}

	public static ArrayList<productBean> load(String pcat)
			throws SQLException, InstantiationException, IllegalAccessException {
		Connection con1 = null;
		PreparedStatement ps_sql = null;
		ResultSet rs = null;
		productBean pb = null;
		con1 = (Connection) JDBCHelper.getConnection();
		ArrayList<productBean> plist = new ArrayList<productBean>();
		ps_sql = con1.prepareStatement("select * from products where pcat=?");
		ps_sql.setString(1, pcat);
		ps_sql.execute();
		rs = ps_sql.getResultSet();
		while (rs.next()) {
			pb = new productBean();
			pb.setPname(rs.getString("pname"));
			pb.setPcat(rs.getString("pcat"));
			pb.setPdes(rs.getString("pdes"));
			pb.setPno(rs.getInt("pno"));
			pb.setPrice(rs.getInt("price"));
			plist.add(pb);
		}

		System.out.println(plist);
		return plist;
	}

}