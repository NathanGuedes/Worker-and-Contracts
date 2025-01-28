package entities; // Pacote onde a classe está localizada

import java.util.Date; // Importa a classe Date do pacote java.util

public class HourContract {

    private Date date; // Data do contrato
    private Double valuePerHour; // Valor por hora do contrato
    private Integer hours; // Duração do contrato em horas

    public HourContract() {
    }

    public HourContract(Date date, Double valuePerHour, Integer hours) {
        this.date = date; // Inicializa a data do contrato
        this.valuePerHour = valuePerHour; // Inicializa o valor por hora do contrato
        this.hours = hours; // Inicializa a duração do contrato em horas
    }

    public Date getDate() {
        return date; // Retorna a data do contrato
    }

    public void setDate(Date date) {
        this.date = date; // Define a data do contrato
    }

    public Double getValuePerHour() {
        return valuePerHour; // Retorna o valor por hora do contrato
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour; // Define o valor por hora do contrato
    }

    public Integer getHours() {
        return hours; // Retorna a duração do contrato em horas
    }

    public void setHours(Integer hours) {
        this.hours = hours; // Define a duração do contrato em horas
    }

    public double totalValue() {
        return valuePerHour * hours; // Calcula o valor total do contrato
    }
}
