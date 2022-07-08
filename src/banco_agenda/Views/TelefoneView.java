package banco_agenda.Views;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import banco_agenda.ScannerFactory;
import banco_agenda.Controller.TelefoneController;
import banco_agenda.Entities.Telefone;

public class TelefoneView {
    private TelefoneController telefoneController;

    public void AdicionarTelefone() throws SQLException{
        Scanner s = ScannerFactory.getScanner();
        System.out.println("\nInforme o número do telefone: ");
        String num = s.nextLine();
        System.out.println("\nInforme o tipo do telefone: ");
        String tipo = s.nextLine();
        PessoaView pessoaView = new PessoaView();
        pessoaView.ListarPessoa();
        System.out.println("\nInforme o id da Pessoa: ");
        int idPes = s.nextInt();
        s.nextLine();

        Telefone telefone = new Telefone(num, tipo, idPes);

        telefoneController = new TelefoneController();

        telefoneController.AdicionarTel(telefone);
    }

    public void ExcluirTelefone() throws SQLException{
        Scanner s = ScannerFactory.getScanner();

        System.out.println("\nInforme o id: ");
        int idExcluir = s.nextInt();
        s.nextLine();

        telefoneController = new TelefoneController();

        telefoneController.ExcluirTel(idExcluir);
    }

    public void AtualizarTelefone() throws SQLException{
        Scanner s = ScannerFactory.getScanner();

        System.out.println("Lista de telefones para escolher o id de qual deseja altualizar: ");
        ListarTelefone();
        
        System.out.println("\nInforme o id do telefone que deseja atualizar: ");
        int idTel = s.nextInt();
        s.nextLine();
        System.out.println("\nInforme o número do telefone: ");
        String num = s.nextLine();
        System.out.println("\nInforme o tipo do telefone: ");
        String tipo = s.nextLine();
        PessoaView pessoaView = new PessoaView();
        pessoaView.ListarPessoa();
        System.out.println("\nInforme o id da Pessoa: ");
        int idFK = s.nextInt();
        s.nextLine();

        Telefone telefone = new Telefone(idTel, num, tipo, idFK);

        telefoneController = new TelefoneController();

        telefoneController.AtualizarTel(telefone);
    }

    public void ListarTelefone() throws SQLException{
        telefoneController = new TelefoneController();

        List<Telefone> telLista = telefoneController.ListarTel();

        System.out.println("\nListagem de telefones: ");
        for (Telefone telefone : telLista) {
            System.out.println("\nId do Telefone: " + telefone.getIdTel());
            System.out.println("Número do telefone: " + telefone.getNumeroTel());
            System.out.println("Tipo do telefone: " + telefone.getTipoTel());
            System.out.println("Id da pessoa: " + telefone.getIdPesFK());
        }
    }
}
