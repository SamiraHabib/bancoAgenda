package banco_agenda.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco_agenda.ConnectionFactory;
import banco_agenda.Entities.Telefone;

public class TelefoneDAO {
    private Connection connection;

    public TelefoneDAO() throws SQLException{
        this.connection = ConnectionFactory.getConnection();
    }

    public void adicionaTel(Telefone telefone) throws SQLException{
        String sql = "insert into telefone (idTel, numeroTel, tipoTel, idPesFK) values (null,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, telefone.getNumeroTel());
        stmt.setString( 2, telefone.getTipoTel());
        stmt.setInt(3, telefone.getIdPesFK());

        stmt.execute();
        stmt.close();
    }

    public void excluirTel(int id) throws SQLException{
        String sql = "delete from telefone where idTel=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();
    }

    public void atualizarTel(Telefone telefone) throws SQLException{
        String sql = "update telefone set numeroTel=?, tipoTel=? where idTel=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, telefone.getNumeroTel());
        stmt.setString(2, telefone.getTipoTel());

        stmt.execute();
        stmt.close();
    }

    public List<Telefone> listarTel() throws SQLException{
        PreparedStatement stmt = connection.prepareStatement("select * from pessoa, telefone where pessoa.idPes=telefone.idPesFK");

        ResultSet rs = stmt.executeQuery();

        List<Telefone> telefones = new ArrayList<Telefone>();

        while (rs.next()){
            Telefone telefone = new Telefone();

            telefone.setIdTel(rs.getInt("idTel"));
            telefone.setNumeroTel(rs.getString("numeroTel"));
            telefone.setTipoTel(rs.getString("tipoTel"));
            telefone.setIdPesFK(rs.getInt("idPesFK"));

            telefones.add(telefone);
        }

        rs.close();
        stmt.close();

        return telefones;
    }
}
