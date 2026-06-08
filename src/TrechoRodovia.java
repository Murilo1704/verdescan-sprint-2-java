public class TrechoRodovia {
    private int quilometroInicial;
    private int quilometroFinal;
    private double nivelVegetacao;
    private String tipoAmbiente;
    private EquipeManutencao equipeResponsavel;

    public TrechoRodovia(int quilometroInicial, int quilometroFinal, double nivelVegetacao, String tipoAmbiente) {
        this.quilometroInicial = quilometroInicial;
        this.quilometroFinal = quilometroFinal;
        this.nivelVegetacao = nivelVegetacao;
        this.tipoAmbiente = tipoAmbiente;
    }

    public int getQuilometroInicial() {
        return quilometroInicial;
    }

    public int getQuilometroFinal() {
        return quilometroFinal;
    }

    public double getNivelVegetacao() {
        return nivelVegetacao;
    }

    public String getTipoAmbiente() {
        return tipoAmbiente;
    }

    public EquipeManutencao getEquipeResponsavel() {
        return equipeResponsavel;
    }

    public void associarEquipe(EquipeManutencao equipeResponsavel) {
        this.equipeResponsavel = equipeResponsavel;
    }

    public void registrarCrescimento() {
        if (tipoAmbiente.equalsIgnoreCase("umido")) {
            nivelVegetacao += 18;
        } else if (tipoAmbiente.equalsIgnoreCase("seco")) {
            nivelVegetacao += 7;
        } else {
            nivelVegetacao += 12;
        }
    }

    public void atualizarNivelVegetacao(double novoNivelVegetacao) {
        if (novoNivelVegetacao < 0) {
            nivelVegetacao = 0;
        } else {
            nivelVegetacao = novoNivelVegetacao;
        }
    }

    public boolean estaCritico() {
        return nivelVegetacao >= 80;
    }

    public String classificarPrioridade() {
        if (nivelVegetacao >= 80) {
            return "ALTA";
        } else if (nivelVegetacao >= 50) {
            return "MÉDIA";
        } else {
            return "BAIXA";
        }
    }

    public void exibirDados() {
        System.out.println("Trecho KM " + quilometroInicial + " ao KM " + quilometroFinal);
        System.out.println("Ambiente: " + tipoAmbiente);
        System.out.println("Nível da vegetação: " + nivelVegetacao + " cm");
        System.out.println("Prioridade: " + classificarPrioridade());

        if (equipeResponsavel != null) {
            System.out.println("Equipe responsável: " + equipeResponsavel.getNome());
        } else {
            System.out.println("Equipe responsável: não definida");
        }
    }
}