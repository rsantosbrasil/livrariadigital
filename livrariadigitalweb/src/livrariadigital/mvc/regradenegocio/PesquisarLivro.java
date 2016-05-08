package livrariadigital.mvc.regradenegocio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livrariadigital.dao.LivroDao;

//alterado
public class PesquisarLivro implements RegraDeNegocio{
	public String execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		//Livro livro = new Livro();
		
		String palavra = (req.getParameter("data[search]"));
		LivroDao dao = new LivroDao();
		
		dao.pesquisaPalavra(palavra);
		System.out.println("livro localizado!");
			
		return "pesquisarlivro.jsp";
	}
}