package misServlets;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import misClases.Usuario;

/**
 * Servlet implementation class Registracion
 */
@WebServlet("/Registracion")


public class Registracion extends HttpServlet {
	
	static final HashMap<String,String> usuariosRegistrados = new HashMap<String,String>();
	
	//Class para generar clave secure
	public final class SessionIdentifierGenerator {
		private SecureRandom random = new SecureRandom();

		public String nextSessionId() {
			return new BigInteger(130, random).toString(32);
		}
	}

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionIdentifierGenerator sessionIdentifier = new SessionIdentifierGenerator();
		RequestDispatcher dispatcher;
		
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String domicilio = request.getParameter("domicilio");
		String fecha = request.getParameter("fechanacimiento");
		String mail = request.getParameter("mail");
		String sexo = request.getParameter("sexo");
		String pwd = sessionIdentifier.nextSessionId();

		Usuario usr = new Usuario(dni,nombre,apellido,domicilio,fecha,sexo,mail,pwd);
		usuariosRegistrados.put(usr.getMail(), usr.getPwd());
		
		
		ServletContext sc=this.getServletConfig().getServletContext();
		sc.setAttribute(usr.getMail(),usr);
		sc.setAttribute("usuariosRegistrados",usuariosRegistrados);
		
		dispatcher=request.getRequestDispatcher("/Usuario.html");
		if (dispatcher!=null) dispatcher.forward(request,response);
	}

}
