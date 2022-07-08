package banco_agenda.Controller;

import java.sql.SQLException;
import java.util.List;

import banco_agenda.DAO.TelefoneDAO;
import banco_agenda.Entities.Telefone;

public class TelefoneController {
    private TelefoneDAO telefoneDAO;

    public TelefoneController() throws SQLException{
        this.telefoneDAO = new TelefoneDAO();
    }

    public void AdicionarTel(Telefone telefone) throws SQLException{
        telefoneDAO.adicionaTel(telefone);
    }

    public void ExcluirTel(int idExcluir) throws SQLException{
        telefoneDAO.excluirTel(idExcluir);
    }

    public void AtualizarTel(Telefone telefone) throws SQLException{
        telefoneDAO.atualizarTel(telefone);
    }

    public List<Telefone> ListarTel() throws SQLException{
        List<Telefone> telefones = telefoneDAO.listarTel();

        return telefones;
    }
}
