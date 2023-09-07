package services;

import entities.Medico;
import entities.Paciente;
import resources.Area;

public class Prescricao {

    private final Area area;
    private final Medico medico;
    private final Paciente paciente;
    private final String dicas;

    public Area getArea() {
        return area;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getDicas() {
        return dicas;
    }

    public Prescricao(Medico medico, Paciente paciente, String dicas){
        this.medico = medico;
        this.paciente = paciente;
        this.area = medico.getArea();
        this.dicas = dicas;
    }

    public void listarPrescricoes(){
        switch (this.area) {
            case Geral -> {
                System.out.println("""
                        (1) Paracetamol, para dor
                        (2) Epinefrina (EpiPen), para alergia
                        (3) Solução salína (soro caseiro) e boa alimentação, para desidratação ou dor leve
                        """);
            }
            case Oncologia -> {
                System.out.println("""
                        (1) Quimioterapia
                        (2) Radioterapia
                        (3) Imunoterapia
                        """);
            }
            case Pediatria -> {
                System.out.println("""
                        (1) Xarope
                        (2) Colecalciferol (Vitamina D3)
                        (3) Óxido de Zinco (bebês)
                        """);
            }
            case Ortopedia -> {
                System.out.println("""
                        (1) Anti-inflamatório
                        (2) Aparelho ortopédico para suporte
                        (3) Gel de resfriamento
                        """);
            }
            case Neurologia -> {
                System.out.println("""
                        (1) Anticonvulsivante para controle de epilepsia: Carbamazepina, Lamotrigina
                        (2) Analgésico para enxaqueca: Sumatriptano
                        (3) Fisioterapia neural
                        """);
            }
            case Alergologia -> {
                System.out.println("""
                        (1) 
                        (2) 
                        (3) 
                        """);
            }
            case Ginecologia -> {
                System.out.println("""
                        (1) Contraceptivo oral: Levonorgestrel + Etinilestradiol
                        (2) Ácido Fólico (gestantes)
                        (3) Ciprofloxacino (trato urinário)
                        """);
            }
            case Odontologia -> {
                System.out.println("""
                        (1) Enxaguatório bucal para higiene oral: Clorexidina, Flúor
                        (2) Analgésico para dor
                        (3) Creme e fio dental
                        """);
            }

            //(...)
        }
    }
}