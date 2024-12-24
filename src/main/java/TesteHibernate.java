import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deveduardo.modelo.Usuario;

public class TesteHibernate {
    public static void main(String[] args) {
		
		 // Esse trecho está funcionando, comentado para fazer um novo fluxo
		  
		  Usuario usr = new Usuario("João da Silva", "12345678901", new Date(),
		  "joao@email.com", "minhaSenha", "joao123", true); System.out.println(usr);
		  
		  SessionFactory sessionFactory = new
		  Configuration().configure().buildSessionFactory();
		  System.out.println("Conexão bem-sucedida!");
		  
		  Transaction transaction = null; try (Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().
		  openSession()) { 
			  transaction = session.beginTransaction(); 
			  session.save(usr);
			  transaction.commit(); 
			  } catch (Exception e) { if (transaction != null) {
		  transaction.rollback(); } e.printStackTrace(); }
		 
    	
		/*
		 * EntityManagerFactory emf = Persistence.createEntityManagerFactory("website");
		 * EntityManager em = emf.createEntityManager();
		 * 
		 * Usuario usr = em.find(Usuario.class, 1); System.out.println(usr);
		 */
    }
}
    


