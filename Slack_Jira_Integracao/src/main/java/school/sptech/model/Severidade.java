package school.sptech.model;

public enum Severidade {
    BAIXO("baixo"),
    MEDIO("médio"),
    CRITIC0("crítico");


    private final String nome;

    Severidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
