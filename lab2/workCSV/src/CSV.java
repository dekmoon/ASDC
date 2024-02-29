import java.io.*;
import java.util.List;

public class CSV {
    // Метод для сериализации данных в CSV формат
    public static void serializeToCSV(List<Employee> data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee employee : data) {
                writer.write(String.format("%s,%d,%s", employee.getName(), employee.getAge(), employee.getCity()));
                writer.newLine();
            }
            System.out.println("Данные успешно сериализованы в файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при записи данных в CSV файл: " + e.getMessage());
        }
    }

    // Метод для десериализации данных из CSV формата
    public static void deserializeFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                int age = Integer.parseInt(values[1]);
                String city = values[2];
                System.out.println("Имя: " + name + ", Возраст: " + age + ", Город: " + city);
            }
            System.out.println("Данные успешно десериализованы из файла: " + filePath);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка при чтении данных из CSV файла: " + e.getMessage());
        }
    }
}
