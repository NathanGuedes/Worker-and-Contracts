package entities; // Pacote onde a classe está localizada

public class Department {

    private String name; // Nome do departamento

    public Department() {
    }

    public Department(String name) {
        this.name = name; // Inicializa o nome do departamento
    }

    public String getName() {
        return name; // Retorna o nome do departamento
    }

    public void setName(String name) {
        this.name = name; // Define o nome do departamento
    }
}
