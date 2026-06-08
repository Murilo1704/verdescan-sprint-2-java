public abstract class IntervencaoOperacional {
    private String nomeIntervencao;
    private EquipeManutencao equipeResponsavel;

    public IntervencaoOperacional(String nomeIntervencao, EquipeManutencao equipeResponsavel) {
        this.nomeIntervencao = nomeIntervencao;
        this.equipeResponsavel = equipeResponsavel;
    }

    public String getNomeIntervencao() {
        return nomeIntervencao;
    }

    public EquipeManutencao getEquipeResponsavel() {
        return equipeResponsavel;
    }

    public void exibirResumoIntervencao() {
        System.out.println("Intervenção: " + nomeIntervencao);

        if (equipeResponsavel != null) {
            System.out.println("Equipe responsável: " + equipeResponsavel.getNome());
        } else {
            System.out.println("Equipe responsável: não definida");
        }
    }

    public abstract void executarServico(TrechoRodovia trecho);
}