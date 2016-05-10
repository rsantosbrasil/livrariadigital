package livrariadigital.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;

@SuppressWarnings("serial")
@WebServlet("/livrocontroller")
public class LivroController extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String regra = req.getParameter("regraDeNegocio");
		try {
			LivroDao dao = new LivroDao();

			if (regra.equals("CadastraLivro")) {
				Livro livro = new Livro();
				livro.setTitulo(req.getParameter("titulo"));
				livro.setAutor(req.getParameter("autor"));
				livro.setEditora(req.getParameter("editora"));
				livro.setEmail(req.getParameter("email"));

				String data = req.getParameter("data");
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
				Calendar data2 = Calendar.getInstance();
				data2.setTime(date);

				livro.setDataLancamento(data2);

				dao.adiciona(livro);
				System.out.println("livro cadastrado!");

				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, res);

			} else if (regra != null && regra.equals("AlteraLivro")) {
				String id = req.getParameter("id");
				Livro livro = dao.getPesquisaPorId(Long.valueOf(id));
				req.setAttribute("livro", livro);

				RequestDispatcher rd = req.getRequestDispatcher("/editarLivro.jsp");
				rd.forward(req, res);

			} else if (regra != null && regra.equals("DeletaLivro")) {
				String id = req.getParameter("id");
				Livro livro = new Livro();
				livro.setId(Long.valueOf(id));
				dao.exclui(livro);
				System.out.println("livro Excluido!");

				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, res);
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	}
}