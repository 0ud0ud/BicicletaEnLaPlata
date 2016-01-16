package misClases;

import javax.persistence.Entity;

@Entity
public class HistoricoEstados extends Estado{
	
	private String fecha;
	
	public HistoricoEstados() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoricoEstados(String fecha) {
		super();
		this.fecha = fecha;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
