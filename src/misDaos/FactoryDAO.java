package misDaos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryDAO {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jyaa");
	public static EntityManager em = emf.createEntityManager();
	
	public UsuarioDAO getUsuarioDAO(){
		return new UsuarioDAOhiberjpa();
	}
	public BicicletaDAO getBicicletaDAO(){
		return new BicicletaDAOhiberjpa();
	}
	public EstacionDAO getEstacionDAO(){
		return new EstacionDAOhiberjpa();
	}
	public EstadoDAO getEstadoDAO(){
		return new EstadoDAOhiberjpa();
	}
	public AlquilerDAO getAlquilerDAO(){
		return new AlquilerDAOhiberjpa();
	}
	public DenunciacionDAO getDenunciacionDAO(){
		return new DenunciacionDAOhiberjpa();
	}
	public AuditoriaDAO getAuditoriaDAO(){
		return new AuditoriaDAOhiberjpa();
	}
}
