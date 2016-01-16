package misClases;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoAlquileres extends Alquiler{
	
	@ManyToOne(optional=false)
	@JoinColumn(name="estacion_devolver_id",nullable=true,columnDefinition = "défault")
	private Estacion estacion_devolver;
	
	private String fecha_devolver;
	
	public HistoricoAlquileres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoricoAlquileres(UsuarioComun usuario, Bicicleta bici,
			Estacion estacion_alquiler, Denunciacion denunciacion,
			String fecha_alquiler) {
		super(usuario, bici, estacion_alquiler, denunciacion, fecha_alquiler);
		// TODO Auto-generated constructor stub
	}

	public HistoricoAlquileres(UsuarioComun usuario, Bicicleta bici,
			Estacion estacion_alquiler, Denunciacion denunciacion,
			String fecha_alquiler, Estacion estacion_devolver,
			String fecha_devolver) {
		super(usuario, bici, estacion_alquiler, denunciacion, fecha_alquiler);
		this.estacion_devolver = estacion_devolver;
		this.fecha_devolver = fecha_devolver;
	}

	public Estacion getEstacion_devolver() {
		return estacion_devolver;
	}

	public void setEstacion_devolver(Estacion estacion_devolver) {
		this.estacion_devolver = estacion_devolver;
	}

	public String getFecha_devolver() {
		return fecha_devolver;
	}

	public void setFecha_devolver(String fecha_devolver) {
		this.fecha_devolver = fecha_devolver;
	}
	
	
}
