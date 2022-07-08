package banco_agenda.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco_agenda.ConnectionFactory;
import banco_agenda.Entities.Pessoa;

public class PessoaDAO {

    private Connection connection;

    public PessoaDAO() throws SQLException{
        this.connection = ConnectionFactory.getConnection();
    }

    public void adiciona(Pessoa pessoa){
        String sql = "insert into pessoa (nomePes, dataNascPes, cidadePes, ruaPes, numeroPes) values (?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePes());
            stmt.setDate( 2, pessoa.getDataNascPes());
            stmt.setString(3, pessoa.getCidadePes());
            stmt.setString(4, pessoa.getRuaPes());
            stmt.setInt(5, pessoa.getNumeroPes());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void excluir(int id) throws SQLException{
        String sql = "delete from pessoa where idPes=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();
    }

    public void atualizar(Pessoa pessoa) throws SQLException{
        String sql = "update pessoa set nomePes=?, dataNascPes=?, cidadepes=?, ruaPes=?, numeroPes=? where idPes=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, pessoa.getNomePes());
        stmt.setDate(2, pessoa.getDataNascPes());
        stmt.setString(3, pessoa.getCidadePes());
        stmt.setString(4, pessoa.getRuaPes());
        stmt.setInt(5, pessoa.getNumeroPes());
        stmt.setInt(6, pessoa.getIdPes());

        stmt.execute();
        stmt.close();
    }

    public List<Pessoa> listar() throws SQLException{
        PreparedStatement stmt = connection.prepareStatement("select * from pessoa");

        ResultSet rs = stmt.executeQuery();

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (rs.next()){
            Pessoa pessoa = new Pessoa();

            pessoa.setIdPes(rs.getInt("idPes"));
            pessoa.setNomePes(rs.getString("nomePes"));
            pessoa.setDataNascPes(rs.getDate("dataNascPes"));
            pessoa.setCidadePes(rs.getString("cidadePes"));
            pessoa.setRuaPes(rs.getString("ruaPes"));
            pessoa.setNumeroPes(rs.getInt("numeroPes"));

            pessoas.add(pessoa);
        }

        rs.close();
        stmt.close();

        return pessoas;
    }
}
