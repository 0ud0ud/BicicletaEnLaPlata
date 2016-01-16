package misDaos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import misClases.Estado;


public class EstadoDAOhiberjpa implements EstadoDAO{

		@SuppressWarnings("unchecked")
		public List <Estado> listar(){
			EntityManager em = FactoryDAO.em;
			List<Estado> items =(List<Estado>)(em.createQuery("from misClases.Estado order by id asc")).getResultList();
			return items;
		}

		public void guardar(Estado c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.persist(c);
			etx.commit();
		}
		
		public void modificar(Estado c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.merge(c);
			etx.commit();
		}

		public Estado encontrar(int id) {
			EntityManager em = FactoryDAO.em;
			Query q =em.createQuery("FROM misClases.Estado u WHERE u.id = ?1");
			q.setParameter(1,id);
			Estado user = (Estado)q.getSingleResult();
			return user;
		}
		
		public void eliminar(int idEstado) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			Query q = em.createQuery("DELETE FROM misClases.Estado u WHERE u.id = :id");
			q.setParameter("id",idEstado);
			int deleted = q.executeUpdate();
			etx.commit();
		}

}

