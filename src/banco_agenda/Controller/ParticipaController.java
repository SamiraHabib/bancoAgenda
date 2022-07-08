package banco_agenda.Controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import banco_agenda.DAO.ParticipaDAO;
import banco_agenda.Entities.Participa;

public class ParticipaController {
    private ParticipaDAO participaDAO;

    public ParticipaController() throws SQLException{
        this.participaDAO = new ParticipaDAO();
    }

    public void InserirPart(Participa participa) throws SQLException{
        participaDAO.adicionaParticipa(participa);
    }

    public void ExcluirPart(int idPes, Date dataAtiv, String horaAtiv) throws SQLException{
        participaDAO.excluirParticipa(idPes, dataAtiv, horaAtiv);
    }

    public void AtualizarPart(Participa participa) throws SQLException{
        participaDAO.atualizarParticipa(participa);
    }

    public List<Participa> ListarParticipa() throws SQLException{

        List<Participa> listar = participaDAO.ListarParticipa();

        return listar;
    }
}
