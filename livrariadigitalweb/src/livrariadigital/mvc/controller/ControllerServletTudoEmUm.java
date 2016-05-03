package livrariadigital.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;

@SuppressWarnings("serial")
@WebServlet("/tudoemum")
public class ControllerServletTudoEmUm extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String regra = req.getParameter("regraDeNegocio");
		try {
			LivroDao dao = new LivroDao();
			
			if(regra.equals("CadastraLivro")){
				Livro livro = new Livro();
				livro.setTitulo(req.getParameter("titulo"));
				livro.setAutor(req.getParameter("autor"));
				//editora, email, data...código para tratamento da data...
				dao.adiciona(livro);
				
				RequestDispatcher rd = req.getRequestDispatcher("/livrocadastrado.jsp");
				rd.forward(req, res);
			} else if(regra.equals("ListaLivros")){
				//tudo que faz listar um livro e redireciona para listalivros2.jsp
			} else if(regra.equals("DeletaLivro")){
				//tudo que precisa para deletar um livro e redireciona para listalivros2.jsp
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
		
		
//		//Extraindo as classes que implementam as regras de negócio
//		try {
//			LivroDao dao = new LivroDao();
//			
//			if(regra.equals("CadastraLivro")){
//				new CadastraLivro().executa(req, res);
//			} else if(regra.equals("ListaLivros")){
//				new ListaLivro().executa(req, res);
//			} else if(regra.equals("DeletaLivro")){
//				new DeletaLivro().executa(req, res);
//			}
//			//mas a cada nova lógica teria que alterar o servlet controller
//			//além de implementar a nova lógica: cadê a separação entre as camadas?
//			//cada a manutenibilidade?...vamos generalizar
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}