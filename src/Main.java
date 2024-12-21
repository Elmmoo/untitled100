import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// Создаем магазин
        Shop shop = new Shop("Магазин", 1000.0);

        // Создаем человека с начальными данными
        Set<Product> products = new HashSet<>(); // Инициализируем набор купленных продуктов
        Human human = new Human("Иван", "Иванов", 500.0, products);

        // Создаем сервис для работы с консолью
        ConsoleService consoleService = new ConsoleService(shop, human);

        // Запускаем программу
        consoleService.start();
        }
    }
