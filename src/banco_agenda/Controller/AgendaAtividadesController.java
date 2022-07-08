package banco_agenda.Controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import banco_agenda.DAO.AgendaAtividadesDAO;
import banco_agenda.Entities.AgendaAtividades;

public class AgendaAtividadesController {
    private AgendaAtividadesDAO agendaAtividadesDAO;

    public AgendaAtividadesController() throws SQLException{
        this.agendaAtividadesDAO = new AgendaAtividadesDAO();
    }

    public void AdicionarAgenda(AgendaAtividades agendaAtividade) throws SQLException, Exception{
        agendaAtividadesDAO.adicionaAtiv(agendaAtividade);
    }

    public void ExcluirAgenda(Date dataAtiv, String horaAtiv) throws SQLException{
        agendaAtividadesDAO.excluirAtiv(dataAtiv, horaAtiv);
    }

    public void AtualizarAgenda(AgendaAtividades agendaAtividades) throws SQLException{
        agendaAtividadesDAO.atualizarAtiv(agendaAtividades);
    }

    public List<AgendaAtividades> ListarAgenda() throws SQLException{

        List<AgendaAtividades> listar = agendaAtividadesDAO.ListarAgenda();

        return listar;
    }
}
