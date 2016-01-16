package misDaos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import misClases.Bicicleta;


public class BicicletaDAOhiberjpa implements BicicletaDAO{

		@SuppressWarnings("unchecked")
		public List <Bicicleta> listar(){
			EntityManager em = FactoryDAO.em;
			List<Bicicleta> items =(List<Bicicleta>)(em.createQuery("from misClases.Bicicleta order by id asc")).getResultList();
			return items;
		}

		public void guardar(Bicicleta c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.persist(c);
			etx.commit();
		}
		
		public void modificar(Bicicleta c) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.merge(c);
			etx.commit();
		}

		public Bicicleta encontrar(int id) {
			EntityManager em = FactoryDAO.em;
			Query q =em.createQuery("FROM misClases.Bicicleta u WHERE u.id = ?1");
			q.setParameter(1,id);
			Bicicleta user = (Bicicleta)q.getSingleResult();
			return user;
		}
		
		public void eliminar(int idBicicleta) {
			EntityManager em = FactoryDAO.em;
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			Query q = em.createQuery("DELETE FROM misClases.Bicicleta u WHERE u.id = :id");
			q.setParameter("id",idBicicleta);
			int deleted = q.executeUpdate();
			etx.commit();
		}

}

