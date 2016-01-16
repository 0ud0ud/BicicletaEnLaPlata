package misDaos;

import java.util.List;

import misClases.Denunciacion;


public interface DenunciacionDAO {
	
	public List <Denunciacion> listar();
	
	public void guardar(Denunciacion c);
	
	public void eliminar(int idDenunciacion); 
	
	public Denunciacion encontrar(int idDenunciacion);

	public void modificar(Denunciacion Denunciacion);

}