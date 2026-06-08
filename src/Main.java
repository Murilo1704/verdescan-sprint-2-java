public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema VerdeScan Motiva - Sprint 2");
        System.out.println();

        EquipeManutencao equipeMecanizada = new EquipeManutencao(
                "Equipe Alfa",
                "Rodovia SP-101",
                "Roçada mecanizada"
        );

        EquipeManutencao equipeManual = new EquipeManutencao(
                "Equipe Beta",
                "Rodovia SP-101",
                "Roçada manual"
        );

        EquipeManutencao equipePulverizacao = new EquipeManutencao(
                "Equipe Gama",
                "Rodovia SP-101",
                "Pulverização preventiva"
        );

        TrechoRodovia[] trechos = new TrechoRodovia[4];

        trechos[0] = new TrechoRodovia(10, 12, 65, "umido");
        trechos[1] = new TrechoRodovia(20, 22, 45, "seco");
        trechos[2] = new TrechoRodoviaIoT(30, 32, 75, "umido", "SENSOR-IOT-001");
        trechos[3] = new TrechoRodoviaIoT(40, 42, 35, "seco", "SENSOR-IOT-002");

        IntervencaoOperacional rocadaMecanizada = new RocadaMecanizada(equipeMecanizada);
        IntervencaoOperacional rocadaManual = new RocadaManual(equipeManual);
        IntervencaoOperacional pulverizacao = new Pulverizacao(equipePulverizacao);

        MotorDeRegras motorDeRegras = new MotorDeRegras(
                rocadaMecanizada,
                rocadaManual,
                pulverizacao
        );

        motorDeRegras.gerarRelatorioPrioridade(trechos);

        executarTestesConceituais();
    }

    public static void executarTestesConceituais() {
        System.out.println();
        System.out.println("=================================================");
        System.out.println("TESTES CONCEITUAIS DA SPRINT 2");
        System.out.println("=================================================");

        System.out.println("Teste 1 - Classe abstrata:");
        System.out.println("A classe IntervencaoOperacional não pode ser instanciada diretamente.");
        System.out.println("Exemplo inválido: new IntervencaoOperacional(...)");
        System.out.println("Motivo: ela possui o método abstrato executarServico().");

        System.out.println();

        System.out.println("Teste 2 - Interface MonitoravelViaIoT:");
        MockSensorIoT mockSensor = new MockSensorIoT();
        double leituraMock = mockSensor.transmitirDadosSensor();
        System.out.println("Leitura capturada do mock: " + leituraMock + " cm");

        System.out.println("=================================================");
    }
}

class MockSensorIoT implements MonitoravelViaIoT {
    @Override
    public double transmitirDadosSensor() {
        System.out.println("MockSensorIoT transmitindo dados simulados.");
        return 72.5;
    }
}