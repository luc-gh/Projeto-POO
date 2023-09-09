import resources.*;
import entities.*;
import services.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Testes {

    ArrayList<Medico> medicosDoSistema = new ArrayList<>();

    public void configuracaoDeSistema(){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                =====================================
                       CONFIGURAÇÃO DE SISTEMA
                =====================================
        """);
        int n;
        try {
            System.out.print("\nDigite o número de médicos do sistema: ");
            n = sc.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("Erro! Entrada de dados inválida: " + e);
        }

        System.out.println("""
                --------------------------------------------------
                -> A seguir, defina as informações de cada médico.
                --------------------------------------------------
                """);

        System.out.println();
        System.out.println("""
                OBS: Para a área, escolha dentre as opções:
                     (1) Geral  (2) Pediatria  (3) Cardiologia  (4) Dermatologia
                     (5) Ginecologia  (6) Ortopedia  (7) Oftalmologia  (8) Neurologia
                     (9) Psiquiatria  (10) Odontologia  (11) Reumatologia  (12) Otorrinolaringologia
                     (13) Oncologia  (14) Hematologia  (15) Alergologia  (16) Infectologia
                """);
        for(int i = 1; i <= n; i++){
            System.out.println("\n" + i + "º médico\n--------------------");
            System.out.print("\nNome: ");
            String nome = sc.nextLine();
            System.out.println("\nNúmero: ");
            String numero = sc.nextLine();
            System.out.println("\nData de nascimento: ");
            String data = sc.nextLine();
            System.out.println("\nÁrea: ");
            int escolha = sc.nextInt();
            Area area = null;
            switch(escolha){
                case 1 -> area = Area.Geral;
                case 2 -> area = Area.Pediatria;
                case 3 -> area = Area.Cardiologia;
                case 4 -> area = Area.Dermatologia;
                case 5 -> area = Area.Ginecologia;
                case 6 -> area = Area.Ortopedia;
                case 7 -> area = Area.Oftalmologia;
                case 8 -> area = Area.Neurologia;
                case 9 -> area = Area.Psiquiatria;
                case 10 -> area = Area.Odontologia;
                case 11 -> area = Area.Reumatologia;
                case 12 -> area = Area.Otorrinolaringologia;
                case 13 -> area = Area.Oncologia;
                case 14 -> area = Area.Hematologia;
                case 15 -> area = Area.Alergologia;
                case 16 -> area = Area.Infectologia;
                default -> {
                    System.out.println("\nOpção inválida. Área Geral assumida.");
                    area = Area.Geral;
                }
            }
            this.medicosDoSistema.add(new Medico(nome, numero, data, area));
        }

        System.out.println("Agora, defina os horários disponíveis para cada médico:");
        for(Medico m:this.medicosDoSistema){

        }


    }

    public static void main(String[] args) {


        /*
        while(controle){
            System.out.println("Bem-vindo ao Agendamento de Consultas");
            System.out.println("=====================================");
            System.out.println("Selecione uma opção:\n");
            System.out.println("""
                    1 - Marcar Consulta
                    2 - Cancelar Consulta
                    3 - Verificar Horários Disponíveis
                    4 - Verificar Consultas Marcadas
            """);
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1 -> {
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
                            if (!medico.getHorariosDisponiveis().contains(horario)) {
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
        }*/

    }
}

