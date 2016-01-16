package misDaos;

import java.util.List;

import misClases.Auditoria;

public interface AuditoriaDAO {

	public List <Auditoria> listar();

	public void guardar(Auditoria c);

	public void eliminar(int idAuditoria); 

	public Auditoria encontrar(int idAuditoria);

	public void modificar(Auditoria Auditoria);

}

