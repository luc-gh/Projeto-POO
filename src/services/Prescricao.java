package services;

import entities.Medico;
import resources.Area;

/**
 * A classe Prescricao representa uma prescrição médica no sistema.
 * Ela mantém informações sobre a área de atuação do médico, o médico que emitiu a prescrição,
 * o paciente para o qual a prescrição foi feita e as dicas ou recomendações médicas.
 */
public class Prescricao {

    private Area area;
    private final String dicas;

    /**
     * Obtém a área de atuação do médico que emitiu a prescrição.
     *
     * @return A área de atuação do médico.
     */
    public Area getArea() {
        return area;
    }

    /**
     * Define a área de atuação do médico que emitiu a prescrição.
     *
     * @param area A área de atuação a ser definida.
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * Obtém as dicas ou recomendações médicas da prescrição.
     *
     * @return As dicas ou recomendações médicas.
     */
    public String getDicas() {
        return dicas;
    }

    /**
     * Construtor da classe Prescricao.
     *
     * @param medico O médico que emitiu a prescrição.
     * @param dicas As dicas ou recomendações médicas.
     */
    public Prescricao(Medico medico, String dicas){
        this.setArea(medico.getArea());
        this.dicas = dicas;
    }

    /**
     * Lista as prescrições recomendadas com base na área de atuação do médico.
     * Imprime a lista de prescrições recomendadas com base na especialidade do médico.
     * Se houver dicas adicionais na prescrição, elas também são exibidas.
     */
    public void listarPrescricoesRecomendadas(){
        switch (this.area) {
            case Geral -> System.out.println("""
                    (1) Paracetamol, para dor
                    (2) Epinefrina (EpiPen), para alergia
                    (3) Solução salína (soro caseiro) e boa alimentação, para desidratação ou dor leve
                    """);
            case Oncologia -> System.out.println("""
                    (1) Quimioterapia
                    (2) Radioterapia
                    (3) Imunoterapia
                    """);
            case Pediatria -> System.out.println("""
                    (1) Xarope
                    (2) Colecalciferol (Vitamina D3)
                    (3) Óxido de Zinco (bebês)
                    """);
            case Ortopedia -> System.out.println("""
                    (1) Anti-inflamatório
                    (2) Aparelho ortopédico para suporte
                    (3) Gel de resfriamento
                    """);
            case Neurologia -> System.out.println("""
                    (1) Anticonvulsivante para controle de epilepsia: Carbamazepina, Lamotrigina
                    (2) Analgésico para enxaqueca: Sumatriptano
                    (3) Fisioterapia neural
                    """);
            case Alergologia -> System.out.println("""
                    (1) Corticosteroides Nasais (Fluticasona) - Rinite
                    (2) Antihistamínicos - Rinite
                    (3) Corticosteroides Inalados (Budesonida) - Asma
                    """);
            case Ginecologia -> System.out.println("""
                    (1) Contraceptivo oral: Levonorgestrel + Etinilestradiol
                    (2) Ácido Fólico (gestantes)
                    (3) Ciprofloxacino (trato urinário)
                    """);
            case Odontologia -> System.out.println("""
                    (1) Enxaguatório bucal para higiene oral: Clorexidina, Flúor
                    (2) Analgésico para dor
                    (3) Creme e fio dental
                    """);
            case Cardiologia -> System.out.println("""
                    (1) Anti-hipertensivo para controle da pressão arterial: Losartana, Atenolol
                    (2) Aspirina para prevenção de eventos cardiovasculares: Ácido Acetilsalicílico
                    (3) Estatina para controle do colesterol: Atorvastatina, Rosuvastatina
                    """);
            case Oftalmologia -> System.out.println("""
                    (1) Colírio de Tobramicina ou Ofloxacino (Conjuntivite)
                    (2) Colírios de Prostaglandinas ou Beta-bloqueadores (Glaucoma)
                    (3) Colírio de Anti-inflamatório Não Esteroidal, Esteroidal ou de Antibiótico (Catarata)
                    """);
            case Hematologia -> System.out.println("""
                    (1) Anemia Ferropriva: Suplemento de Ferro, Ácido Fólico, Vitamina B12\s
                    (2) Leucemia Mieloide Aguda: Quimioterapia por Indução (Citarabina, Daunorrubicina) ou Transplante de Medula Óssea
                    (3) Trombose Venosa Profunda: Anticoagulantes (Varfarina, Enoxaparina) ou Trombolíticos
                    """);
            case Psiquiatria -> System.out.println("""
                    (1) Antidepressivo: Sertralina, Escitalopram
                    (2) Ansiolítico: Alprazolam, Diazepam
                    (3) Terapia cognitivo-comportamental: Tratamento não medicamentoso
                    """);
            case Dermatologia -> System.out.println("""
                    (1) Creme hidratante
                    (2) Pomada anti-inflamatória para eczema
                    (3) Protetor solar de amplo espectro (FPS)
                    """);
            case Infectologia -> System.out.println("""
                    (1) Antibióticos bacterianos (Infecção Respiratória Bacteriana)
                    (2) Antibióticos e analgésicos (Infecção do Trato Urinário)
                    (3) Terapia Antirretroviral e Profilaxia para Infecções Oportunistas (HIV/AIDS)
                    """);
            case Reumatologia -> System.out.println("""
                    (1) Metotrexato, Sulfassalazina (artrite)
                    (2) Tramadol, Codeína (dor)
                    (3) Exercícios físicos
                    """);
            case Otorrinolaringologia -> System.out.println("""
                    (1) Gotas de Ciprofloxacino, gotas de Corticosteroides e analgésicos para dor - Otite Externa
                    (2) Antibióticos (Amoxicilina-Ácido Clavulânico), descongestionantes Nasais (Oximetazolina) - Sinusite
                    (3) Antihistamínicos, Corticosteroides Nasais e Descongestionantes Nasais - Rinite alérgica
                    """);
        }
        if (!dicas.isEmpty()) System.out.println("Recomendações: " + getDicas());
    }
}