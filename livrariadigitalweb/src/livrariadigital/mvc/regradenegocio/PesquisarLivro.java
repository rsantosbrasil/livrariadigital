package livrariadigital.mvc.regradenegocio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;

public class PesquisarLivro implements RegraDeNegocio{
	public String execute(HttpServletRequest req, HttpServletResponse res)throws Exception {
		
		
		String palavra = (req.getParameter("search"));
		List<Livro> livros = new LivroDao().pesquisaPalavra(palavra);
		req.setAttribute("livros", livros);
		return "pesquisarlivros.jsp";
		
		
		
		
		
	}
}