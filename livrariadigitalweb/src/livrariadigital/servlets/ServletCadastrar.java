package livrariadigital.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

@SuppressWarnings({ "serial", "unused" })
@WebServlet("/cadastralivro")
public class ServletCadastrar extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
		String email = request.getParameter("email");
		String data = request.getParameter("data");
		
		Calendar data2 = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			data2 = Calendar.getInstance();
			data2.setTime(date);
		} catch (ParseException e) {
			out.println("Erro na conversão de datas");
			return;
		}
		
		Livro livro = new Livro();
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setEmail(email);
		livro.setDataLancamento(data2);
		
		try {
			LivroDao dao = new LivroDao();
			dao.adiciona(livro);
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new ServletException(e);
		}
		
		out.println("<html>");
		out.println("<body>");
		out.println("Livro "+livro.getTitulo()+ "cadastrado com sucesso");
		out.println("</body>");
		out.println("</html>");
	}
}

		
		
		
		
		
//		RequestDispatcher rd = request.getRequestDispatcher("/livrocadastrado.jsp");
//		rd.forward(request, response);
//		
//	}
//}