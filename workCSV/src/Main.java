import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание списка сотрудников
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Иван", 25, "Москва"));
        employees.add(new Employee("Мария", 30, "Санкт-Петербург"));

        // Сериализация в CSV
        CSV.serializeToCSV(employees, "employees.csv");

        // Десериализация из CSV
        CSV.deserializeFromCSV("employees.csv");
    }
}
