import resources.*;
import entities.*;
import services.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Testes {
    public static void main(String[] args) {

        ArrayList<Medico> medicos = new ArrayList<>();

        //Medicos de exemplo
        Medico medico1 = new Medico("Dr. Ana Silva", "(11)9555-1234", "15/03/1975", Area.Cardiologia);
        Medico medico2 = new Medico("Dr. Carlos Ferreira", "(21)9777-4567", "22/07/1980", Area.Ortopedia);
        Medico medico3 = new Medico("Dra. Maria Rodrigues", "(31)9888-7890", "10/05/1985", Area.Pediatria);

        medicos.add(medico1);
        medicos.add(medico2);
        medicos.add(medico3);

        boolean controle = true;
        Scanner scanner = new Scanner(System.in);

        while (controle){
            System.out.println("Bem-vindo ao Agendamento de Consultas");
            System.out.println("=====================================");
            System.out.println("Selecione uma opção:\n");
            System.out.println("1 - Marcar Consulta\n2 - Cancelar Consulta\n" +
                    "3 - Verificar Horários Disponíveis\n4 - Verificar Consultas Marcadas");
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao){
                case 1 ->{
                    System.out.println("Digite o nome do Cliente: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o número de telefone do Cliente: ");
                    String telefone = scanner.nextLine();
                    System.out.println("Digite a data de nascimento do Cliente: ");
                    String dataNascimento = scanner.nextLine();
                    Paciente paciente = new Paciente(nome, telefone, dataNascimento);

                    System.out.println("Qual a área do atendimento?");
                    String area = scanner.nextLine();
                    for(Medico medico : medicos){
                        if (medico.getArea() == Area.valueOf(area)){
                            System.out.println("Digite o dia da consulta: ");
                            short dia = Short.parseShort(scanner.nextLine());
                            System.out.println("Digite o mês da consulta: ");
                            short mes = Short.parseShort(scanner.nextLine());
                            System.out.println("Digite a hora da consulta: ");
                            String hora = scanner.nextLine();
                            Horario horario = new Horario(dia, mes, hora);
                            if(!medico.getHorariosDisponiveis().contains(horario)){
                                System.out.println("Qual a urgência da consulta: ");
                                String urgencia = scanner.nextLine();
                                medico.marcarConsulta(paciente, horario, Urgencia.valueOf(urgencia));
                            } else {
                                System.out.println("Horário indisponível.");
                            }

                        }
                    }

                }
                case 2 -> {

                }
                case 3 -> {
                    System.out.println("Digite o nome do médico:\n");
                    String nomeMedico = scanner.nextLine();
                    for(Medico medico : medicos){
                        if (medico.getNome().equals(nomeMedico)){
                            for(Horario horario : medico.getHorariosDisponiveis()){
                                horario.print();
                            }
                        } else {
                            System.out.println("Médico não existe no sistema.");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Digite o nome do médico:\n");
                    String nomeMedico = scanner.nextLine();
                    for(Medico medico : medicos){
                        if (medico.getNome().equals(nomeMedico)){
                            for(Consulta consulta : medico.getConsultasMarcadas()){
                                consulta.getHorario().print();
                                System.out.println("==============");
                            }
                        } else {
                            System.out.println("Médico não existe no sistema.");
                        }
                    }
                }
                default -> {
                    controle = false;
                }
            }
        }
    }
}

