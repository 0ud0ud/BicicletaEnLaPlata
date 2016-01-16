package misDaos;

import java.util.List;

import misClases.Alquiler;


public interface AlquilerDAO {
	
	public List <Alquiler> listar();
	
	public void guardar(Alquiler c);
	
	public void eliminar(int idAlquiler); 
	
	public Alquiler encontrar(int idAlquiler);

	public void modificar(Alquiler Alquiler);

}