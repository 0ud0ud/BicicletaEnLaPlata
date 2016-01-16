package misDaos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import misClases.Usuario;


public class UsuarioDAOhiberjpa implements UsuarioDAO{



	@SuppressWarnings("unchecked")
	public List <Usuario> listar(){
		EntityManager em = FactoryDAO.em;
		List<Usuario> items =(List<Usuario>)(em.createQuery("from misClases.Usuario order by id asc")).getResultList();
		return items;
	}

	public void guardar(Usuario c) {
		EntityManager em = FactoryDAO.em;
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(c);
		etx.commit();
	}

	public void modificar(Usuario c) {
		EntityManager em = FactoryDAO.em;
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.merge(c);
		etx.commit();
	}

	public Usuario encontrar(int id) {
		EntityManager em = FactoryDAO.em;
		Query q =em.createQuery("FROM misClases.Usuario u WHERE u.id = ?1");
		q.setParameter(1,id);
		Usuario user = (Usuario)q.getSingleResult();
		return user;
	}

	public Usuario encontrar(String mail) {
		EntityManager em = FactoryDAO.em;
		try
		{
			Query q =em.createQuery("FROM misClases.Usuario u WHERE u.mail = ?1");
			q.setParameter(1,mail);
			Usuario user = (Usuario)q.getSingleResult();
			return user;
		}catch(NoResultException e)
		{
			return null;
		}
	}

	public void eliminar(int idUsuario) {
		EntityManager em = FactoryDAO.em;
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		Query q = em.createQuery("DELETE FROM misClases.Usuario u WHERE u.id = :id");
		q.setParameter("id",idUsuario);
		int deleted = q.executeUpdate();
		etx.commit();
	}

}

