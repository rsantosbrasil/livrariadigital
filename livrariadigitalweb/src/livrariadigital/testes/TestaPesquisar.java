package livrariadigital.testes;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;

public class TestaPesquisar {

	public static void main(String[] args) throws SQLException {

		//alterado
		LivroDao dao = new LivroDao();

		List<Livro> livros = dao.pesquisaPalavra("pedra");

		for (Livro livro : livros) {
			System.out.println("Título: " + livro.getTitulo());
			System.out.println("Autor: " + livro.getAutor());
			System.out.println("Editora_Teste: " + livro.getEditora());
			System.out.println("Em-mail: " + livro.getEmail());
			System.out.println("Data de Lançamento: " + livro.getDataLancamento().getTime() + "\n");

			@SuppressWarnings("unused")
			SimpleDateFormat sdf;

		}
	}

}
