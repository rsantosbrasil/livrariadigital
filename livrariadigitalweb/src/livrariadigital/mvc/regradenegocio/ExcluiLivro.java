package livrariadigital.mvc.regradenegocio;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExcluiLivro")
public class ExcluiLivro implements RegraDeNegocio {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		return null;
	}

}
