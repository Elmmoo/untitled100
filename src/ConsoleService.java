import java.util.Scanner;

public class ConsoleService {

    private Shop shop;
    private Human human;

    public void setShop(Shop shop2) {
        shop = shop2;
    }
    public Shop getShop() {
        return shop;
    }

    public void setHuman(Human human2) {
        human = human2;
    }
    public Human getHuman(){
        return human;
    }

    public ConsoleService(Shop shop, Human human){
        this.shop = shop;
        this.human = human;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте имя и стартовый капитал магазина");
        String shopName = scanner.nextLine();
        double startingCapital = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Укажите количество товаров");
        int quantity = scanner.nextInt();
        if (quantity > 0) {
            System.out.println("Вы ввели " + quantity + " = количество заполняемых товаров");
        } else {
            System.out.println("Пожалуйста, введите положительное количество товаров.");
        }

        for (int i = 0; i < quantity; i++) {
            System.out.println("Пожалуйста, введите название продукта");
            String productName = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Пожалуйста, введите цену продукта");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Пожалуйста, введите количество товара");
            int stockQuantity = scanner.nextInt();
            Product product = new Product(productName, price);
            shop.checkAndAddProduct(product);
            try {
                shop.sellProduct(product, human);
            } catch (SellProductException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println("Введите Имя, Фамилию, количество денежных средств");
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        double amountOfMoney = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("1. Посмотреть список товаров");
        System.out.println("2. Выход");
        int choice = scanner.nextInt();
        if (choice == 1) {
            shop.printAndGetAllProductsWithCount();
        } else if (choice == 2) {
        } else {
            System.out.println("Неверный выбор, попробуйте снова.");
        }
        int[] numbers = new int[3];
        for(int i=0; i<numbers.length; i++){
            int userInput = scanner.nextInt();
            userInput = userInput-1;
            numbers[i] = userInput;
            human.buyProduct(shop.getProductByIndex(userInput), shop);



        }

    }
}


