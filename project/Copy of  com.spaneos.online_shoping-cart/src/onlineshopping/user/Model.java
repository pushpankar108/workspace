package onlineshopping.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import online_shopping.productBean;

public class Model {
	static PreparedStatement ps_sql = null;

	/**
	 * mathod to validate user with users table
	 * @param bean
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	public static boolean validate(UserBean bean) throws InstantiationException, IllegalAccessException, SQLException {
		Connection con1 = JDBCHelper.getConnection();
		ResultSet rs = null;

		ps_sql = con1.prepareStatement("select * from users where name=? and password=?");
		ps_sql.setString(1, bean.getName());
		ps_sql.setString(2, bean.getPass_word());
		boolean check = ps_sql.execute();
		System.out.println("here");
		rs = ps_sql.getResultSet();
		if (rs.next()) {
			System.out.println(rs.getString("name"));
			return true;
		} else
			return false;
	}

	/**
	 * 
	 * User method to add to cart
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */

	public List<productBean> addCart(String[] names) throws InstantiationException, IllegalAccessException {
		List<productBean> cart = new ArrayList<productBean>();
		Connection con = null;
		PreparedStatement ps_ins = null;
		ResultSet rs = null;
		try {

			con = JDBCHelper.getConnection();
			if (con != null) {
				ps_ins = con.prepareStatement("select * from product where pname=?");
				System.out.println(names.length);
				for (int i = 0; i < names.length; i++) {
					ps_ins.setString(1, names[i]);
					ps_ins.execute();
					System.out.println("After execute");
					rs = ps_ins.getResultSet();
					while (rs.next()) {
						productBean p = new productBean();
						String str = rs.getString("pname");
						int price = rs.getInt("price");
						int item = 1;
						p.setPname(str);
						p.setPrice(price);
						p.setItem(item);
						cart.add(p);
						System.out.println("after adding to list");
						System.out.println(cart);
					}

				}
				System.out.println("after for loop");

			}
		} catch (SQLException e) {
			e.getMessage();

		} finally {
			JDBCHelper.close(rs);
			JDBCHelper.close(con);
		}
		return cart;
	}

