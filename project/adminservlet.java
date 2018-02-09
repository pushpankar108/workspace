package com.spaneos.online_shopping;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see Servlet#destroy()
	 */

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse *
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ppname = null;
		System.out.println("URI" +request.getRequestURI());
		try {

			String uri = request.getRequestURI(); 
			// based on uri, apply controlling login for forwarding

			RequestDispatcher rd = null;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			if (uri.contains("/AdminHome.Ado")) {
				rd = request.getRequestDispatcher("adminHome.jsp");
				rd.forward(request, response);
			}

			// after admin login data retrieval from database

			if (uri.contains("/login.Ado")) {

				LoginBean bean = (LoginBean) request.getAttribute("log");
				String res = bean.validate();
				if (res.equals("SUCCESS")) {
					Connection con1 = null;
					PreparedStatement ps_sql = null;
					ResultSet rs = null;
					CategoryBean cb = null;
					productBean pb = null;
					out.println("Checking.....");
					try {
						con1 = (Connection) JDBCHelper.getConnection();
						if (con1 == null)
						{
							out.println("Database not found!!!");
						}
						else {
							ArrayList<CategoryBean> list = new ArrayList();
							list = load_data.load();
							request.setAttribute("catList", list);
							ArrayList<productBean> plist = new ArrayList();
							plist = load_products.load();
							out.println(plist);
							request.setAttribute("productList", plist);
							rd = request.getRequestDispatcher("admin_page.jsp");
							rd.forward(request, response);
						}
					} catch (SQLException e) {
						e.printStackTrace();
						out.println("something bad happened msg = " + e.getMessage());
					}
					HttpSession session = request.getSession(true);
					session.setAttribute("user", bean.getUid());
					rd = request.getRequestDispatcher("admin_page.jsp");
					rd.forward(request, response);
				} else {
					out.println("<script type=\"text/javascript\">");
					
					out.println("alert('username or password is incorrect');");
					out.println("location='adminHome.jsp';");
					out.println("</script>");
					
				}
			}

			/*if (uri.contains("/product.Ado")) {

			}*/

			// Adding New Category

			if (uri.contains("/addCategory.Ado")) {

				CategoryBean cbean = (CategoryBean) request.getAttribute("logcat");

				Connection con1 = null;
				PreparedStatement ps_ins = null;
				ResultSet rs = null;

				try {
					con1 = (Connection) JDBCHelper.getConnection();
					if (con1 == null)
						out.println("Oops theres been a problem. Cannot connect to DB!!!");
					else {
						ps_ins = con1.prepareStatement("select * from catogeries where cname=? ");
						ps_ins.setString(1, cbean.getCat());
						ps_ins.execute();
						rs = ps_ins.getResultSet();
						if (rs.next()) {
							out.println("<script type=\"text/javascript\">");
							out.println("alert('Category already present');");
							out.println("location='error.jsp';");
							out.println("</script>");
						} else {
							boolean add = model.addCategory(cbean);
							ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
							list = load_data.load();
							request.setAttribute("catList", list);
							ArrayList<productBean> plist = new ArrayList<productBean>();
							plist = load_products.load();
							System.out.println(plist);
							request.setAttribute("productList", plist);
							rd = request.getRequestDispatcher("admin_page.jsp");
							rd.forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("Oops something bad happened msg = " + e.getMessage());
				}
			}

			// Adding New Product

			if (uri.contains("/addProduct.Ado")) {
				Connection con1 = null;
				PreparedStatement ps_ins = null;
				productBean pbean = (productBean) request.getAttribute("logcat");
				System.out.println("product bean  "+pbean);
				productBean pb = null;
				CategoryBean cb = null;
				ResultSet rs = null;
				try {
					con1 = (Connection) JDBCHelper.getConnection();
					if (con1 == null)
						out.println("Oops there has been a problem. Cannot connect to DB!!!");
					else {
						ps_ins = con1.prepareStatement("select * from products where pname=? ");
						ps_ins.setString(1, pbean.getPname());
						ps_ins.execute();
						rs = ps_ins.getResultSet();
						if (rs.next()) {
							out.println("<script type=\"text/javascript\">");
							out.println("alert('Product already present');");
							out.println("location='error.jsp';");
							out.println("</script>");
						} else {
							boolean add = model.addProduct(pbean);
							System.out.println("hello");
							ArrayList<CategoryBean> list = new ArrayList();
							list = load_data.load();
							
							request.setAttribute("catList", list);
							ArrayList<productBean> plist = new ArrayList();
							plist = load_products.load();
							System.out.println(plist);
							System.out.println("list of categories "+list);
							request.setAttribute("catList", list);
							request.setAttribute("productList", plist);
							rd = request.getRequestDispatcher("addProduct.jsp");
							rd = request.getRequestDispatcher("admin_page.jsp");
							rd.forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("Oops something bad happened msg = " + e.getMessage());
				}
			}

			// deleting the specific category

			if (uri.contains("/delete.Ado")) {
				String s1 = request.getParameter("catval");
				System.out.println(s1);
				Connection con1 = null;
				PreparedStatement ps_sql = null, ps_ins = null;
				ResultSet rs = null;
				productBean pbean = (productBean) request.getAttribute("logcat");
				productBean Pb = null;
				CategoryBean cb = null;
				try {
					con1 = (Connection) JDBCHelper.getConnection();
					if (con1 == null)
						out.println("Oops  been has a problem. Cannot connect to DB!!!");
					else {

						boolean delete = model.deleteCategory(s1);
						ArrayList<CategoryBean> list = new ArrayList();
						list = load_data.load();
						request.setAttribute("catList", list);
						ArrayList<productBean> plist = new ArrayList();
						plist = load_products.load();
						System.out.println(plist);
						request.setAttribute("productList", plist);
						rd = request.getRequestDispatcher("admin_page.jsp");
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("Oops something bad happened msg = " + e.getMessage());
				}
			}

			// editing category

			if (uri.contains("/edit.Ado")) {
				String s1 = request.getParameter("catval");
				System.out.println(s1);
				Connection con1 = null;
				PreparedStatement ps_sql = null, ps_ins = null;
				ResultSet rs = null;
				productBean pbean = (productBean) request.getAttribute("logcat");
				productBean Pb = null;
				CategoryBean cb = null;
				ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
				ArrayList<productBean> plist = new ArrayList<productBean>();
				try {
					con1 = (Connection) JDBCHelper.getConnection();
					if (con1 == null)
						out.println("Oops theres been a problem. Cannot connect to DB!!!");
					else {
						System.out.println("hellodelete");

						ps_sql = con1.prepareStatement("select * from catogeries where cname=?");
						ps_sql.setString(1, s1);
						ps_sql.execute();
						rs = ps_sql.getResultSet();
						while (rs.next()) {
							cb = new CategoryBean();
							cb.setCat(rs.getString("cname"));
							cb.setDes(rs.getString("description"));
							list.add(cb);
						}

						System.out.println(list);
						request.setAttribute("catList", list);
						rd = request.getRequestDispatcher("category_edit.jsp");
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("Oops something bad happened msg = " + e.getMessage());
				}
			}

			// edit category

			if (uri.contains("/edit1.Ado")) {
				String s1 = request.getParameter("catval");
				System.out.println(s1);
				Connection con1 = null;
				PreparedStatement ps_sql = null, ps_ins = null;
				ResultSet rs = null;
				CategoryBean cbean = (CategoryBean) request.getAttribute("logcat");
				productBean Pb = null;
				CategoryBean cb = null;
				try {
					con1 = (Connection) JDBCHelper.getConnection();
					if (con1 == null)
						out.println("Oops theres been a problem. Cannot connect to DB!!!");
					else {
						System.out.println("hellodelete");
						out.println("success");
						ps_sql = con1.prepareStatement("update catogeries set description=? where cname=?");
						ps_sql.setString(1, cbean.getDes());
						ps_sql.setString(2, cbean.getCat());
						System.out.println(cbean.getDes());
						System.out.println(cbean.getCat());
						boolean i = ps_sql.execute();
						System.out.println("HELLOOOOO");
						rs = ps_sql.getResultSet();

						System.out.println(i);

						out.println("success");
						ArrayList<CategoryBean> list = new ArrayList();
						list = load_data.load();
						request.setAttribute("catList", list);
						ArrayList<productBean> plist = new ArrayList();
						plist = load_products.load();
						System.out.println(plist);

						System.out.println(list);
						request.setAttribute("catList", list);
						request.setAttribute("productList", plist);
						
						rd = request.getRequestDispatcher("admin_page.jsp");
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("Oops something bad happened msg = " + e.getMessage());
				}
			}

			// method to add new product to product table

			if (uri.contains("/addProduct1.Ado")) {
				String s1 = request.getParameter("catval");
				System.out.println(s1);
				Connection con1 = null;
				PreparedStatement ps_sql = null, ps_ins = null;
				ResultSet rs = null;
				productBean pbean = (productBean) request.getAttribute("logcat");
				productBean pb = null;
				CategoryBean cb = null;
				ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
				ArrayList<productBean> plist = new ArrayList<productBean>();
				try {
					con1 = (Connection) JDBCHelper.getConnection();
					if (con1 == null)
						out.println("Oops theres been a problem. Cannot connect to DB!!!");
					else {
						System.out.println("category edit");

						ps_sql = con1.prepareStatement("select * from catogeries where cname=?");
						ps_sql.setString(1, s1);
						ps_sql.execute();
						rs = ps_sql.getResultSet();
						while (rs.next()) {
							cb = new CategoryBean();
							cb.setCat(rs.getString("cname"));
							cb.setDes(rs.getString("description"));
							list.add(cb);
						}

						System.out.println(list);

						ps_sql = con1.prepareStatement("select * from products where pcat=?");
						ps_sql.setString(1, s1);
						ps_sql.execute();
						rs = ps_sql.getResultSet();
						while (rs.next()) {
							pb = new productBean();
							pb.setPname(rs.getString("pname"));
							pb.setPdes(rs.getString("pdes"));
							pb.setPno(rs.getInt("pno"));
							pb.setPrice(rs.getInt("price"));
							plist.add(pb);
						}

						System.out.println(plist);

						request.setAttribute("productList", plist);

						request.setAttribute("catList", list);
						rd = request.getRequestDispatcher("addProduct.jsp");
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("Oops something bad happened msg = " + e.getMessage());
				}
			}

			// error.jsp;

			if (uri.contains("/error.Ado")) {
				Connection con1 = null;
				PreparedStatement ps_sql = null, ps_ins = null;
				ResultSet rs = null;
				try {
					con1 = (Connection) JDBCHelper.getConnection();
					if (con1 == null)
						out.println("Oops theres been a problem. Cannot connect to DB!!!");
					else {
						System.out.println("hellodelete");
						out.println("success");
						ArrayList<CategoryBean> list = new ArrayList();
						list = load_data.load();
						request.setAttribute("catList", list);
						ArrayList<productBean> plist = new ArrayList();
						plist = load_products.load();
						System.out.println(plist);

						System.out.println(list);
						request.setAttribute("catList", list);
						request.setAttribute("productList", plist);

						rd = request.getRequestDispatcher("admin_page.jsp");
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("Oops something bad happened msg = " + e.getMessage());
				}
			}

			// editing product

			if (uri.contains("/editProduct.Ado")) {
				String s1 = request.getParameter("prodval");
				System.out.println(s1);
				Connection con1 = null;
				PreparedStatement ps_sql = null;
				ResultSet rs = null;

				productBean pb = null;

				ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
				ArrayList<productBean> plist = new ArrayList<productBean>();
				try {
					con1 = (Connection) JDBCHelper.getConnection();
					if (con1 == null)
						out.println("Oops theres been a problem. Cannot connect to DB!!!");
					else {
						// System.out.println("");
						ppname = s1;
						ps_sql = con1.prepareStatement("select * from products where pname=?");
						ps_sql.setString(1, s1);
						ps_sql.execute();
						rs = ps_sql.getResultSet();
						while (rs.next()) {
							pb = new productBean();
							pb.setPname(rs.getString("pname"));
							pb.setPdes(rs.getString("pdes"));
							pb.setPcat(rs.getString("pcat"));
							pb.setPno(rs.getInt("pno"));
							pb.setPrice(rs.getInt("price"));
							plist.add(pb);
						}

						System.out.println(plist);
						request.setAttribute("productList", plist);
						rd = request.getRequestDispatcher("editProduct.jsp");
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("Oops something bad happened msg = " + e.getMessage());
				}
			}

			// edit product1

			if (uri.contains("/editProduct1.Ado")) {
				String s1 = request.getParameter("logprod");
				System.out.println("  ");
				System.out.println(s1);
				Connection con1 = null;
				PreparedStatement ps_sql = null;
				ResultSet rs = null;
				productBean pbean = (productBean) request.getAttribute("logprod");
				productBean pb = null;

				try {
					con1 = (Connection) JDBCHelper.getConnection();
					if (con1 == null)
						out.println("Oops theres been a problem. Cannot connect to DB!!!");
					else {
						System.out.println("product edit");
						out.println("success");

						ps_sql = con1.prepareStatement(
								"update products set price=?, available=?, pdescription=? where pname=?");
						ps_sql.setInt(1, pbean.getPrice());
						ps_sql.setInt(2, pbean.getPno());

						ps_sql.setString(3, pbean.getPdes());
						ps_sql.setString(4, pbean.getPname());

						ps_sql.execute();

						rs = ps_sql.getResultSet();

						out.println("success");
						String pcat = pbean.getPcat();
						System.out.println("category" + pcat);
						ArrayList<CategoryBean> list = new ArrayList();
						list = load_data.load(pcat);
						request.setAttribute("catList", list);
						ArrayList<productBean> plist = new ArrayList();
						plist = load_products.load(pcat);
						System.out.println(list);
						System.out.println(plist);

						request.setAttribute("catList", list);
						request.setAttribute("productList", plist);

						rd = request.getRequestDispatcher("addProduct.jsp");
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("Oops something bad happened msg = " + e.getMessage());
				}
			}

			// deleting the specific product

			if (uri.contains("/deleteProduct.Ado")) {
				String s1 = request.getParameter("catval");
				System.out.println(s1 + " this");
				Connection con1 = null;
				PreparedStatement ps_sql = null, ps_ins = null;
				ResultSet rs = null;
				productBean pbean = (productBean) request.getAttribute("logcat");
				productBean Pb = null;
				CategoryBean cb = null;
				try {
					con1 = (Connection) JDBCHelper.getConnection();
					if (con1 == null)
						out.println("Oops theres been a problem. Cannot connect to DB!!!");
					else {

						boolean delete = model.deleteProduct(s1);
						ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
						list = load_data.load();
						request.setAttribute("catList", list);
						ArrayList<productBean> plist = new ArrayList<productBean>();
						plist = load_products.load();
						System.out.println(plist);
						request.setAttribute("productList", plist);
						rd = request.getRequestDispatcher("adminPage.jsp");
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					out.println("Oops something bad happened msg = " + e.getMessage());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse\r
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

