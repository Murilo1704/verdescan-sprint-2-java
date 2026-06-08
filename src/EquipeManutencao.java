public class EquipeManutencao {
    private String nome;
    private String regiaoAtendimento;
    private String tipoEquipe;

    public EquipeManutencao(String nome, String regiaoAtendimento, String tipoEquipe) {
        this.nome = nome;
        this.regiaoAtendimento = regiaoAtendimento;
        this.tipoEquipe = tipoEquipe;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiaoAtendimento() {
        return regiaoAtendimento;
    }

    public String getTipoEquipe() {
        return tipoEquipe;
    }

    public void exibirDados() {
        System.out.println("Equipe: " + nome);
        System.out.println("Região de atendimento: " + regiaoAtendimento);
        System.out.println("Tipo de equipe: " + tipoEquipe);
    }
}