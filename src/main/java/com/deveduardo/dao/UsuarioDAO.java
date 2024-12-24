package com.deveduardo.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.deveduardo.modelo.Usuario;

public class UsuarioDAO {
	 

    private static EntityManagerFactory emf;
    static {emf = Persistence.createEntityManagerFactory("website");
    		}

    public List<Usuario> listarTodosUsuarios() throws SQLException {
        EntityManager em = emf.createEntityManager();
        List<Usuario> listaUsuarios;

        try {
            listaUsuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        } finally {
            em.close();
        }

        return listaUsuarios;
    }

    public void inserirUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(usuario);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e; // Re-throw the exception to be handled by the caller
        } finally {
            em.close();
        }
    }
}
	
	
	/**
	public void inserirUsuario(Usuario usuario) {

		Transaction transaction = null;
		try (Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(usuario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
*/