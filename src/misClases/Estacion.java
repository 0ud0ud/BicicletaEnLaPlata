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
@Table(name="estacion")
public class Estacion {

	//Variables
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nombre,ubicacion;
	
	private int cantidad_bicicletas, cantidad_estacionamientos;
	
	@OneToMany(mappedBy="estacion_actual")
	private List<Bicicleta> bici_en_estacion;
	
	@OneToMany(mappedBy="estacion_alquiler")
	private List<Alquiler> alquileres;
	
	@OneToMany(mappedBy="estacion_devolver")
	private List<HistoricoAlquileres> historicoalquileres;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="estado")
	private Estado estado;

	//Constructors
	
	public Estacion(String nombre, String ubicacion, int cantidad_bicicletas,
			int cantidad_estacionamientos, List<Bicicleta> bici_en_estacion,
			List<Alquiler> alquileres, Estado estado) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.cantidad_bicicletas = cantidad_bicicletas;
		this.cantidad_estacionamientos = cantidad_estacionamientos;
		this.bici_en_estacion = bici_en_estacion;
		this.alquileres = alquileres;
		this.estado = estado;
	}
	
	public Estacion() {
		// TODO Auto-generated constructor stub
	}

	//Getters and setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad_bicicletas() {
		return cantidad_bicicletas;
	}
	public void setCantidad_bicicletas(int cantidad_bicicletas) {
		this.cantidad_bicicletas = cantidad_bicicletas;
	}
	public int getCantidad_estacionamientos() {
		return cantidad_estacionamientos;
	}
	public void setCantidad_estacionamientos(int cantidad_estacionamientos) {
		this.cantidad_estacionamientos = cantidad_estacionamientos;
	}
	public List<Bicicleta> getBici_en_estacion() {
		return bici_en_estacion;
	}
	public void setBici_en_estacion(List<Bicicleta> bici_en_estacion) {
		this.bici_en_estacion = bici_en_estacion;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getCantidad_bici() {
		return cantidad_bicicletas;
	}
	public void setCantidad_bici(int cantidad_bici) {
		this.cantidad_bicicletas = cantidad_bici;
	}
	public int getCantidad_estacionamiento() {
		return cantidad_estacionamientos;
	}
	public void setCantidad_estacionamiento(int cantidad_estacionamiento) {
		this.cantidad_estacionamientos = cantidad_estacionamiento;
	}
}
