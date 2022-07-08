package banco_agenda;

import banco_agenda.Views.AgendaAtividadesView;
import banco_agenda.Views.ParticipaView;
import banco_agenda.Views.PessoaView;
import banco_agenda.Views.TelefoneView;

import java.sql.SQLException;
import java.util.Scanner;

public class Banco_agenda {

    public static void main(String[] args) throws SQLException, Exception {

        int Opcao = 0;
        Scanner scan = ScannerFactory.getScanner();
        PessoaView pessoaView = new PessoaView();
        TelefoneView telefoneView = new TelefoneView();
        AgendaAtividadesView agendaAtividadesView = new AgendaAtividadesView();
        ParticipaView participaView = new ParticipaView();

        while(Opcao != 5){
            int op = 0;
            System.out.println(
                "\nOpções: \n1- Menu de Pessoa \n2- Menu de Telefone \n3- Menu de Atividades \n4- Inserção do horário de chegada"
                        + "\n5- Finalizar programa \nR:");
            Opcao = scan.nextInt();
            scan.nextLine();

            switch(Opcao){
                case 1:
                    while(op != 5){
                        System.out.println(
                            "\nOpções Pessoa: \n1- Adicionar pessoa \n2- Excluir pessoa \n3- Atualizar pessoa"
                                + "\n4- Listar pessoas \n5- Voltar ao menu principal\nR:");
                        op = scan.nextInt();
                        scan.nextLine();
                        switch(op){
                            case 1:
                                pessoaView.AdicionarPessoa();
                                break;
                            case 2:
                                pessoaView.ExcluirPessoa();
                                break;
                            case 3:
                                pessoaView.AtualizarPessoa();
                                break;
                            case 4:
                                pessoaView.ListarPessoa();
                                break;
                            case 5:
                                System.out.println("\nMenu Principal:");
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:
                    op = 0;
                    while(op != 5){
                        System.out.println(
                            "\nOpções Telefone: \n1- Adicionar Telefone \n2- Excluir telefone \n3- Atualizar telefone"
                                + "\n4- Listar telefones \n5- Voltar ao menu principal\nR:");
                        op = scan.nextInt();
                        scan.nextLine();

                        switch(op){
                            case 1:
                                telefoneView.AdicionarTelefone();
                                break;
                            case 2:
                                telefoneView.ExcluirTelefone();
                                break;
                            case 3:
                                telefoneView.AtualizarTelefone();
                                break;
                            case 4:
                                telefoneView.ListarTelefone();
                                break;
                            case 5:
                                System.out.println("\nMenu Principal:");
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 3:
                    op = 0;
                    while(op != 5){
                        System.out.println(
                            "\nOpções Atividade: \n1- Adicionar atividade na agenda \n2- Excluir atividade \n3- Atualizar atividade"
                                + "\n4- Listar atividades \n5- Voltar ao menu principal\nR:");
                        op = scan.nextInt();
                        scan.nextLine();

                        switch(op){
                            case 1:
                                agendaAtividadesView.AdicionarAgenda();
                                break;
                            case 2:
                                agendaAtividadesView.ExcluirAgenda();
                                break;
                            case 3:
                                agendaAtividadesView.AtualizarAgenda();
                                break;
                            case 4:
                                agendaAtividadesView.ListarAgenda();
                                break;
                            case 5:
                                System.out.println("\nMenu Principal:");
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 4:
                    op = 0;
                    while(op != 5){
                        System.out.println(
                            "\nOpções horários e agenda pessoal: \n1- Adicionar horário de chegada da pessoa \n2- Excluir horário \n3- Atualizar horário"
                                + "\n4- Listar horários de chegada nos eventos \n5- Voltar ao menu principal\nR:");
                        op = scan.nextInt();
                        scan.nextLine();

                        switch(op){
                            case 1:
                                participaView.AdicionarHorario();
                                break;
                            case 2:
                                participaView.Excluir();
                                break;
                            case 3:
                                participaView.AtualizarHorario();
                                break;
                            case 4:
                                participaView.ListarHorario();
                                break;
                            case 5:
                                System.out.println("\nMenu Principal:");
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("\nFim de programa!\n");
                    break;
                default:
                    break;
            }
        }
        ScannerFactory.closeScanner();
    }  
}
