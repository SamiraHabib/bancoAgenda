package banco_agenda.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco_agenda.ConnectionFactory;
import banco_agenda.Entities.AgendaAtividades;

public class AgendaAtividadesDAO {
    private Connection connection;

    public AgendaAtividadesDAO() throws SQLException{
        this.connection = ConnectionFactory.getConnection();
    }

    public void adicionaAtiv(AgendaAtividades agendaAtividade) throws Exception{

        if(cadastroAtividade(agendaAtividade)){
            throw new Exception("A data e o horário já estão cadastrados!");
        }
        String sql = "insert into agendaAtividades (dataAtiv, horaAtiv, descricaoAtiv, duracaoAtiv, localAtiv) values (?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setDate(1, agendaAtividade.getDataAtiv());
        stmt.setString(2, agendaAtividade.getHoraAtiv());
        stmt.setString(3, agendaAtividade.getDescricaoAtiv());
        stmt.setString(4, agendaAtividade.getDuracaoAtiv());
        stmt.setString(5, agendaAtividade.getLocalAtiv());
        stmt.execute();
        stmt.close();
    }

    public boolean cadastroAtividade(AgendaAtividades agendaAtividades){
        try{
            String sql = "Select * from agendaAtividades where dataAtiv =? and horaAtiv=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, agendaAtividades.getDataAtiv());
            stmt.setString(2, agendaAtividades.getHoraAtiv());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void excluirAtiv(Date dataAtiv, String horaAtiv) throws SQLException{
        String sql = "delete from agendaAtividades where dataAtiv=? and horaAtiv=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setDate(1, dataAtiv);
        stmt.setString(2, horaAtiv);

        stmt.execute();
        stmt.close();
    }

    public void atualizarAtiv(AgendaAtividades agendaAtividade) throws SQLException{
        String sql = "update agendaAtividades set dataAtiv=?, horaAtiv=?, descricaoAtiv=?, duracaoAtiv=?, localAtiv=? where dataAtiv=? and horaAtiv=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setDate(1, agendaAtividade.getDataAtiv());
        stmt.setString(2, agendaAtividade.getHoraAtiv());
        stmt.setString(3, agendaAtividade.getDescricaoAtiv());
        stmt.setString(4, agendaAtividade.getDuracaoAtiv());
        stmt.setString(5, agendaAtividade.getLocalAtiv());

        stmt.execute();
        stmt.close();
    }

    public List<AgendaAtividades> ListarAgenda() throws SQLException{
        PreparedStatement stmt = connection.prepareStatement("select * from agendaAtividades");

        ResultSet rs = stmt.executeQuery();

        List<AgendaAtividades> agendaAtividades = new ArrayList<AgendaAtividades>();

        while (rs.next()){
            AgendaAtividades agendaAtividade = new AgendaAtividades();

            agendaAtividade.setDataAtiv(rs.getDate("dataAtiv"));
            agendaAtividade.setHoraAtiv(rs.getString("horaAtiv"));
            agendaAtividade.setDescricaoAtiv(rs.getString("descricaoAtiv"));
            agendaAtividade.setDuracaoAtiv(rs.getString("duracaoAtiv"));
            agendaAtividade.setLocalAtiv(rs.getString("localAtiv"));

            agendaAtividades.add(agendaAtividade);
        }

        rs.close();
        stmt.close();

        return agendaAtividades;
    }
}
