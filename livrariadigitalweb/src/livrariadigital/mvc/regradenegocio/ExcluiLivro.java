package livrariadigital.mvc.regradenegocio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;


public class ExcluiLivro implements RegraDeNegocio {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		LivroDao dao = new LivroDao();
		String id = req.getParameter("id");
		Livro livro = new Livro();
		livro.setId(Long.valueOf(id));
		dao.exclui(livro);
		System.out.println("livro Excluido!");
		
		return "index.jsp";
	}

}
