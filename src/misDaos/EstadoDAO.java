package misDaos;

import java.util.List;

import misClases.Estado;


public interface EstadoDAO {
	
	public List <Estado> listar();
	
	public void guardar(Estado c);
	
	public void eliminar(int idEstado); 
	
	public Estado encontrar(int idEstado);

	public void modificar(Estado Estado);

}