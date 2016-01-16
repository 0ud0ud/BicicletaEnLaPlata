package misRests;

public class AuditoriaRest {
	private int cantidad;
	private String nombreOperacion;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombreOperacion() {
		return nombreOperacion;
	}
	public void setNombreOperacion(String nombreOperacion) {
		this.nombreOperacion = nombreOperacion;
	}
	public AuditoriaRest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuditoriaRest(int cantidad, String nombreOperacion) {
		super();
		this.cantidad = cantidad;
		this.nombreOperacion = nombreOperacion;
	}
	
	
}
