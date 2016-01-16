package misDaos;

import java.util.List;

import misClases.Estacion;


public interface EstacionDAO {
	
	public List <Estacion> listar();
	
	public void guardar(Estacion c);
	
	public void eliminar(int idEstacion); 
	
	public Estacion encontrar(int idEstacion);

	public void modificar(Estacion Estacion);

}