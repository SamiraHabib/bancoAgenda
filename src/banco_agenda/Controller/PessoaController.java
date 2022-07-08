package banco_agenda.Controller;

import banco_agenda.DAO.PessoaDAO;
import banco_agenda.Entities.Pessoa;

import java.sql.SQLException;
import java.util.List;

public class PessoaController {
    private PessoaDAO pessoaDAO;
    
    public PessoaController() throws SQLException{
        this.pessoaDAO = new PessoaDAO();
    }

    public void InserirPessoa(Pessoa pessoa) throws SQLException{
        pessoaDAO.adiciona(pessoa);
    }

    public void ExcluirPessoa(int id) throws SQLException{
        pessoaDAO.excluir(id);
    }

    public void AtualizarPessoa(Pessoa pessoa) throws SQLException{
        pessoaDAO.atualizar(pessoa);
    }

    public List<Pessoa> ListarPessoa() throws SQLException{

        List<Pessoa> pessoas = pessoaDAO.listar();

        return pessoas;
    }
}
