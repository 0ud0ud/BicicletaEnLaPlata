package misBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import misClases.Usuario;
import misClases.UsuarioAdmin;
import misClases.UsuarioComun;
import misDaos.FactoryDAO;

@ManagedBean(name="loginbean")
@SessionScoped
public class LoginBean {
	
	String username;
	String password;
	FactoryDAO factory = new FactoryDAO();
	Usuario user;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public FactoryDAO getFactory() {
		return factory;
	}

	public void setFactory(FactoryDAO factory) {
		this.factory = factory;
	}
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	public LoginBean(String username, String password, FactoryDAO factory,
			Usuario user) {
		super();
		this.username = username;
		this.password = password;
		this.factory = factory;
		this.user = user;
	}
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String login() {
		try{
			user = factory.getUsuarioDAO().encontrar(getUsername());
			if (user.getPwd().equals(getPassword())) {
				HttpSession session = SessionBean.getSession();
	            session.setAttribute("username", user);
				if(user instanceof UsuarioComun){
					return "success_comun";
				}else if(user instanceof UsuarioAdmin){
					return "success_admin";
				}else{
					return "success";
				}
				
			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage("Invalid Username and/or Password");
				context.addMessage("loginForm", message);
				return "failure";
			}
		}catch(NullPointerException e){
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("USERNAME NOT FOUND");
			context.addMessage("loginForm", message);
			return "failure";
		}
	}

	//logout event, invalidate session
    public String logout() {
        HttpSession session = SessionBean.getSession();

    	if(session != null){
            session.invalidate();
    	}
        return "logout";
    }
    
    public boolean getiscomun()
    {
    	if(user!=null){
    		if(user instanceof UsuarioComun)
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean getisadmin()
    {
    	if(user!=null){
    		if(user instanceof UsuarioAdmin)
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean getissupended()
    {
    	if(user!=null)
    	{
    		if(user instanceof UsuarioAdmin)
    		{
    			return false;
    		}
    		if(user instanceof UsuarioComun){
    			if(((UsuarioComun) user).getSuspended()){
    				return true;
    			}else{
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
