package onlineshopping.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import online_shopping.CategoryBean;
import online_shopping.load_data;
import online_shopping.load_products;
import online_shopping.productBean;
import online_shopping.*;
/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI(); // based on uri, apply
		// controlling logic

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		
		if (uri.contains("/UserHome.Udo")) {
			rd = request.getRequestDispatcher("userhome.jsp");
			rd.forward(request, response);
		}

		// method to login

		if (uri.contains("/loginUser.Udo")) {
			try {
				UserBean bean = (UserBean) request.getAttribute("log");
				boolean res = Model.validate(bean);
				if (res == true) {
					HttpSession session = request.getSession();
					session.setAttribute("userr", bean.getName());
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Welcome User');");
					out.println("location='userpage.jsp';");
					out.println("</script>");

					ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
					list = load_data.load();
					request.setAttribute("catList", list);

					System.out.println(list);
					request.setAttribute("catList", list);
					// request.setAttribute("productList", plist);

					rd = request.getRequestDispatcher("userpage.jsp");
					rd.forward(request, response);

				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('ivalid username or password');");
					out.println("location='userhome.jsp';");
					out.println("</script>");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// method to register new users
		if (uri.contains("/register.Udo")) {
			System.out.println("register if block");

			RegisterBean bean = (RegisterBean) request.getAttribute("reg");
			System.out.println("bean = " + bean);
			String result = null;
			try {
				result = Model.register(bean);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result.equals("SUCCESS")) {
				// registration succeeded!
				// forward to Success.jsp
				request.setAttribute("success", "Your registration success!!!");
				rd = request.getRequestDispatcher("userhome.jsp");
				rd.forward(request, response);
			} else {
				// registration failed!!
				// foward to Register.jsp
				request.setAttribute("errorMsg", result);
				rd = request.getRequestDispatcher("userhome.jsp");
				rd.forward(request, response);

			}
		}

		// method to select category and returns products under selected
		// category

		if (uri.contains("/cat.Udo")) {
			try {
				String s1 = request.getParameter("cat");
				System.out.println(s1);
				ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
				list = load_data.load();
				request.setAttribute("catList", list);
				ArrayList<productBean> plist = new ArrayList<productBean>();
				plist = load_products.load(s1);
				System.out.println(plist);

				System.out.println(list);
				request.setAttribute("catName", s1);
				request.setAttribute("productList", plist);

				rd = request.getRequestDispatcher("userpage.jsp");
				rd.forward(request, response);
				// request.getRequestDispatcher("userPaget.jsp").include(request,
				// response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Method to addtocart
		if (uri.contains("/addtocart.Udo")) {
			System.out.println("Hello");
			HttpSession session = request.getSession(false);
			//String uname=request.getParameter("userr");
			String uname = (String) request.getSession(false).getAttribute("userr");
			String pname = request.getParameter("pname");
			String price = request.getParameter("price");
			String stock = request.getParameter("stock");
			String items = request.getParameter("item");
			String category = request.getParameter("pcat");
			int pric = Integer.parseInt(price);
			int item = Integer.parseInt(items);
			int stocks = Integer.parseInt(stock);
			System.out.println(pname + " " + price + " " + stock + " " + items);
			System.out.println(uname);
			String result = null;

			try {
				result = Model.addtocart(uname, pname, pric, stocks, item);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (result.equals("SUCCESS")) {
				List<CartBean> cart = null;

				try {
					System.out.println("in cart");
					cart = Model.getCartDetails(uname);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(cart);
				int total = 0;
				for (CartBean b : cart) {
					int sumofamount = Integer.parseInt(b.getPrice());
					total = total + sumofamount;
				}
				session.setAttribute("CartList", cart);
				session.setAttribute("totalamount", total);
				request.setAttribute("msg", "Added to Cart");
				ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
				try {
					list = load_data.load();
				} catch (InstantiationException e) {

					e.printStackTrace();
				} catch (IllegalAccessException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}

				System.out.println(list);
				request.setAttribute("catList", list);
				ArrayList<productBean> plist = new ArrayList<productBean>();
				try {
					plist = load_products.load(category);
				} catch (InstantiationException e) {

					e.printStackTrace();
				} catch (IllegalAccessException e) {

					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("successMsg", "Product added to cart successfully");
				request.setAttribute("productList", plist);
				request.setAttribute("catList", list);
				request.setAttribute("catName", category);
				rd = request.getRequestDispatcher("userpage.jsp");
				rd.forward(request, response);
			} else {
				ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
				try {
					list = load_data.load();
				} catch (InstantiationException e) {

					e.printStackTrace();
				} catch (IllegalAccessException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}

				System.out.println(list);
				request.setAttribute("catList", list);
				ArrayList<productBean> plist = new ArrayList<productBean>();
				try {
					plist = load_products.load(category);
				} catch (InstantiationException e) {

				} catch (IllegalAccessException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}

				request.setAttribute("productList", plist);
				request.setAttribute("catList", list);
				request.setAttribute("catName", category);
				request.setAttribute("errorMsg", result);
				rd = request.getRequestDispatcher("userpage.jsp");
				rd.forward(request, response);

			}
		}

		// Method to get cart items
		if (uri.contains("/cart.Udo")) {
			try {
				String uname = (String) request.getSession(false).getAttribute("userr");
				System.out.println(uname);

				ArrayList<CartBean> cartlist = new ArrayList<CartBean>();
				cartlist = Model.loadcart(uname);
				System.out.println(cartlist);
				request.setAttribute("cartList", cartlist);
				rd = request.getRequestDispatcher("cart.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Method to get back to shopping
		if (uri.contains("/goUser.Udo")) {
			try {
				String uname = (String) request.getSession(false).getAttribute("userr");
				System.out.println(uname);

				ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
				list = load_data.load();
				request.setAttribute("catList", list);

				System.out.println(list);
				request.setAttribute("catList", list);
				rd.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * Deleting Items from cart
		 * 
		 */
		if (uri.contains("/DelCartItem.Udo")) {
			System.out.println("delete method");
			HttpSession session = request.getSession(false);
			String uname = (String) request.getSession(false).getAttribute("userr");
			String pname = request.getParameter("names");
			String result = null;
			try {
				System.out.println(uname + "herer");
				result = Model.deleteFromCart1(uname, pname);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result.equals("SUCCESS")) {
				List<CartBean> cart = null;
				try {
					cart = Model.getCartDetails(uname);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(cart);

				session.setAttribute("CartList", cart);
				int sumtotal = 0;
				for (CartBean b : cart) // Re-calculating Total amount
				{
					int sumofamount = Integer.parseInt(b.getPrice());
					sumtotal = sumtotal + sumofamount;
				}
				session.setAttribute("totalamount", sumtotal);
				request.setAttribute("msg", "Deleted From Cart");
				String uname1 = (String) request.getSession(false).getAttribute("userr");
				System.out.println(uname1);
				ArrayList<CartBean> cartlist = new ArrayList<CartBean>();
				try {
					cartlist = Model.loadcart(uname1);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(cartlist);
				request.setAttribute("cartList", cartlist);

				rd = request.getRequestDispatcher("cart.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("errorMsg", result);
				rd = request.getRequestDispatcher("cart.jsp");
				rd.forward(request, response);

			}
		}

		/**
		 * checking out with all the cart items
		 * 
		 */
		if (uri.contains("/checkout.Udo")) {
			String uname = (String) request.getSession(false).getAttribute("userr");
			System.out.println(uname);
			String result = null;
			try {
				result = Model.updateCart(uname);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (result.equals("SUCCESS")) {
					rd = request.getRequestDispatcher("cart.jsp");
					rd.forward(request, response);

				} else {
					request.setAttribute("msg", result);
					rd = request.getRequestDispatcher("cart.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * Viewing Cart Details
		 * 
		 */
		if (uri.contains("/viewcart.Udo")) {
			String uname = (String) request.getSession(false).getAttribute("userr");
			List<CartBean> cart = null;
			try {
				cart = Model.getCartDetails(uname);
				System.out.println(uname + "" + cart);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int total = 0;
			CartBean c = new CartBean();
			System.out.println("in view cart do after getting list of bean");
			System.out.println(cart);
			for (CartBean b : cart) // Calculating Total amount
			{
				int sumofamount = Integer.parseInt(b.getPrice());
				total = total + sumofamount;
			}
			System.out.println(total);

			System.out.println(total);
			request.setAttribute("cartList", cart);
			request.setAttribute("totalamount", total);
			rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		}

		// method to logout

		if (uri.contains("/logout.Udo")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				System.out.println(session.getAttribute("user"));
				session.removeAttribute("user");
				session.removeAttribute("catlist");
				session.removeAttribute("productList");
				// session.removeAttribute("CartItems");
				// if(Cart.size()>1){
				// Cart.removeAll(Cart);
				// }
				// System.out.println(Cart);
				// session.invalidate();

				request.setAttribute("message", "You have logged out successfully!!");
				rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}