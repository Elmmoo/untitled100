import java.util.Set;

public class Human implements Buyer {

    private String firstName;
    private String lastName;
    private double money; // денежный счет человека
    private Set<Product> products; // купленные продукты

    public void setFname(String Fname){
        firstName = Fname;
    }
    public String getFname(){
        return firstName;
    }

    public void setLname(String Lname){
        lastName = Lname;
    }
    public String getLname(){
        return lastName;
    }

    public void setMoney(double Money){
        money = Money;
    }
    public double getMoney(){
        return money;
    }

    public void setProductsHuman(Set<Product> ProductsHuman){
        products = ProductsHuman;
    }
    public Set<Product> getProductsHuman(){
        return products;
    }

    public Human(String firstName, String lastName, double money, Set<Product> products){
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
        this.products = products;
    }

    public void buyProduct(Product product, Shop shop) {
        try {
            shop.sellProduct(product, this);
            products.add(product);
            money -= product.getPrice();
        } catch (SellProductException e) {
            System.out.println(e.getMessage());
        }
    }
}









