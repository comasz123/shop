public class Product {
    int productID;
    String name;
    int quantityAvailable;
    double price;

    public Product(int productID, String name, int quantityAvailable, double price) {
        this.productID = productID;
        this.name = name;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
    }
    public void printProduct(){
        System.out.println("ID: " + this.productID + ", "+ this.name + ", dostępne sztuk: "
                + this.quantityAvailable + " cena: " +this.price);
    }
}
