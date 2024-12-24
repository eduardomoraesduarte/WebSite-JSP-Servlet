package com.deveduardo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deveduardo.modelo.Usuario;

public class UsuarioDAO {

	/**private Connection connection;
	
	private void conectar() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}

	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}*/
	
	public void inserirUsuario(Usuario usuario){
			 
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

