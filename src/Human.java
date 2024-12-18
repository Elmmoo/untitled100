import java.util.Set;

public class Human implements Buyer {

    private String firstName;
    private String lastName;
    private double money; // денежный счет человека
    private Set<Product> products; // купленные продукты

    public void buyProduct(Product product, Shop shop) {
        // Метод принимает на вход 2 параметра - название покупаемого продукта
        // и магазин, в котором производится покупка

        // Должен использоваться метод sellProduct класса Shop

        // Должны быть обработы исключения,
        // которые могут возникнуть при вызове метода sellProduct

        // В случае успешной покупки - продукт добавляется в Set products
        // и с денежнего счета человека вычитается стоимость продукта

        // В случае неудачной покупки / исключения - в консоль должна выводиться
        // причина, по которой покупка не произошла - сообщение исключения
    }

    // getters
    // setters

}



