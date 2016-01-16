package misClases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="alquiler")
public class Alquiler{
	
	//Variables
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="alquiler_id")
	private int id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="user_id")
	private UsuarioComun usuario;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="bici_id")
	private Bicicleta bici;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="estacion_id")
	private Estacion estacion_alquiler;
	
	@OneToOne
	private Denunciacion denunciacion;
	
	private String fecha_alquiler;
	
	//Constructors
	
	public Alquiler(UsuarioComun usuario, Bicicleta bici,
			Estacion estacion_alquiler, Denunciacion denunciacion,
			String fecha_alquiler) {
		super();
		this.usuario = usuario;
		this.bici = bici;
		this.estacion_alquiler = estacion_alquiler;
		this.denunciacion = denunciacion;
		this.fecha_alquiler = fecha_alquiler;
	}
	
	public Alquiler() {
		super();
	}

	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Denunciacion getDenunciacion() {
		return denunciacion;
	}

	public void setDenunciacion(Denunciacion denunciacion) {
		this.denunciacion = denunciacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioComun usuario) {
		this.usuario = usuario;
	}
	public Bicicleta getBici() {
		return bici;
	}
	public void setBici(Bicicleta bici) {
		this.bici = bici;
	}
	public Estacion getEstacion_alquiler() {
		return estacion_alquiler;
	}
	public void setEstacion_alquiler(Estacion estacion_alquiler) {
		this.estacion_alquiler = estacion_alquiler;
	}
	public String getFecha_alquiler() {
		return fecha_alquiler;
	}
	public void setFecha_alquiler(String fecha_alquiler) {
		this.fecha_alquiler = fecha_alquiler;
	}
}
