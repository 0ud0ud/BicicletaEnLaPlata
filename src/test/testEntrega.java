package test;

import java.util.ArrayList;
import java.util.List;

import misClases.Alquiler;
import misClases.Bicicleta;
import misClases.Denunciacion;
import misClases.Estacion;
import misClases.Estado;
import misClases.HistoricoAlquileres;
import misClases.Usuario;
import misClases.UsuarioComun;
import misDaos.FactoryDAO;

public class testEntrega {

	public static void main(String[] args) {
		FactoryDAO factory = new FactoryDAO();
//	
//		Usuario nuevo = new Usuario("85464689", "Prenom2", "Nom2","Calle 87", "03/07/2015", "masculino", "mail", "1234");
//		UsuarioComun usercomun = new UsuarioComun("1515484", "jean"	, "paul", "rue ", "0585544", "masculino", "mail", "mdp");
//		Estado esta_estacion = new Estado("En Construccion");
//		Estado esta_bici = new Estado("En Reparacion");
//		List<Bicicleta> list_bici = new ArrayList<Bicicleta>();
//		list_bici.add(factory.getBicicletaDAO().encontrar(1));
//		Estacion est = new Estacion("Plaza Moreno", "Calle 14", 10, 5, list_bici,factory.getAlquilerDAO().listar(),factory.getEstadoDAO().encontrar(1));
//		Denunciacion denunc = new Denunciacion(usercomun,factory.getBicicletaDAO().encontrar(1), "06/05/05", "ceci est un commentaire");
//		Alquiler alqui = new Alquiler(usercomun, factory.getBicicletaDAO().encontrar(1), est, denunc, "06/05/05");
//		Bicicleta bici = new Bicicleta("date", "date_dispo", est, factory.getEstadoDAO().encontrar(2));
//		HistoricoAlquileres ha = new HistoricoAlquileres(usercomun, factory.getBicicletaDAO().encontrar(1), est, denunc, "06/05/05", est, "zerzer");
//		
//		
//		factory.getUsuarioDAO().guardar(usercomun);
//		factory.getEstacionDAO().guardar(est);
//		factory.getBicicletaDAO().guardar(bici);
//		factory.getDenunciacionDAO().guardar(denunc);
//		factory.getEstadoDAO().guardar(esta_bici);
//		factory.getAlquilerDAO().guardar(ha);
//		
//		System.out.println("TEST LISTAR");
//		List<Alquiler> todos_alquileres = factory.getAlquilerDAO().listar();
//		for (Alquiler a : todos_alquileres) 
//		{
//			System.out.println(a.toString());
//		}
//		List<Usuario> todos_usuarios = factory.getUsuarioDAO().listar();
//		for (Usuario a : todos_usuarios) 
//		{
//			System.out.println(a.toString());
//		}
//		List<Estacion> todos_Estacion = factory.getEstacionDAO().listar();
//		for (Estacion a : todos_Estacion) 
//		{
//			System.out.println(a.toString());
//		}
//		List<Bicicleta> todos_Bicicleta = factory.getBicicletaDAO().listar();
//		for (Bicicleta a : todos_Bicicleta) 
//		{
//			System.out.println(a.toString());
//		}
//		List<Denunciacion> todos_Denunciacion= factory.getDenunciacionDAO().listar();
//		for (Denunciacion a : todos_Denunciacion) 
//		{
//			System.out.println(a.toString());
//		}
//		List<Estado> todos_Estado = factory.getEstadoDAO().listar();
//		for (Estado a : todos_Estado) 
//		{
//			System.out.println(a.toString());
//		}
//		
//		System.out.println("TEST ENCONTRAR");
//		System.out.println(factory.getAlquilerDAO().encontrar(4).toString());
//		System.out.println(factory.getUsuarioDAO().encontrar(1).toString());
//		System.out.println(factory.getDenunciacionDAO().encontrar(1).toString());
//		System.out.println(factory.getEstadoDAO().encontrar(1).toString());
//		System.out.println(factory.getBicicletaDAO().encontrar(1).toString());
//		System.out.println(factory.getEstacionDAO().encontrar(1).toString());
//		
//		System.out.println("BLOBLOBLBOBO");
//
//		System.out.println(factory.getUsuarioDAO().encontrar("zoej").getPwd().toString());
//
//		//Test modificar
//		Alquiler alq = factory.getAlquilerDAO().encontrar(4);
//		alq.setBici(bici);
//		factory.getAlquilerDAO().modificar(alq);
//		
		//Test Suprimir
//		factory.getBicicletaDAO().eliminar(10);
		UsuarioComun u = (UsuarioComun)factory.getUsuarioDAO().encontrar("leguay.alexandre@gmail.com");
		u.setSuspended(true);
		factory.getUsuarioDAO().modificar(u);
		
		
		
		System.out.println("done");
	}
}
