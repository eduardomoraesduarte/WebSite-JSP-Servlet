import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.deveduardo.modelo.Usuario;

public class TesteHibernate {
    public static void main(String[] args) {
		
		 // Esse trecho está funcionando, comentado para fazer um novo fluxo
		  
	/**	  Usuario usr = new Usuario("João da Silva", "12345678901", new Date(),
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
		 */
    	
    	 String persistenceUnitName = "website"; 

         // Cria a EntityManagerFactory
         EntityManagerFactory emf = null;
         EntityManager em = null;

         try {
             // Inicializa a EntityManagerFactory e o EntityManager
             emf = Persistence.createEntityManagerFactory(persistenceUnitName);
             em = emf.createEntityManager();

             // Testa a conexão iniciando uma transação fictícia
             em.getTransaction().begin();
             System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
             
             Usuario usr = new Usuario("João da Silva", "12345678901", new Date(),
           	 "jose@email.com", "minhaSenha", "jose123", true); 
             System.out.println(usr);
             em.persist(usr);
             em.getTransaction().commit();
             System.out.println("Usuário salvo com sucesso!");
             
             em.getTransaction().rollback(); // Reverte a transação fictícia
         } catch (Exception e) {
             System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
             e.printStackTrace();
         } finally {
             if (em != null) {
                 em.close(); // Fecha o EntityManager
             }
             if (emf != null) {
                 emf.close(); // Fecha a EntityManagerFactory
             }
         }
     }
}
    


