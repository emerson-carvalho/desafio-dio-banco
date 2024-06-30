import lombok.Data;

@Data
public class Banco {

    private String nome;

    public Banco(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Banco: " + nome;
    }
}