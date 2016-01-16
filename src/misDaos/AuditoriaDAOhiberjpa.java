package misDaos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import misClases.Auditoria;




public class AuditoriaDAOhiberjpa implements AuditoriaDAO{

		@SuppressWarnings("unchecked")
		public List <Auditoria> listar(){
			EntityManager em = FactoryDAO.em;
			List<Auditoria> items =(List<Auditoria>)(em.createQuery("from misClases.Auditoria order by id asc")).getResultList();
			return items;
		}

		public void guardar(Auditoria c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.persist(c);
			etx.commit();
		}
		
		public void modificar(Auditoria c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.merge(c);
			etx.commit();
		}

		public Auditoria encontrar(int id) {
			EntityManager em = FactoryDAO.em;
			Query q =em.createQuery("FROM misClases.Auditoria u WHERE u.id = ?1");
			q.setParameter(1,id);
			Auditoria user = (Auditoria)q.getSingleResult();
			return user;
		}
		
		public void eliminar(int idAuditoria) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			Query q = em.createQuery("DELETE FROM misClases.Auditoria u WHERE u.id = :id");
			q.setParameter("id",idAuditoria);
			int deleted = q.executeUpdate();
			etx.commit();
		}

}

