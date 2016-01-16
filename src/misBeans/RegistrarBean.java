package misBeans;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import misClases.UsuarioComun;
import misDaos.FactoryDAO;

@ManagedBean(name="registrarBean")
@SessionScoped
public class RegistrarBean {

	private String dni,nombre,apellido,domicilio,fecha,sexo,mail,pwd;
	private UsuarioComun user;
	private FactoryDAO factory = new FactoryDAO();

	public RegistrarBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistrarBean(String dni, String nombre, String apellido,
			String domicilio, String fecha, String sexo, String mail,
			String pwd, UsuarioComun user, FactoryDAO factory) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.fecha = fecha;
		this.sexo = sexo;
		this.mail = mail;
		this.pwd = pwd;
		this.user = user;
		this.factory = factory;
	}

	public UsuarioComun getUser() {
		return user;
	}

	public void setUser(UsuarioComun user) {
		this.user = user;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void inscripcion()
	{
		SessionIdentifierGenerator sessionIdentifier = new SessionIdentifierGenerator();
		setPwd(sessionIdentifier.nextSessionId());
		
		user = new UsuarioComun(dni, nombre, apellido, domicilio, fecha, sexo, mail, pwd);
		factory.getUsuarioDAO().guardar(user);
		
		FacesMessage message = new FacesMessage( "Inscripcion valida, password =" + pwd);
        FacesContext.getCurrentInstance().addMessage( null, message );
	}
	
	public final class SessionIdentifierGenerator {
		private SecureRandom random = new SecureRandom();

		public String nextSessionId() {
			return new BigInteger(130, random).toString(32);
		}
	}
}