public class MotorDeRegras {
    private IntervencaoOperacional rocadaMecanizada;
    private IntervencaoOperacional rocadaManual;
    private IntervencaoOperacional pulverizacao;

    public MotorDeRegras(IntervencaoOperacional rocadaMecanizada,
                         IntervencaoOperacional rocadaManual,
                         IntervencaoOperacional pulverizacao) {
        this.rocadaMecanizada = rocadaMecanizada;
        this.rocadaManual = rocadaManual;
        this.pulverizacao = pulverizacao;
    }

    public void gerarRelatorioPrioridade(TrechoRodovia[] trechos) {
        System.out.println("=================================================");
        System.out.println("RELATÓRIO DE PRIORIDADE - VERDESCAN MOTIVA");
        System.out.println("=================================================");

        for (TrechoRodovia trecho : trechos) {
            System.out.println();
            System.out.println("---------------------------------------------");

            if (trecho instanceof MonitoravelViaIoT) {
                System.out.println("Trecho com tecnologia IoT detectado.");
                MonitoravelViaIoT trechoMonitoravel = (MonitoravelViaIoT) trecho;
                double leituraSensor = trechoMonitoravel.transmitirDadosSensor();
                trecho.atualizarNivelVegetacao(leituraSensor);
            } else {
                System.out.println("Trecho sem IoT. Crescimento estimado por regra de ambiente.");
                trecho.registrarCrescimento();
            }

            trecho.exibirDados();

            IntervencaoOperacional intervencaoIndicada = escolherIntervencao(trecho);

            System.out.println("Intervenção indicada: " + intervencaoIndicada.getNomeIntervencao());
            intervencaoIndicada.executarServico(trecho);
        }

        System.out.println();
        System.out.println("=================================================");
        System.out.println("FIM DO RELATÓRIO");
        System.out.println("=================================================");
    }

    private IntervencaoOperacional escolherIntervencao(TrechoRodovia trecho) {
        if (trecho.getNivelVegetacao() >= 80) {
            return rocadaMecanizada;
        } else if (trecho.getNivelVegetacao() >= 50) {
            return rocadaManual;
        } else {
            return pulverizacao;
        }
    }
}