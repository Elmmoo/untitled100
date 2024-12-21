import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.get;
import static javax.swing.UIManager.put;

public class Shop {

    private String name;
    private double money;
    private Map<Product, Integer> products;


    void checkAndAddProduct(Product product) {
        if (products.containsKey(product)) {
            int currentQuantity = products.get(product);
            int newQuantity = currentQuantity + 1;
            products.put(product, newQuantity);
        }
        else {
            products.put(product, 1);
        }
    }

    public void setName(String Nname) {
        name = Nname;
    }

    public String getName() {
        return name;
    }

    public void setMoney(double Mmoney) {
        money = Mmoney;
    }

    public double getMoney() {
        return money;
    }

    public void setProducts(Map<Product, Integer> prod) {
        products = prod;
    }

    public Map<Product, Integer> getProducts(){
        return products;
    }
    public Product getProductByIndex(int index) {
        List<Product> productList = printAndGetAllProductsWithCount();
        if(index >= 0 && index < productList.size())
            return productList.get(index);
        return null;
    }


    public Shop(String name, double money){
        this.name = name;
        this.money = money;
        this.products = new HashMap<>();
    }


    public void sellProduct(Product product, Human human) throws SellProductException {

        if(products.get(product) == null || products.get(product) == 0)
            throw new SellProductException("Продукта с именем " + product.getProduct() + " нет в наличии");

        if(human.getMoney() < product.getPrice())
            throw new SellProductException("Уважаемый " + human.getFname() + " " + human.getLname() + ", для покупки товара недостаточно средств");

        double tax = product.getPrice() * 0.2;
        products.put(product, products.get(product) - 1);
        money += product.getPrice() + tax;
        System.out.println("Уважаемый " + human.getFname() + ", вы успешно совершили покупку! С уважением, " + getName());
    }


    private double calculateNds(double price) {
        double nds = price * 0.13;
        return nds;

    }


    public List<Product> printAndGetAllProductsWithCount() {
        List<Product> productList = new ArrayList<>();
        int productNumber = 1;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            productList.add(product);
            Integer quantity = entry.getValue();
            if(quantity == 0) System.out.println("Продукт отсутствует");
            System.out.println(productNumber++ + "." +product + " -" +  quantity);
        }
        return productList;


    }

}





