package misDaos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import misClases.Estacion;


public class EstacionDAOhiberjpa implements EstacionDAO{

		@SuppressWarnings("unchecked")
		public List <Estacion> listar(){
			EntityManager em = FactoryDAO.em;
			List<Estacion> items =(List<Estacion>)(em.createQuery("from misClases.Estacion order by id asc")).getResultList();
			return items;
		}

		public void guardar(Estacion c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.persist(c);
			etx.commit();
		}
		
		public void modificar(Estacion c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.merge(c);
			etx.commit();
		}

		public Estacion encontrar(int id) {
			EntityManager em = FactoryDAO.em;
			Query q =em.createQuery("FROM misClases.Estacion u WHERE u.id = ?1");
			q.setParameter(1,id);
			Estacion user = (Estacion)q.getSingleResult();
			return user;
		}
		
		public void eliminar(int idEstacion) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			Query q = em.createQuery("DELETE FROM misClases.Estacion u WHERE u.id = :id");
			q.setParameter("id",idEstacion);
			int deleted = q.executeUpdate();
			etx.commit();
		}

}

