package misDaos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import misClases.Alquiler;


public class AlquilerDAOhiberjpa implements AlquilerDAO{

		@SuppressWarnings("unchecked")
		public List <Alquiler> listar(){
			EntityManager em = FactoryDAO.em;
			List<Alquiler> items =(List<Alquiler>)(em.createQuery("from misClases.Alquiler order by id asc")).getResultList();
			return items;
		}

		public void guardar(Alquiler c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.persist(c);
			etx.commit();
		}
		
		public void modificar(Alquiler c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.merge(c);
			etx.commit();
		}

		public Alquiler encontrar(int id) {
			EntityManager em = FactoryDAO.em;
			Query q =em.createQuery("FROM misClases.Alquiler u WHERE u.id = ?1");
			q.setParameter(1,id);
			Alquiler user = (Alquiler)q.getSingleResult();
			return user;
		}
		
		public void eliminar(int idAlquiler) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			Query q = em.createQuery("DELETE FROM misClases.Alquiler u WHERE u.id = :id");
			q.setParameter("id",idAlquiler);
			int deleted = q.executeUpdate();
			etx.commit();
		}

}

