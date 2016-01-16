package misClases;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bicicleta")
public class Bicicleta {
	//Variables
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String fecha_ingreso,fecha_dispo;
	@ManyToOne(optional=true)
	@JoinColumn(name="estadoBicicleta")
	private Estado estadoBicicleta;
	
	@OneToMany(mappedBy="bici")
	private List<Denunciacion> denunciaciones;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="estacion_id")
	private Estacion estacion_actual;
	
	public Bicicleta() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Constructors
	public Bicicleta(String fecha_ingreso, String fecha_dispo,
			Estacion estacion_actual, Estado estadoBicicleta) {
		super();
		this.fecha_ingreso = fecha_ingreso;
		this.fecha_dispo = fecha_dispo;
		this.estacion_actual = estacion_actual;
		this.estadoBicicleta = estadoBicicleta;
	}
	//Getters/Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public String getFecha_dispo() {
		return fecha_dispo;
	}
	public void setFecha_dispo(String fecha_dispo) {
		this.fecha_dispo = fecha_dispo;
	}
	public Estacion getEstacion_actual() {
		return estacion_actual;
	}
	public void setEstacion_actual(Estacion ubicacion_actual) {
		this.estacion_actual = ubicacion_actual;
	}
	public Estado getEstadoBicicleta() {
		return estadoBicicleta;
	}
	public void setEstadoBicicleta(Estado estadoBicicleta) {
		this.estadoBicicleta = estadoBicicleta;
	}
}
