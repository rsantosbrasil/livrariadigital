package livrariadigital.testes;

import java.sql.SQLException;
import java.util.Calendar;

import livrariadigital.dao.LivroDao;
import livrariadigital.modelo.Livro;

public class TesteAdicionaLivro {
	public static void main(String[] args) throws SQLException {
		Livro livro = new Livro();
		livro.setTitulo("Elite da Tropa");
		livro.setAutor("Rodrigo Pimentel");
		livro.setEditora("Editora Objetiva");
		livro.setEmail("elitedatropa@editoraojetiva.com.br");
		livro.setDataLancamento(Calendar.getInstance());
		
		LivroDao dao = new LivroDao();
		dao.adiciona(livro);
		
		System.out.println("Livro gravado com sucesso!!!");
	}
}