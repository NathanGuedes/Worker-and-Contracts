package application; // Pacote onde a classe está localizada

import entities.Department; // Importa a classe Department do pacote entities
import entities.HourContract; // Importa a classe HourContract do pacote entities
import entities.Worker; // Importa a classe Worker do pacote entities
import entities.enums.WorkerLevel; // Importa o enum WorkerLevel do pacote entities.enums

import java.text.ParseException; // Importa a classe ParseException do pacote java.text
import java.text.SimpleDateFormat; // Importa a classe SimpleDateFormat do pacote java.text
import java.util.Date; // Importa a classe Date do pacote java.util
import java.util.Locale; // Importa a classe Locale do pacote java.util
import java.util.Scanner; // Importa a classe Scanner do pacote java.util

public class Program {
    public static void main(String[] args) throws ParseException { // Método principal, pode lançar ParseException

        Locale.setDefault(Locale.US); // Define a localidade padrão como EUA (para formatação de números)
        try (Scanner sc = new Scanner(System.in)) { // Try-with-resources para garantir que o Scanner será fechado

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Define o formato de data

            System.out.print("Enter department's name: ");
            String departmentName = sc.nextLine(); // Lê o nome do departamento
            System.out.println("Enter worker data:");
            System.out.print("Name: ");
            String workerName = sc.nextLine(); // Lê o nome do trabalhador
            System.out.print("Level: ");
            String workerLevel = sc.nextLine(); // Lê o nível do trabalhador
            System.out.print("Base salary: ");
            double baseSalary = sc.nextDouble(); // Lê o salário base do trabalhador

            // Cria uma instância de Worker com os dados fornecidos
            Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

            System.out.println();
            System.out.print("How many contracts to this worker? ");
            int n = sc.nextInt(); // Lê o número de contratos
            sc.nextLine(); // Consome a quebra de linha

            System.out.println();

            for (int i = 0; i < n; i++) { // “Loop” para ler os dados de cada contrato
                System.out.printf("Enter contract #%d data%n", i + 1);
                System.out.print("Date (DD/MM/YYYY): ");
                Date contractDate = sdf.parse(sc.next()); // Lê e converte a data do contrato
                System.out.print("Value per hour: ");
                double valuePerHour = sc.nextDouble(); // Lê o valor por hora do contrato
                System.out.print("Duration (hours): ");
                int hours = sc.nextInt(); // Lê a duração do contrato em horas
                sc.nextLine(); // Consome a quebra de linha
                System.out.println();

                // Cria uma instância de HourContract com os dados fornecidos
                HourContract contract = new HourContract(contractDate, valuePerHour, hours);
                worker.addContract(contract); // Adiciona o contrato ao trabalhador
            }

            System.out.print("Enter month and year to calculate income (MM/YYYY): ");
            String monthAndYear = sc.next(); // Lê o mês e ano para calcular a renda
            int month = Integer.parseInt(monthAndYear.substring(0, 2)); // Extrai o mês
            int year = Integer.parseInt(monthAndYear.substring(3)); // Extrai o ano

            // Exibe os dados do trabalhador e a renda calculada para o mês/ano fornecidos
            System.out.println();
            System.out.println("Name: " + worker.getName());
            System.out.println("Department: " + worker.getDepartment().getName());
            System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
        }
    }
}
