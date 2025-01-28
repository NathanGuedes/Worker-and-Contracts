package entities; // Pacote onde a classe está localizada

import entities.enums.WorkerLevel; // Importa o enum WorkerLevel do pacote entities.enums
import java.util.ArrayList; // Importa a classe ArrayList do pacote java.util
import java.util.Calendar; // Importa a classe Calendar do pacote java.util
import java.util.List; // Importa a interface List do pacote java.util

public class Worker {

    // Atributos privados do trabalhador
    private String name; // Nome do trabalhador
    private WorkerLevel level; // Nível do trabalhador
    private Double baseSalary; // Salário base do trabalhador

    // Relacionamentos com outras classes
    private Department department; // Departamento ao qual o trabalhador pertence
    private final List<HourContract> contracts = new ArrayList<>(); // Lista de contratos de horas do trabalhador

    // Construtor padrão
    public Worker() {
    }

    // Construtor que inicializa todos os atributos
    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name; // Inicializa o nome do trabalhador
        this.level = level; // Inicializa o nível do trabalhador
        this.baseSalary = baseSalary; // Inicializa o salário base do trabalhador
        this.department = department; // Inicializa o departamento do trabalhador
    }

    // Métodos getters e ‘setters’ para acessar e modificar os atributos
    public String getName() {
        return name; // Retorna o nome do trabalhador
    }

    public void setName(String name) {
        this.name = name; // Define o nome do trabalhador
    }

    public WorkerLevel getLevel() {
        return level; // Retorna o nível do trabalhador
    }

    public void setLevel(WorkerLevel level) {
        this.level = level; // Define o nível do trabalhador
    }

    public Double getBaseSalary() {
        return baseSalary; // Retorna o salário base do trabalhador
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary; // Define o salário base do trabalhador
    }

    public Department getDepartment() {
        return department; // Retorna o departamento do trabalhador
    }

    public void setDepartment(Department department) {
        this.department = department; // Define o departamento do trabalhador
    }

    public List<HourContract> getContracts() {
        return contracts; // Retorna a lista de contratos de horas do trabalhador
    }

    public void addContract(HourContract contract) {
        contracts.add(contract); // Adiciona um contrato à lista de contratos do trabalhador
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract); // Remove um contrato da lista de contratos do trabalhador
    }

    // Calcula a renda do trabalhador para um determinado mês e ano
    public double income(int year, int month) {
        double sum = baseSalary; // Inicializa a soma com o salário base
        Calendar cal = Calendar.getInstance(); // Obtém uma instância de Calendar
        for (HourContract c : contracts) { // Itera sobre os contratos do trabalhador
            cal.setTime(c.getDate()); // Define a data do calendário para a data do contrato
            int c_year = cal.get(Calendar.YEAR); // Obtém o ano do contrato
            int c_month = 1 + cal.get(Calendar.MONTH); // Obtém o mês do contrato (0-11; por isso, é somado 1)
            if (year == c_year && month == c_month) { // Verifica se o contrato é do ano e mês especificados
                sum += c.totalValue(); // Adiciona o valor total do contrato à soma
            }
        }

        return sum; // Retorna a renda total do trabalhador para o mês e ano especificados
    }
}
