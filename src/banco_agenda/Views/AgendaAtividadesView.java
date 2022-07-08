package banco_agenda.Views;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import banco_agenda.ScannerFactory;
import banco_agenda.Controller.AgendaAtividadesController;
import banco_agenda.Entities.AgendaAtividades;

public class AgendaAtividadesView {
    
    private AgendaAtividadesController agendaAtividadesController;

    public void AdicionarAgenda() throws SQLException, Exception{
        Scanner s = ScannerFactory.getScanner();
        System.out.println("\nInforme a data para agendar - Ex (aaa/MM/dd): ");
        String dataAtiv = s.nextLine().replace("/", "-");
        Date data = Date.valueOf(dataAtiv);
        System.out.println("\nInforme a hora para agendar - Ex (hh:mm:ss): ");
        String horaAtiv = s.nextLine();
        System.out.println("\nInforme a descrição da atividade: ");
        String descricaoAtiv = s.nextLine();
        System.out.println("\nInforme a duração da atividade: ");
        String duracaoAtiv = s.nextLine();
        System.out.println("\nInforme o local do evento: ");
        String localAtiv = s.nextLine();

        AgendaAtividades agenda = new AgendaAtividades(data, horaAtiv, descricaoAtiv, duracaoAtiv, localAtiv);

        agendaAtividadesController = new AgendaAtividadesController();

        agendaAtividadesController.AdicionarAgenda(agenda);
    }

    public void ExcluirAgenda() throws SQLException{
        Scanner s = ScannerFactory.getScanner();
        System.out.println("\nInforme o data da atividade: ");
        String dataEx = s.nextLine().replace("/", "-");
        Date data = Date.valueOf(dataEx);
        System.out.println("\nInforme a hora da atividade - Ex (hh:mm:ss): ");
        String horaEx = s.nextLine();

        agendaAtividadesController = new AgendaAtividadesController();

        agendaAtividadesController.ExcluirAgenda(data, horaEx);
    }

    public void AtualizarAgenda() throws SQLException{
        Scanner s = ScannerFactory.getScanner();
        System.out.println("\nInforme a data que deseja atualizar - Ex (aaaMMdd): ");
        String dataAtiv = s.nextLine().replace("/", "-");
        Date data = Date.valueOf(dataAtiv);
        System.out.println("\nInforme a hora para atualizar - Ex (hh:mm:ss): ");
        String horaAtiv = s.nextLine();
        System.out.println("\nInforme a descrição da atividade: ");
        String descricaoAtiv = s.nextLine();
        System.out.println("\nInforme a duração da atividade - Ex (hh:mm:ss): ");
        String duracaoAtiv = s.nextLine();
        System.out.println("\nInforme o local para atualizar: ");
        String localAtiv = s.nextLine();

        AgendaAtividades agenda = new AgendaAtividades(data, horaAtiv, descricaoAtiv, duracaoAtiv, localAtiv);

        agendaAtividadesController = new AgendaAtividadesController();

        agendaAtividadesController.AtualizarAgenda(agenda);
    }

    public void ListarAgenda() throws SQLException{
        agendaAtividadesController = new AgendaAtividadesController();

        List<AgendaAtividades> agendaLista = agendaAtividadesController.ListarAgenda();

        System.out.println("\nListagem de atividades agendadas: ");
        for (AgendaAtividades agenda : agendaLista) {
            System.out.println("\nData: " + agenda.getDataAtiv());
            System.out.println("Hora: " + agenda.getHoraAtiv());
            System.out.println("Descrição da atividade: " + agenda.getDescricaoAtiv());
            System.out.println("Duração da atividade: " + agenda.getDuracaoAtiv());
            System.out.println("Local da atividade: " + agenda.getLocalAtiv());
        }
    }
}
