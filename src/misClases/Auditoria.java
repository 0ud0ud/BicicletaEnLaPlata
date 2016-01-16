package misClases;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auditoria")
public class Auditoria {

	@Id @GeneratedValue
	private Long id_Auditoria;

	private Long id_clase;
	private Date fecha;
	private String nombreClase,nombreOp;
	
	public Long getId_Auditoria() {
		return id_Auditoria;
	}
	public void setId_Auditoria(Long id_Auditoria) {
		this.id_Auditoria = id_Auditoria;
	}
	public Long getId_clase() {
		return id_clase;
	}
	public void setId_clase(Long id_clase) {
		this.id_clase = id_clase;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	public String getNombreOp() {
		return nombreOp;
	}
	public void setNombreOp(String nombreOp) {
		this.nombreOp = nombreOp;
	}
	public Auditoria(Long id_Auditoria, Long id_clase, Date fecha,
			String nombreClase, String nombreOp) {
		super();
		this.id_Auditoria = id_Auditoria;
		this.id_clase = id_clase;
		this.fecha = fecha;
		this.nombreClase = nombreClase;
		this.nombreOp = nombreOp;
	}
	public Auditoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}