package misDaos;

import java.util.List;

import misClases.Usuario;


public interface UsuarioDAO {
	
	public List <Usuario> listar();
	
	public void guardar(Usuario c);
	
	public void eliminar(int idUsuario); 
	
	public Usuario encontrar(int idUsuario);

	public Usuario encontrar(String mail);

	public void modificar(Usuario Usuario);

}