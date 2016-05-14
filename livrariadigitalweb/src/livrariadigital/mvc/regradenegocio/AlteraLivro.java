package livrariadigital.mvc.regradenegocio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;

public class AlteraLivro implements RegraDeNegocio {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Livro livro = new Livro();
		livro.setId(Long.valueOf(req.getParameter("id")));
		livro.setTitulo(req.getParameter("titulo"));
		livro.setAutor(req.getParameter("autor"));
		livro.setEditora(req.getParameter("editora"));
		livro.setEmail(req.getParameter("email"));
		
		String data = req.getParameter("data");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		Calendar data2 = Calendar.getInstance();
		data2.setTime(date);
		
		livro.setDataLancamento(data2);
		
		LivroDao dao = new LivroDao();
		dao.altera(livro);
		System.out.println("livro Alterado!");
			
		return "index.jsp";
	
	}
	

}
