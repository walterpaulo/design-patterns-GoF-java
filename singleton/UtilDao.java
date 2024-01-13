package singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilDao {

	public String verificarVersaoBanco() {
		try {
			ConexaoBancoDados conexao = ConexaoBancoDados.getInstance();
			Connection conn = conexao.getConnection();
			String sql = "SELECT VERSION()";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
			ConexaoBancoDados.fecharConexao(ps, conn, rs);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "-";
		}
		return "-";
	}
}
