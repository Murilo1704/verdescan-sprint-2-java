public class TrechoRodoviaIoT extends TrechoRodovia implements MonitoravelViaIoT {
    private String codigoSensor;

    public TrechoRodoviaIoT(int quilometroInicial, int quilometroFinal, double nivelVegetacao, String tipoAmbiente, String codigoSensor) {
        super(quilometroInicial, quilometroFinal, nivelVegetacao, tipoAmbiente);
        this.codigoSensor = codigoSensor;
    }

    public String getCodigoSensor() {
        return codigoSensor;
    }

    @Override
    public double transmitirDadosSensor() {
        double leituraSensor = getNivelVegetacao() + 5;

        System.out.println("Sensor " + codigoSensor + " transmitiu dados automaticamente.");
        System.out.println("Leitura capturada pelo sensor: " + leituraSensor + " cm");

        return leituraSensor;
    }
}