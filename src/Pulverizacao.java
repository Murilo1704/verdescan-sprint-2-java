public class Pulverizacao extends IntervencaoOperacional {

    public Pulverizacao(EquipeManutencao equipeResponsavel) {
        super("Pulverização", equipeResponsavel);
    }

    @Override
    public void executarServico(TrechoRodovia trecho) {
        System.out.println("Executando pulverização no trecho KM "
                + trecho.getQuilometroInicial() + " ao KM " + trecho.getQuilometroFinal());

        System.out.println("Motivo: controle preventivo do crescimento da vegetação.");

        if (getEquipeResponsavel() != null) {
            trecho.associarEquipe(getEquipeResponsavel());
            System.out.println("Equipe enviada: " + getEquipeResponsavel().getNome());
        }

        trecho.atualizarNivelVegetacao(trecho.getNivelVegetacao() - 10);

        if (trecho.getNivelVegetacao() < 0) {
            trecho.atualizarNivelVegetacao(0);
        }

        System.out.println("Nível da vegetação após o serviço: " + trecho.getNivelVegetacao() + " cm");
    }
}