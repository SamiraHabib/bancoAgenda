package banco_agenda.Views;

import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import banco_agenda.ScannerFactory;
import banco_agenda.Controller.PessoaController;
import banco_agenda.Controller.TelefoneController;
import banco_agenda.Entities.Pessoa;
import banco_agenda.Entities.Telefone;

public class PessoaView {

    private PessoaController pessoaController;

    public void AdicionarPessoa() throws SQLException, ParseException{
        Scanner s = ScannerFactory.getScanner();
        System.out.println("\nInforme o nome: ");
        String nome = s.nextLine();
        System.out.println("\nInforme a data de nascimento - Ex (aaa/MM/dd): ");
        String dataNasc = s.nextLine().replace("/", "-");
        Date dataNascFormatada = Date.valueOf(dataNasc);
        System.out.println("\nInforme a rua em que mora: ");
        String rua = s.nextLine();
        System.out.println("\nInforme a cidade em que mora: ");
        String cidade = s.nextLine();
        System.out.println("\nInforme o número da rua em que mora: ");
        int numero = s.nextInt();
        s.nextLine();

        Pessoa p = new Pessoa(nome, dataNascFormatada, rua, cidade, numero);

        pessoaController = new PessoaController();

        pessoaController.InserirPessoa(p);
    }

    public void ExcluirPessoa() throws SQLException{
        Scanner s = ScannerFactory.getScanner();

        System.out.println("\nLista de pessoas para escolher o id: ");
        ListarPessoa();

        System.out.println("\nInforme o id: ");
        int idExcluir = s.nextInt();
        s.nextLine();

        pessoaController = new PessoaController();

        pessoaController.ExcluirPessoa(idExcluir);
    }

    public void AtualizarPessoa() throws SQLException, ParseException{
        Scanner scan = ScannerFactory.getScanner();

        System.out.println("\nLista de pessoas para escolher o id: ");
        ListarPessoa();
        
        System.out.println("\nInforme o id da pessoa que deseja atualizar: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("\nInforme o nome: ");
        String nome = scan.nextLine();
        System.out.println("\nInforme a data de nascimento - Ex (aaa/MM/dd):  ");
        String dataNasc = scan.nextLine().replace("/", "-");
        Date dataNascFormatada = Date.valueOf(dataNasc);
        System.out.println("\nInforme a rua em que mora: ");
        String rua = scan.nextLine();
        System.out.println("\nInforme a cidade em que mora: ");
        String cidade = scan.nextLine();
        System.out.println("\nInforme o número da rua em que mora: ");
        int numero = scan.nextInt();
        scan.nextLine();

        Pessoa pessoa = new Pessoa(id, nome, dataNascFormatada, cidade, rua, numero);

        pessoaController = new PessoaController();

        pessoaController.AtualizarPessoa(pessoa);
    }

    public void ListarPessoa() throws SQLException{
        pessoaController = new PessoaController();
        TelefoneController telefoneController = new TelefoneController();
        List<Pessoa> pessoasLista = pessoaController.ListarPessoa();
        List<Telefone> telefones_p = telefoneController.ListarTel();
        int index = 0;
        System.out.println("\nListagem de pessoas: ");
        for (Pessoa pessoa : pessoasLista) {
            System.out.println("\nId da Pessoa: " + pessoa.getIdPes());
            System.out.println("Nome: " + pessoa.getNomePes());
            System.out.println("Data de nascimento: " + pessoa.getDataNascPes());
            System.out.println("Cidade: " + pessoa.getCidadePes());
            System.out.println("Rua: " + pessoa.getRuaPes());
            System.out.println("Número: " + pessoa.getNumeroPes());
            for(Telefone tel : telefones_p){
                if (pessoa.getIdPes() == tel.getIdPesFK()){
                    System.out.println("\tTelefone " + (index+1) + ": ");
                    System.out.println("\tNúmero do telefone: " + tel.getNumeroTel());
                    System.out.println("\tTipo do telefone: " + tel.getTipoTel());
                }
                index++;
            }
        }
    }
}
