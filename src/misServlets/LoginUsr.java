package misServlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUsr
 */
@WebServlet("/LoginUsr")
public class LoginUsr extends HttpServlet {
	HashMap<String,String> logins = new HashMap<String, String>();

	public void init(ServletConfig servletConfig) throws ServletException{

		logins.put("usuario", servletConfig.getServletContext().getInitParameter("usuario"));

	}
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		RequestDispatcher dispatcher;
		for(Entry<String, String> entry : logins.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if(user.equals("admin")){
				if(pwd.equals("admin")){
					HttpSession miSession = request.getSession();
					miSession.setAttribute("rol", "admin");
					dispatcher=request.getRequestDispatcher("/Administracion.html");
					if (dispatcher!=null) dispatcher.forward(request,response);
					return;
				}
			}
			else if(user.equals(key)){
				if(pwd.equals(value)){
					HttpSession miSession = request.getSession();
					miSession.setAttribute("rol", "usuario");
					dispatcher=request.getRequestDispatcher("/Usuario.html");
					if (dispatcher!=null) dispatcher.forward(request,response);
					return;
				}
			}
		}
		response.sendRedirect("/JBici/Login.html");
	}
}
