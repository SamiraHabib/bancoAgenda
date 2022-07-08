package banco_agenda.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco_agenda.ConnectionFactory;
import banco_agenda.Entities.Participa;

public class ParticipaDAO {
    private Connection connection;

    public ParticipaDAO() throws SQLException{
        this.connection = ConnectionFactory.getConnection();
    }

    public void adicionaParticipa(Participa participa) throws SQLException {
        String sql = "insert into participa (horarioChegada, idPesFK, dataAtivFK, horaAtivFK) values (?,?,?,?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setTime(1, participa.getHorarioChegada());
        stmt.setInt(2, participa.getIdPesFK());
        stmt.setDate( 3, participa.getDataAtivFK());
        stmt.setString(4, participa.getHoraAtivFk());
        stmt.execute();
        stmt.close();
    }

    public void excluirParticipa(int idPesFK, Date dataAtivFK, String horaAtivFK) throws SQLException{
        String sql = "delete from participa where idPesFK=? and dataAtivFK=? and horaAtivFK=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, idPesFK);
        stmt.setDate(2, dataAtivFK);
        stmt.setString(3, horaAtivFK);

        stmt.execute();
        stmt.close();
    }

    public void atualizarParticipa(Participa participa) throws SQLException{
        String sql = "update participa set horarioChegada=? where idPesFK=? and dataAtiv=? and horaAtiv=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setTime(1, participa.getHorarioChegada());
        stmt.setInt(2, participa.getIdPesFK());
        stmt.setDate(3, participa.getDataAtivFK());
        stmt.setString(4, participa.getHoraAtivFk());

        stmt.execute();
        stmt.close();
    }

    public List<Participa> ListarParticipa() throws SQLException{
        PreparedStatement stmt = connection.prepareStatement("select * from participa");

        ResultSet rs = stmt.executeQuery();

        List<Participa> participam = new ArrayList<Participa>();

        while (rs.next()){
            Participa participa = new Participa();

            participa.setHorarioChegada(rs.getTime("horarioChegada"));
            participa.setIdPesFK(rs.getInt("idPesFK"));
            participa.setDataAtivFK(rs.getDate("dataAtivFK"));
            participa.setHoraAtivFk(rs.getString("horaAtivFK"));

            participam.add(participa);
        }

        rs.close();
        stmt.close();

        return participam;
    }
}
