package misDaos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import misClases.Denunciacion;


public class DenunciacionDAOhiberjpa implements DenunciacionDAO{

		@SuppressWarnings("unchecked")
		public List <Denunciacion> listar(){
			EntityManager em = FactoryDAO.em;
			List<Denunciacion> items =(List<Denunciacion>)(em.createQuery("from misClases.Denunciacion order by id asc")).getResultList();
			return items;
		}

		public void guardar(Denunciacion c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.persist(c);
			etx.commit();
		}
		
		public void modificar(Denunciacion c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.merge(c);
			etx.commit();
		}

		public Denunciacion encontrar(int id) {
			EntityManager em = FactoryDAO.em;
			Query q =em.createQuery("FROM misClases.Denunciacion u WHERE u.id = ?1");
			q.setParameter(1,id);
			Denunciacion user = (Denunciacion)q.getSingleResult();
			return user;
		}
		
		public void eliminar(int idDenunciacion) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			Query q = em.createQuery("DELETE FROM misClases.Denunciacion u WHERE u.id = :id");
			q.setParameter("id",idDenunciacion);
			int deleted = q.executeUpdate();
			etx.commit();
		}

}

