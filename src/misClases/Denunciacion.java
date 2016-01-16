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
@Table(name="denunciacion")
public class Denunciacion {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="denunciacion_id")
	private int id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="user_quien_denuncio_id")
	private UsuarioComun usuario_quien_denuncio;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="bici_denuciada_id")
	private Bicicleta bici;
	
	@OneToOne
	private Alquiler alquiler;
	
	private String fecha_denuncia;
	private String comentario;
	
	public Denunciacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Denunciacion(UsuarioComun usuario_quien_denuncio, Bicicleta bici,
			String fecha_denuncia, String comentario) {
		super();
		this.usuario_quien_denuncio = usuario_quien_denuncio;
		this.bici = bici;
		this.fecha_denuncia = fecha_denuncia;
		this.comentario = comentario;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario_quien_denuncio() {
		return usuario_quien_denuncio;
	}
	public void setUsuario_quien_denuncio(UsuarioComun usuario_quien_denuncio) {
		this.usuario_quien_denuncio = usuario_quien_denuncio;
	}
	public Bicicleta getBici() {
		return bici;
	}
	public void setBici(Bicicleta bici) {
		this.bici = bici;
	}
	public String getFecha_denuncia() {
		return fecha_denuncia;
	}
	public void setFecha_denuncia(String fecha_denuncia) {
		this.fecha_denuncia = fecha_denuncia;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Alquiler getAlquiler() {
		return alquiler;
	}
	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}
	
}
