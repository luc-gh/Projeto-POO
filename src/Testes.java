import resources.*;
import entities.*;
import services.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A classe Testes é responsável por configurar o sistema e fornecer uma interface de linha de comando para
 * interagir com os médicos e consultas médicas.
 */
public class Testes {

    ArrayList<Medico> medicosDoSistema = new ArrayList<>();

    public void listarMedicosDoSistema(){
        if (this.medicosDoSistema.isEmpty()) System.out.println("Não há médicos no sistema.");
        else {
            System.out.println("-----------------------------\nMédicos do sistema:");
            for(Medico m: medicosDoSistema){
                System.out.println("- " + m.getNome());
            }
        }
    }
    /**
     * Realiza a configuração inicial do sistema, permitindo que o usuário defina informações sobre os médicos e
     * horários disponíveis.
     */
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
            System.out.println("\n" + i + "º médico\n-----------------------------");
            System.out.print("Nome: ");
            String nome = sc.next();
            sc.nextLine();

            System.out.print("Número: ");
            String numero = sc.nextLine();

            System.out.print("Data de nascimento: ");
            String data = sc.nextLine();

            System.out.print("Área: ");
            int escolha = sc.nextInt();

            Area area;
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
            this.listarMedicosDoSistema();
        }

        System.out.println("Agora, defina os horários disponíveis para cada médico:\n---------------------------");
        for (Medico medico : this.medicosDoSistema) {
            while (true) {
                try {
                    System.out.println("Médico: " + medico.getNome());
                    System.out.print("Digite o dia: ");
                    int dia = sc.nextInt();
                    System.out.print("Digite o mês: ");
                    int mes = sc.nextInt();
                    System.out.print("Digite a hora: ");
                    int hora = sc.nextInt();
                    System.out.print("E os minutos: ");
                    int min = sc.nextInt();
                    Horario h = new Horario(dia, mes, hora, min);
                    medico.getHorariosDisponiveis().add(h);
                    System.out.println("\nHorário adicionado: " + h.print() + " para o médico " + medico.getNome() + ".");
                } catch (Exception e) {
                    throw new RuntimeException("Erro: " + e);
                }
                System.out.print("\nAdicionar mais um horário (S/N)? R: ");
                String c = sc.next();
                if (c.equals("S")) continue;
                else break;
            }
        }
        System.out.println("\n=================================\nFim de configuração do sistema");
    }

    /**
     * Método principal que inicia a interface de linha de comando para interagir com o sistema.
     *
     * @param args Os argumentos de linha de comando (não utilizados neste caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Testes testes = new Testes();

        testes.configuracaoDeSistema();
        boolean isRunning = true;

        while(isRunning){
            System.out.println("Bem-vindo ao Agendamento de Consultas");
            System.out.println("=====================================\nOPÇÕES");
            System.out.println("""
                    1 - Marcar Consulta
                    2 - Cancelar Consulta
                    3 - Verificar Horários Disponíveis
                    4 - Verificar Consultas Marcadas
                    5 - Sair do sistema
            """);
            System.out.print("Selecione uma opção:");
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o nome do Cliente: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o número de telefone do Cliente: ");
                    String telefone = scanner.nextLine();
                    System.out.println("Digite a data de nascimento do Cliente: ");
                    String dataNascimento = scanner.nextLine();
                    Pessoa paciente = new Pessoa(nome, telefone, dataNascimento);

                    System.out.println("Áreas: \n" + Arrays.toString(Area.values()));
                    System.out.println("Escreva a área do atendimento:");
                    String area = scanner.nextLine();
                    for(Medico medico : testes.medicosDoSistema){
                        if (medico.getArea() == Area.valueOf(area)){
                            System.out.println("Digite o dia da consulta: ");
                            short dia = Short.parseShort(scanner.nextLine());
                            System.out.println("Digite o mês da consulta: ");
                            short mes = Short.parseShort(scanner.nextLine());
                            System.out.println("Digite a hora da consulta: ");
                            int hora = Integer.parseInt(scanner.nextLine());
                            System.out.println("E os minutos: ");
                            int min = Integer.parseInt(scanner.nextLine());
                            Horario horario = new Horario(dia, mes, hora, min);
                            if (!medico.getHorariosDisponiveis().contains(horario)) {
                                System.out.println("Qual a urgência da consulta: ");
                                String urgencia = scanner.nextLine();
                                medico.marcarConsulta(paciente, horario, Urgencia.valueOf(urgencia));
                            } else {
                                System.out.println("Horário indisponível.");
                            }
                        } else {
                            System.out.println("Não temos médicos desta área");
                        }
                    }

                }
                case 2 -> {
                    for (Medico m:testes.medicosDoSistema) {
                        m.mostrarHorariosMarcados();
                        if (m.getHorariosMarcados().isEmpty()) {
                            System.out.println("Este médico não tem horários marcados, logo, não há consulta a ser cancelada.");
                            continue;
                        }
                        System.out.println("Digite o dia do horário a cancelar: ");
                        int dia = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite o mês do horário a cancelar: ");
                        int mes = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite a hora do horário que será cancelado: ");
                        int hora = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite os minutos: ");
                        int min = Integer.parseInt(scanner.nextLine());
                        for (Horario horario:m.getHorariosMarcados()){
                            if (horario.getHora() == hora && horario.getMinuto() == min && horario.getDia() == dia && horario.getMes() == mes) {
                                m.cancelarConsulta(horario);
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Digite o nome do médico:\n");
                    String nomeMedico = scanner.nextLine();
                    for(Medico medico : testes.medicosDoSistema){
                        if (medico.getNome().equals(nomeMedico)){
                            medico.mostrarHorariosDisponiveis();
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
                            if(!medico.getConsultasMarcadas().isEmpty()){
                                for(Consulta consulta : medico.getConsultasMarcadas()){
                                    System.out.println(consulta.getHorario().print());
                                    System.out.println("==============");
                                }
                            } else {
                                System.out.println("Este médico não tem consultas marcadas");
                            }
                        } else {
                            System.out.println("Médico não existe no sistema.");
                        }
                    }
                }
                case 5 -> {
                    isRunning = false;
                }
                default -> throw new RuntimeException("Essa opção é inválida. Erro no sistema.");
            }
        }
        for(Medico m:testes.medicosDoSistema){
            for(Consulta c:m.getConsultasMarcadas()){
                System.out.print("\nConsulta do médico " + m.getNome() +
                        ", de " + c.getHorario().print() + " em andamento. \nDigite as orientações: ");
                String orientacoes = scanner.nextLine();
                c.realizarConsulta(orientacoes);
            }
        }
        System.out.println("\n-------------------------\nSistema encerrado.");
    }
}

