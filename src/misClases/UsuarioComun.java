package misClases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class UsuarioComun extends Usuario {
	
	@Column(name = "IS_SUSPENDED", columnDefinition = "boolean default false", nullable = false)
	private Boolean suspended=false;
	
	@OneToMany(mappedBy="usuario")
	private List<Alquiler> alquileres = new ArrayList<Alquiler>();
	
	@OneToMany(mappedBy="usuario_quien_denuncio")
	private List<Denunciacion> denunciaciones = new ArrayList<Denunciacion>();
	
	public Boolean getSuspended() {
		return suspended;
	}
	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
	}
	public List<Denunciacion> getDenunciaciones() {
		return denunciaciones;
	}
	public void setDenunciaciones(List<Denunciacion> denunciaciones) {
		this.denunciaciones = denunciaciones;
	}
	public UsuarioComun(Boolean suspended, List<Alquiler> alquileres,
			List<Denunciacion> denunciaciones) {
		super();
		this.suspended = suspended;
		this.alquileres = alquileres;
		this.denunciaciones = denunciaciones;
	}
	public UsuarioComun() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioComun(String Dni, String Nombre, String Apellido,
			String Domicilio, String Fecha, String Sexo, String Mail, String Pwd) {
		super(Dni, Nombre, Apellido, Domicilio, Fecha, Sexo, Mail, Pwd);
		// TODO Auto-generated constructor stub
	}
	public List<Alquiler> getAlquileres() {
		return alquileres;
	}
	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}
	
	
}
