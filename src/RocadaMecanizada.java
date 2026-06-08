public class RocadaMecanizada extends IntervencaoOperacional {

    public RocadaMecanizada(EquipeManutencao equipeResponsavel) {
        super("Roçada Mecanizada", equipeResponsavel);
    }

    @Override
    public void executarServico(TrechoRodovia trecho) {
        System.out.println("Executando roçada mecanizada no trecho KM "
                + trecho.getQuilometroInicial() + " ao KM " + trecho.getQuilometroFinal());

        System.out.println("Motivo: vegetação em nível crítico, exigindo operação com equipamento mecanizado.");

        if (getEquipeResponsavel() != null) {
            trecho.associarEquipe(getEquipeResponsavel());
            System.out.println("Equipe enviada: " + getEquipeResponsavel().getNome());
        }

        trecho.atualizarNivelVegetacao(20);
        System.out.println("Nível da vegetação após o serviço: " + trecho.getNivelVegetacao() + " cm");
    }
}