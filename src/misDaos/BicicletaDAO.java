package misDaos;

import java.util.List;

import misClases.Bicicleta;


public interface BicicletaDAO {
	
	public List <Bicicleta> listar();
	
	public void guardar(Bicicleta c);
	
	public void eliminar(int idBicicleta); 
	
	public Bicicleta encontrar(int idBicicleta);

	public void modificar(Bicicleta Bicicleta);

}