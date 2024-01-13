package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBancoDados {
	private static ConexaoBancoDados instance;
	private Connection connection;

	private ConexaoBancoDados() throws SQLException, ClassNotFoundException {

		String DRIVER = "org.postgresql.Driver";
		String banco = System.getenv("POSTGRES_DATABASE");
		String URL = "jdbc:postgresql://localhost:5432/" + banco;
		String usuario = System.getenv("POSTGRES_USER");
		String senha = System.getenv("POSTGRES_PASSWORD");

		Class.forName(DRIVER);

		connection = DriverManager.getConnection(URL, usuario, senha);

	}

	public static ConexaoBancoDados getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null) {
			synchronized (ConexaoBancoDados.class) {
				if (instance == null) {
					instance = new ConexaoBancoDados();
				}
			}
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	public static void fecharConexao(PreparedStatement ps, Connection conn, ResultSet rs) throws SQLException {

		if (ps != null) {
			ps.close();
		}
		if (rs != null) {
			rs.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

}
