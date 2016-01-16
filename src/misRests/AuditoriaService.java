package misRests;

import java.util.ArrayList;
import java.util.List;

import misDaos.FactoryDAO;


public class AuditoriaService {
	private FactoryDAO f = new FactoryDAO();
	private AuditoriaRest a;
	public AuditoriaService(){

	}

	public List<AuditoriaRest> getAuditoriaList(String entidad){
		List<AuditoriaRest> auditoriaList = new ArrayList<AuditoriaRest>();

//		a = f.getAuditoriaDAO().recuperarAuditoria("Guardar"+entidad);
//		auditoriaList.add(a);
//		a = f.getAuditoriaDAO().recuperarAuditoria("Modificar"+entidad);
//		auditoriaList.add(a);
//		a = f.getAuditoriaDAO().recuperarAuditoria("Encontrar"+entidad);
//		auditoriaList.add(a);
//		a = f.getAuditoriaDAO().recuperarAuditoria("Eliminar"+entidad);
//		auditoriaList.add(a);
//		a = f.getAuditoriaDAO().recuperarAuditoria("Listar"+entidad);
//		auditoriaList.add(a);
		return auditoriaList;	
	}

}

