package livrariadigital.testes;

import java.sql.Connection;
import java.sql.SQLException;

import livrariadigital.jdbc.FabricaDeConexoes;

public class TesteConexaoBancoDeDados {
	public static void main(String[] args) throws SQLException {
		Connection conn = new FabricaDeConexoes().getConnection();
		System.out.println("Conexão com o Banco de Dados aberta com sucesso!");
		conn.close();
	}
}