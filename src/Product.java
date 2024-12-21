public class Product implements Comparable<Product> {
    private String productName;
    private double price;

    public void setProduct(String productname) {
        productName = productname;
    }
    public String getProduct() {
        return productName;
    }

    public void setPrice(double pricemag) {
        price = pricemag;
    }
    public double getPrice(){
        return price;
    }

    public Product(String productName, double price){
        this.productName = productName;
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        if(price == o.price) {
            return 0;
        }
        if(price < o.price) {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        int result = productName.hashCode();
        result = 31 * result + Double.hashCode(price);
        return result;
    }

    @Override
    public String toString() {
        return "Название: " + productName + ", Цена: " + price;
    }
}




