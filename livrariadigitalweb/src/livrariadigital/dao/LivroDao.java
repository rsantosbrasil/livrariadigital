package livrariadigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import livrariadigital.jdbc.FabricaDeConexoes;
import livrariadigital.modelo.Livro;

public class LivroDao {
	private Connection conn;

	// Construtor de LivroDao que pega uma conexão na Fábrica de Conexões
	public LivroDao() throws SQLException {
		this.conn = new FabricaDeConexoes().getConnection();
	}

	// método que adiciona livro ao Banco de Dados livrariadigital
	public void adiciona(Livro livro) {
		String sql = "insert into livro(titulo, autor, editora, email, dtlancamento) values (?,?,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setString(4, livro.getEmail());
			stmt.setDate(5, new Date(livro.getDataLancamento().getTimeInMillis()));

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// método que retorna uma lista de livros pesquisada no Banco de Dados
	// livrariadigital
	public List<Livro> getListaLivro() {
		try {
			List<Livro> livros = new ArrayList<Livro>();

			String sql = "select * from livro";

			PreparedStatement stmt = this.conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Livro livro = new Livro();
				livro.setId(rs.getLong("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
				livro.setEmail(rs.getString("email"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dtlancamento"));
				livro.setDataLancamento(data);

				livros.add(livro);
			}

			rs.close();
			stmt.close();
			return livros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// método que altera o conteúdo de um livro no Banco de Dados
	public void altera(Livro livro) {
		String sql = "update livro set titulo=?, autor=?, editora=?, email=?, dtlancamento=? where id=?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setString(4, livro.getEmail());
			stmt.setDate(5, new Date(livro.getDataLancamento().getTimeInMillis()));
			stmt.setLong(6, livro.getId());

			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void exclui(Livro livro) {
		try {
			String sql = "delete from livro where id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	// adicionado
	public List<Livro> pesquisaPalavra(String palavra) throws SQLException {

		String sql = "SELECT * FROM livro WHERE titulo LIKE ? or autor LIKE ? or  editora LIKE ?";
		
		
		
		PreparedStatement stm = conn.prepareStatement(sql);

		stm.setString(1, "%" + palavra + "%");
		stm.setString(2, "%" + palavra + "%");
		stm.setString(3, "%" + palavra + "%");

		ResultSet rset = stm.executeQuery(); // faz a consulta
		List<Livro> livros = new ArrayList<Livro>();

		while (rset.next()) { // traz as colunas dos registros em cada livro
			Livro livro = new Livro();
			livro.setId(rset.getLong("id"));
			livro.setTitulo(rset.getString("titulo"));
			livro.setAutor(rset.getString("autor"));
			livro.setEditora(rset.getString("editora"));
			livro.setEmail(rset.getString("email"));

			Calendar data = Calendar.getInstance();
			data.setTime(rset.getDate("dtlancamento"));
			livro.setDataLancamento(data);

			livros.add(livro); // adiciona o item que esta em memoria para lista
		}

		rset.close();
		stm.close();
		return livros;

	}

	public Livro getPesquisaPorId(Long id) throws SQLException {

		String sql = "SELECT * FROM livro WHERE id=?";
		Livro livro = null;

		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setLong(1, id);

			ResultSet rset = stm.executeQuery(); // faz a consulta

			if (rset.next()) {
				livro = new Livro();
				livro.setId(rset.getLong("id"));
				livro.setTitulo(rset.getString("titulo"));
				livro.setAutor(rset.getString("autor"));
				livro.setEditora(rset.getString("editora"));
				livro.setEmail(rset.getString("email"));

				Calendar data = Calendar.getInstance();
				data.setTime(rset.getDate("dtlancamento"));
				livro.setDataLancamento(data);
			}
			
			rset.close();
			stm.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return livro;
	
	}
}