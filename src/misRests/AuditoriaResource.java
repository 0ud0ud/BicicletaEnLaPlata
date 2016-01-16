package misRests;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class AuditoriaResource {
	AuditoriaService auditoriaService = new AuditoriaService();
	
	@GET
	@Path("datosUsuario")
	@Produces({MediaType.APPLICATION_JSON})
	public List<AuditoriaRest> getAuditoriasUsuario(){
		List<AuditoriaRest> list = new ArrayList<AuditoriaRest>();
		list = auditoriaService.getAuditoriaList("Usuario");
		return list;
	}
	
	@GET
	@Path("datosAlquiler")
	@Produces({MediaType.APPLICATION_JSON})
	public List<AuditoriaRest> getAuditoriasAlquiler(){
		List<AuditoriaRest> list = new ArrayList<AuditoriaRest>();
		list = auditoriaService.getAuditoriaList("Alquiler");
		return list;
	}
	
	@GET
	@Path("datosBicicleta")
	@Produces({MediaType.APPLICATION_JSON})
	public List<AuditoriaRest> getAuditoriasBicicleta(){
		List<AuditoriaRest> list = new ArrayList<AuditoriaRest>();
		list = auditoriaService.getAuditoriaList("Bicicleta");
		return list;
	}
	@GET
	@Path("datosDenunciacion")
	@Produces({MediaType.APPLICATION_JSON})
	public List<AuditoriaRest> getAuditoriasDenunciacion(){
		List<AuditoriaRest> list = new ArrayList<AuditoriaRest>();
		list = auditoriaService.getAuditoriaList("Denunciacion");
		return list;
	}
	@GET
	@Path("datosEstacion")
	@Produces({MediaType.APPLICATION_JSON})
	public List<AuditoriaRest> getAuditoriasEstacion(){
		List<AuditoriaRest> list = new ArrayList<AuditoriaRest>();
		list = auditoriaService.getAuditoriaList("Estacion");
		return list;
	}
	@GET
	@Path("datosEstado")
	@Produces({MediaType.APPLICATION_JSON})
	public List<AuditoriaRest> getAuditoriasEstado(){
		List<AuditoriaRest> list = new ArrayList<AuditoriaRest>();
		list = auditoriaService.getAuditoriaList("Estado");
		return list;
	}
}
