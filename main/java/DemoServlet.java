

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String phone_no=request.getParameter("phone_no");
		String email=request.getParameter("email");
		String landmark=request.getParameter("landmark");
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String district=request.getParameter("district");
		String pincode=request.getParameter("pincode");
		Data d=new Data(name,password,phone_no,email,landmark,street,city,district,pincode);
		d.store();
		RequestDispatcher requ=request.getRequestDispatcher("login1.html");
		requ.forward(request, response);
		doGet(request, response);
	}

}
