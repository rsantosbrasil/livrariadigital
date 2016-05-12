package livrariadigital.mvc.regradenegocio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;

public class CarregaDadosEdit implements RegraDeNegocio {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		LivroDao dao = new LivroDao();
		String id = req.getParameter("id");
		Livro livro = dao.getPesquisaPorId(Long.valueOf(id));
		req.setAttribute("livro", livro);

		return "editarLivro.jsp";
	}

}
