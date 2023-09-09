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
            System.out.print("Digite o número de médicos do sistema: ");
            n = sc.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("Erro! Entrada de dados inválida: " + e);
        }
        System.out.println();
        System.out.println("""
                --------------------------------------------------
                -> A seguir, defina as informações de cada médico.
                --------------------------------------------------
                
                OBS: Para a área, escolha dentre as opções:
                     (1) Geral          (9) Psiquiatria
                     (2) Pediatria      (10) Odontologia
                     (3) Cardiologia    (11) Reumatologia
                     (4) Dermatologia   (12) Otorrinolaringologia
                     (5) Ginecologia    (13) Oncologia
                     (6) Ortopedia      (14) Hematologia
                     (7) Oftalmologia   (15) Alergologia
                     (8) Neurologia     (16) Infectologia
                """);
        for(int i = 1; i <= n; i++){
            System.out.println(i + "º médico\n--------------------");
            System.out.print("Nome: ");
            sc.next();
            String nome = sc.nextLine();

            System.out.print("Número: ");
            String numero = sc.nextLine();

            System.out.print("Data de nascimento: ");
            String data = sc.nextLine();

            System.out.print("Área: ");
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
            System.out.println();
        }

        System.out.println("Agora, defina os horários disponíveis para cada médico:");
        for (Medico medico : this.medicosDoSistema) {
            while (true) {
                try {
                    System.out.print("\nDigite o dia: ");
                    int dia = sc.nextInt();
                    System.out.print("\nDigite o mês: ");
                    int mes = sc.nextInt();
                    System.out.print("\nDigite o horário (atente ao formato hh:mm): ");
                    String hora = sc.nextLine();
                    Horario h = new Horario(dia, mes, hora);
                    medico.getHorariosDisponiveis().add(h);
                    System.out.println("\n\nHorário adicionado: " + h.print() + " para o médico " + medico.getNome() + ".");
                } catch (Exception e) {
                    throw new RuntimeException("Erro: " + e);
                }
                System.out.println("\nAdicionar mais um horário (S/N)? R: ");
                String c = sc.next();
                if (c.equals("S")) continue;
                else break;
            }
        }
        System.out.println("\n=================================\nFim de configuração do sistema");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Testes testes = new Testes();

        testes.configuracaoDeSistema();

        while(true){
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
                    for(Medico medico : testes.medicosDoSistema){
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
                    for (Medico m:testes.medicosDoSistema) m.mostrarHorariosMarcados();
                }
                case 3 -> {
                    System.out.println("Digite o nome do médico:\n");
                    String nomeMedico = scanner.nextLine();
                    for(Medico medico : testes.medicosDoSistema){
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
                    for(Medico medico : testes.medicosDoSistema){
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
                default -> {break;}
            }
        }
    }
}

