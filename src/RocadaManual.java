public class RocadaManual extends IntervencaoOperacional {

    public RocadaManual(EquipeManutencao equipeResponsavel) {
        super("Roçada Manual", equipeResponsavel);
    }

    @Override
    public void executarServico(TrechoRodovia trecho) {
        System.out.println("Executando roçada manual no trecho KM "
                + trecho.getQuilometroInicial() + " ao KM " + trecho.getQuilometroFinal());

        System.out.println("Motivo: vegetação moderada ou área que exige intervenção localizada.");

        if (getEquipeResponsavel() != null) {
            trecho.associarEquipe(getEquipeResponsavel());
            System.out.println("Equipe enviada: " + getEquipeResponsavel().getNome());
        }

        trecho.atualizarNivelVegetacao(25);
        System.out.println("Nível da vegetação após o serviço: " + trecho.getNivelVegetacao() + " cm");
    }
}