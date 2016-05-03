package livrariadigital.testes;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;

public class TestaListaLivros {
	public static void main(String[] args) throws SQLException {
		LivroDao dao = new LivroDao();
		
		List<Livro> livros = dao.getLista();
		
		for (Livro livro : livros) {
			System.out.println("Título: "+ livro.getTitulo());
			System.out.println("Autor: "+ livro.getAutor());
			System.out.println("Editora: "+ livro.getEditora());
			System.out.println("Em-mail: "+ livro.getEmail());
			System.out.println("Data de Lançamento: "+ livro.getDataLancamento().getTime() + "\n");
			
			@SuppressWarnings("unused")
			SimpleDateFormat sdf;
		}
	}
}