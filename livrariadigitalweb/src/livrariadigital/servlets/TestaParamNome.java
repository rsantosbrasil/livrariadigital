package livrariadigital.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/testaParametro")
public class TestaParamNome extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("apelido");
		
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Testando a passagem de parâmetros e a captura através de request:</h1><br>");
		out.print(nome);
		out.println("</body>");
		out.println("</html>");
	}	
}