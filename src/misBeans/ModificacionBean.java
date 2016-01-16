package misBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import misClases.Usuario;
import misClases.UsuarioComun;
import misDaos.FactoryDAO;

@ManagedBean(name="modificacionbean")
@SessionScoped
public class ModificacionBean {
	HttpSession session = SessionBean.getSession();
	
	private String dni,nombre,apellido,domicilio,fecha,sexo,mail,pwd_old,pwd_nuevo,pwd_confirmacion;
	private Usuario user;
	private FactoryDAO factory = new FactoryDAO();
	private UsuarioComun user_modif;
	private String mail_usr;
	
	
	public ModificacionBean(HttpSession session, String dni, String nombre,
			String apellido, String domicilio, String fecha, String sexo,
			String mail, String pwd_old, String pwd_nuevo,
			String pwd_confirmacion, Usuario user, FactoryDAO factory,
			UsuarioComun user_modif, String mail_usr) {
		super();
		this.session = session;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.fecha = fecha;
		this.sexo = sexo;
		this.mail = mail;
		this.pwd_old = pwd_old;
		this.pwd_nuevo = pwd_nuevo;
		this.pwd_confirmacion = pwd_confirmacion;
		this.user = user;
		this.factory = factory;
		this.user_modif = user_modif;
		this.mail_usr = mail_usr;
	}

	public String getMail_usr() {
		return mail_usr;
	}

	public void setMail_usr(String mail_usr) {
		this.mail_usr = mail_usr;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
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

	public String getPwd_old() {
		return pwd_old;
	}

	public void setPwd_old(String pwd_old) {
		this.pwd_old = pwd_old;
	}

	public String getPwd_nuevo() {
		return pwd_nuevo;
	}

	public void setPwd_nuevo(String pwd_nuevo) {
		this.pwd_nuevo = pwd_nuevo;
	}

	public String getPwd_confirmacion() {
		return pwd_confirmacion;
	}

	public void setPwd_confirmacion(String pwd_confirmacion) {
		this.pwd_confirmacion = pwd_confirmacion;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public FactoryDAO getFactory() {
		return factory;
	}

	public void setFactory(FactoryDAO factory) {
		this.factory = factory;
	}
	

	public UsuarioComun getUser_modif() {
		return user_modif;
	}

	public void setUser_modif(UsuarioComun user_modif) {
		this.user_modif = user_modif;
	}

	public ModificacionBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String modificar()
	{
		if(session != null)
		{
			user = (Usuario) session.getAttribute("username");
			if(!dni.isEmpty() && dni != null && !dni.equals(user.getDni()))
			{
				user.setDni(dni);
			}
			if(!nombre.isEmpty() && nombre != null && !nombre.equals(user.getNombre()))
			{
				user.setNombre(nombre);
			}
			if(!apellido.isEmpty() && apellido != null && !apellido.equals(user.getApellido()))
			{
				user.setApellido(apellido);
			}
			if(!domicilio.isEmpty() && domicilio != null && !domicilio.equals(user.getDomicilio()))
			{
				user.setDomicilio(domicilio);
			}
			if(!fecha.isEmpty() && fecha != null && !fecha.equals(user.getFecha()))
			{
				user.setFecha(fecha);
			}
			if(!sexo.isEmpty() && sexo != null && !sexo.equals(user.getSexo()))
			{
				user.setSexo(sexo);
			}
			if(!mail.isEmpty() && mail != null && !mail.equals(user.getMail()))
			{
				user.setMail(mail);
			}
			factory.getUsuarioDAO().modificar(user);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("Changes applied with success");
			context.addMessage("MESSAGE", message);
			return "success_modificacion";
		}
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("USERNAME NOT LOGGED");
		context.addMessage("MESSAGE", message);
		return "fail";
	}
	public String modificarpwd()
	{
		if(session != null)
		{
			user = (Usuario) session.getAttribute("username");
			if(!pwd_old.isEmpty() && pwd_old != null && pwd_old.equals(user.getPwd()))
			{
				if(!pwd_nuevo.isEmpty() && !pwd_confirmacion.isEmpty())
				{
					if(pwd_nuevo.equals(pwd_confirmacion)){
						user.setPwd(pwd_nuevo);
					}
				}
			}
			factory.getUsuarioDAO().modificar(user);
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage(" Changes applied with success ");
			context.addMessage("MESSAGE", message);
			return "success_modificacion";
		}
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(" USERNAME NOT LOGGED ");
		context.addMessage("MESSAGE", message);
		return "fail";
	}
	
	public String modificarusuario()
	{
		if(session != null)
		{
			if(mail_usr != null && !mail_usr.isEmpty())
			{
				if(factory.getUsuarioDAO().encontrar(mail_usr) != null)
				{
					user_modif = (UsuarioComun)factory.getUsuarioDAO().encontrar(mail_usr);
					return "success";
				}else{
					FacesContext context = FacesContext.getCurrentInstance();
					FacesMessage message = new FacesMessage(" USERNAME NOT FOUND ");
					context.addMessage("modif_user", message);
					return "failure";
				}
			}
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage(" Enter a mail ");
			context.addMessage("modif_user", message);
			return "failure";
		}
		return "fail";
	}
	
	public String bajadeusuario()
	{	
		if(user_modif != null)
		{
			if(!user_modif.getSuspended())
			{
				user_modif.setSuspended(true);
				factory.getUsuarioDAO().modificar(user_modif);
			}
			else
			{
				user_modif.setSuspended(false);
				factory.getUsuarioDAO().modificar(user_modif);
			}
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("Success !");
			context.addMessage("baja", message);
			return "success_modification";
		}
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("User not found");
		context.addMessage("baja", message);
		return "fail";
	}
}
