package banco_agenda.Views;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import banco_agenda.ScannerFactory;
import banco_agenda.Controller.ParticipaController;
import banco_agenda.Controller.PessoaController;
import banco_agenda.Entities.Participa;
import banco_agenda.Entities.Pessoa;

public class ParticipaView {
    private ParticipaController participaController;
    private PessoaView pessoaView;
    private AgendaAtividadesView agendaAtividadesView;

    public void AdicionarHorario() throws SQLException{
        Scanner s = ScannerFactory.getScanner();
        System.out.println("\nInforme o horário de chegada - Ex (hh:mm:ss): ");
        String horarioChegada = s.nextLine();
        Time horario = Time.valueOf(horarioChegada);
        pessoaView = new PessoaView();
        pessoaView.ListarPessoa();
        System.out.println("\nInforme o id da Pessoa: ");
        int idPesFK = s.nextInt();
        s.nextLine();
        agendaAtividadesView = new AgendaAtividadesView();
        agendaAtividadesView.ListarAgenda();
        System.out.println("\nInforme a data da atividade marcada - EX (aaaa/MM/dd): ");
        String dataAtivFK = s.nextLine().replace("/", "-");
        Date data = Date.valueOf(dataAtivFK);
        System.out.println("\nInforme o horário da atividade marcada - Ex (hh:mm:ss): ");
        String horaAtivFk = s.nextLine();

        Participa participa = new Participa(horario, idPesFK, data, horaAtivFk);

        participaController = new ParticipaController();

        participaController.InserirPart(participa);
    }

    public void Excluir() throws SQLException{
        Scanner s = ScannerFactory.getScanner();

        pessoaView = new PessoaView();
        pessoaView.ListarPessoa();
        System.out.println("\nInforme o id da pessoa para excluir: ");
        int idPes = s.nextInt();
        s.nextLine();
        agendaAtividadesView = new AgendaAtividadesView();
        agendaAtividadesView.ListarAgenda();
        System.out.println("\nInforme o data da atividade - Ex (aaa/MM/dd): ");
        String dataEx = s.nextLine().replace("/", "-");
        Date dataFormatadaEx = Date.valueOf(dataEx);
        System.out.println("\nInforme a hora da atividade - Ex (hh:mm:ss): ");
        String horaEx = s.nextLine();

        participaController = new ParticipaController();

        participaController.ExcluirPart(idPes, dataFormatadaEx, horaEx);
    }

    public void AtualizarHorario() throws SQLException{
        Scanner s = ScannerFactory.getScanner();
        pessoaView = new PessoaView();
        pessoaView.ListarPessoa();
        System.out.println("\nDigite o id da pessoa para atualizar: ");
        int idPesFK = s.nextInt();
        s.nextLine();

        System.out.println("\nLista de horários já cadastrados: ");
        ListarHorario();

        System.out.println("\nInforme o horário de chegada que deseja atualizar - Ex (hh:mm:ss): ");
        String novoHorarioChegada = s.nextLine();
        Time novoHorario = Time.valueOf(novoHorarioChegada);

        Participa participa = new Participa(novoHorario, idPesFK);

        participaController = new ParticipaController();

        participaController.AtualizarPart(participa);
    }

    public void ListarHorario() throws SQLException{
        participaController = new ParticipaController();
        PessoaController pessoaController = new PessoaController();
        List<Participa> horarioLista = participaController.ListarParticipa();
        List<Pessoa> pessoas = pessoaController.ListarPessoa();
        int index = 0;

        System.out.println("\nListagem de horários e participantes: ");
        for (Participa participa : horarioLista) {
            System.out.println("\nAtividade " + (index+1) +":");
            System.out.println("\nHorário de chegada: " + participa.getHorarioChegada());
            System.out.println("Data da atividade: " + participa.getDataAtivFK());
            System.out.println("Hora da atividade: " + participa.getHoraAtivFk());
            System.out.println("Id da pessoa: " + participa.getIdPesFK());
            System.out.println("\tPessoas que participam dessa atividade: ");
            for(Pessoa p : pessoas){
                if(participa.getIdPesFK() == p.getIdPes()){
                    System.out.println("\tNome: " + p.getNomePes());
                }
            }
            index++;
        }
    }
}