	/**
	 * 
	 * User method to add to cart
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static String addtocart(String u_name, String p_name, int pric, int stocks, int item)
			throws InstantiationException, IllegalAccessException {
		Connection con = null;
		PreparedStatement ps_ins = null, ps_sql = null;
		ResultSet rs = null, rs1 = null;
		try {
			int requested = 0;
			con = JDBCHelper.getConnection();
			if (con == null)
				return "Oops theres been a problem. Cannot connect to DB! Contact Admin!!";
			else {
				System.out.println("check");
				System.out.println(u_name);
				System.out.println(p_name);
				ps_sql = con.prepareStatement("select * from cart where pname = ? and uname=? and status='In Cart'");
				System.out.println("checking duplicate");
				ps_sql.setString(1, p_name);
				ps_sql.setString(2, u_name);
				System.out.println("after setting ");

				ps_sql.execute();

				rs = ps_sql.getResultSet();
				System.out.println(rs);
				if (rs.next()) {

					requested = rs.getInt("items");
					System.out.println(requested);
					System.out.println("checking");
					ps_sql = con.prepareStatement("select * from products where pname = ?");
					ps_sql.setString(1, p_name);
					ps_sql.execute();

					rs = ps_sql.getResultSet();

					if (rs.next()) {
						System.out.println("in update");
						String currnt = rs.getString("available");
						System.out.println(currnt);
						int current = Integer.parseInt(currnt);
						int checkk = item + requested;
						if (checkk <= current) {
							ps_ins = con.prepareStatement("update cart set items=?,price=? where pname = ?");
							ps_ins.setInt(1, (item + requested));
							ps_ins.setInt(2, ((item + requested) * pric));
							ps_ins.setString(3, p_name);
							ps_ins.execute();
							rs1 = ps_sql.getResultSet();
							return "updated successfully";
						} else {
							return "Produst already exist in cart. stock not available";
						}

					}
				} else {

					int total = pric * item;
					System.out.println("");
					ps_ins = con.prepareStatement("insert into cart(uname,pname,price,items,status) values(?,?,?,?,?)");
					ps_ins.setString(1, u_name);
					ps_ins.setString(2, p_name);

					ps_ins.setInt(3, total);
					ps_ins.setInt(4, item);
					ps_ins.setString(5, "In Cart");
					ps_ins.execute();

					return "added to cart successfully";

				}
			}
		} catch (SQLException e) {
			e.getMessage();

		} finally {
			JDBCHelper.close(rs);
			JDBCHelper.close(con);
		}
		return "Product adding to Cart Failed";
	}

	/**
	 * 
	 * User method to get cart details
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static List<CartBean> getCartDetails(String uname) throws InstantiationException, IllegalAccessException {
		List<CartBean> c = new ArrayList<CartBean>();
		Connection con = null;
		PreparedStatement ps_sql = null;
		ResultSet rs = null;
		try {

			con = JDBCHelper.getConnection();
			if (con != null) {
				ps_sql = con.prepareStatement("select * from cart where uname=? and status='In Cart' ");
				ps_sql.setString(1, uname);
				ps_sql.execute();

				rs = ps_sql.getResultSet();
				CartBean cart = null;
				while (rs.next()) {
					cart = new CartBean();
					cart.setPname(rs.getString("pname"));
					cart.setPrice(rs.getString("price"));
					cart.setItems(rs.getString("items"));

					c.add(cart);
				}
			}
			System.out.println(c);
		} catch (SQLException e) {
			e.getMessage();

		}
		return c;
	}

	/**
	 * 
	 * User method to delete items from cart
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public String deleteFromCart(String uname, String pname) throws InstantiationException, IllegalAccessException {
		Connection con = null;
		PreparedStatement ps_ins = null;

		try {

			con = JDBCHelper.getConnection();
			if (con == null)
				return "Oops theres been a problem. Cannot connect to DB! Contact Admin!!";

			else {

				ps_ins = con.prepareStatement("delete from cart where pname=? and uname=?");
				ps_ins.setString(1, pname);
				ps_ins.setString(2, uname);

				ps_ins.execute();

				return "SUCCESS";

			}
		}

		catch (SQLException e) {
			e.getMessage();
			return "Oops something bad happened msg = " + e.getMessage();
		}

	}

	/**
	 * 
	 * User method to update cart details when checkout is presseds
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static String updateCart(String uname) throws InstantiationException, IllegalAccessException {
		Connection con = null;
		PreparedStatement ps_sql = null, ps_ins = null;
		ResultSet rs = null;
		try {

			con = JDBCHelper.getConnection();
			if (con != null) {
				ps_sql = con.prepareStatement("update cart  set status=? where uname = ?");
				ps_sql.setString(1, "Purchased");
				ps_sql.setString(2, uname);
				ps_sql.execute();
				ResultSet rs1 = ps_sql.getResultSet();
				ps_ins = con.prepareStatement("select * from cart where uname=? and pname=pname and status='In Cart'");
				ps_ins.setString(1, uname);
				ps_ins.execute();
				System.out.println("after select execution");
				rs = ps_ins.getResultSet();
				if (rs.next()) {
					System.out.println("inside RS");
					String pname = rs.getString("pname");
					int stock = rs1.getInt("available");
					System.out.println(stock);
					int item = rs.getInt("items");
					System.out.println(item);
					if (stock > item) {
						int total = stock - item;
						ps_ins = con.prepareStatement("update products  set available=? where pname = ?");
						ps_ins.setInt(1, total);
						ps_ins.setString(2, pname);
						ps_ins.execute();
						System.out.println("After Product stock Update");
						return "SUCCESS";
					} else {
						return " Product " + pname + " Has only stock " + String.valueOf(stock);
					}

				}
			}
		} catch (SQLException e) {
			e.getMessage();

		}
		return null;
	}

	/**
	 * method to load cart item of specific users................
	 * 
	 * @param s1
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static ArrayList<CartBean> loadcart(String s1) throws InstantiationException, IllegalAccessException {
		ArrayList<CartBean> c = new ArrayList<CartBean>();

		Connection con = null;
		PreparedStatement ps_sql = null;
		ResultSet rs = null;
		try {

			con = JDBCHelper.getConnection();
			if (con != null) {
				System.out.println(s1 + "hereeeee");
				ps_sql = con.prepareStatement("select * from cart  where uname=?");
				ps_sql.setString(1, s1);
				ps_sql.executeQuery();
				rs = ps_sql.getResultSet();
				CartBean cart = null;
				while (rs.next()) {
					cart = new CartBean();
					cart.setPname(rs.getString("pname"));
					cart.setPrice(rs.getString("price"));
					cart.setItems(rs.getString("items"));
					cart.setItems(rs.getString("status"));

					c.add(cart);
				}
			}
			System.out.println(c);
		} catch (SQLException e) {
			e.getMessage();

		}
		return c;
	}

	/**
	 * method to register user.....
	 * 
	 * @param bean
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static String register(RegisterBean bean) throws InstantiationException, IllegalAccessException {
		System.out.println("Model->register() bean = " + bean);

		String msg = bean.validate();
		if (msg.equals("SUCCESS")) {
			// input validation has succeeded...
			System.out.println("Model->register(), registration has succeded!");

			// apply business validation!

			Connection con = null;
			PreparedStatement ps_sql = null, ps_ins = null;
			ResultSet rs = null;
			try {

				con = JDBCHelper.getConnection();
				if (con == null)
					return "Oops theres been a problem. Cannot connect to DB! Contact Admin!!";
				else {
					System.out.println("check");
					ps_sql = con.prepareStatement("select * from users where email = ?");
					ps_sql.setString(1, bean.getEmail());

					ps_sql.execute();

					rs = ps_sql.getResultSet();
					if (rs.next())
						return "You duplicate!!Enter new email id. ";
					else {
						// business validation has succeeded.
						// store data
						System.out.println("register");
						ps_ins = con.prepareStatement("insert into users(name,email,password) values(?,?,?)");
						ps_ins.setString(1, bean.getName());
						System.out.println("im herererere");
						ps_ins.setString(2, bean.getEmail());
						ps_ins.setString(3, bean.getPass());
						ps_ins.execute();

						return "SUCCESS";
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return "Oops something bad happened msg = " + e.getMessage();
			} finally {
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sql);
				JDBCHelper.close(con);
			}

		} else {
			System.out.println("Model->register(), registration has failed! msg = " + msg);

			return msg;
		}

	}

	/**
	 * 
	 * User method to delete items from cart
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static String deleteFromCart1(String uname, String pname)
			throws InstantiationException, IllegalAccessException {
		Connection con = null;
		PreparedStatement ps_ins = null;

		try {
			System.out.println("deleting");
			con = JDBCHelper.getConnection();
			if (con == null)
				return "Oops theres been a problem. Cannot connect to DB! Contact Admin!!";

			else {
				System.out.println(uname + "" + pname);
				ps_ins = con.prepareStatement("delete from cart where uname=? and pname=?");

				ps_ins.setString(1, uname);
				ps_ins.setString(2, pname);
				ps_ins.execute();

				System.out.println("deleted");
				return "SUCCESS";

			}
		}

		catch (SQLException e) {
			e.getMessage();
			return "Oops something bad happened msg = " + e.getMessage();
		}

	}
}