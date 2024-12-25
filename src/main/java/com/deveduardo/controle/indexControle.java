package com.deveduardo.controle;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deveduardo.controle.seguranca.Criptografia;
import com.deveduardo.controle.util.ManipulacaoData;
import com.deveduardo.dao.UsuarioDAO;
import com.deveduardo.modelo.Usuario;

@WebServlet("/publica")
public class indexControle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public indexControle() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		try {
			switch (acao) {
			case "novo":
				novoUsuario(request, response);
				break;
			case "inserir":
				gravarUsuario(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**Connection conexaoJDBC = Conexao.getConexao();
		if (conexaoJDBC != null) {
			System.out.println("Conexao aberta");
		} else {
			System.out.println("Sem conexao");

		}*/

		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-novo-usuario.jsp");
		dispatcher.forward(request, response);
	}

	private void gravarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, NoSuchAlgorithmException {		
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String login = request.getParameter("login");		
		String data = request.getParameter("nascimento");
		
		
		ManipulacaoData manipulacaoData = new ManipulacaoData();
		Date dataNascimento = manipulacaoData.converterStringData(data);
		
		String senhaCriptografada = Criptografia.converterParaMD5(password);
		
		Usuario usuario = new Usuario(nome, cpf, dataNascimento, email, senhaCriptografada, login, false);
		
		System.out.println(usuario);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.inserirUsuario(usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-novo-usuario.jsp");
		request.setAttribute("mensagem", "Usuario cadastrado com sucesso");
		dispatcher.forward(request, response);
	}

}
