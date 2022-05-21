public class DataBase {
    Product[] productDataBase = new Product[5];
    
    public DataBase () {
        this.productDataBase[0] = new Product(1, "Glośnik", 100, 23.60);
        this.productDataBase[1] = new Product(2, "Słuchawki", 50, 150.0);
        this.productDataBase[2] = new Product(3, "Telefon", 150, 380.70);
        this.productDataBase[3] = new Product(4, "kabel USB", 200, 13.50);
        this.productDataBase[4] = new Product(5, "Ładowarka", 70, 54.20);
    }
    public Product findProduct (int inputID){
        boolean found = true;
        int counter = 0;
        Product result = null;

        while (found){

            for (int i = 0; i < this.productDataBase.length; i++) {
                if(this.productDataBase[i].productID==inputID){
                    found = false;
                    result = this.productDataBase[i];
                }
            }
            if(result == null){
                System.out.println("nie ma takiego produktu");
                found = false;
            }
        }
        return result;
    }
    public boolean checkQuantity (Product product, int requestedQuantity){
        boolean result = true;
        if( requestedQuantity <= product.quantityAvailable){
            this.productDataBase[product.productID-1].quantityAvailable =
                    this.productDataBase[product.productID-1].quantityAvailable-requestedQuantity;
        } else {
            System.out.println("nie ma tyle "+product.name + " w magazynie");
            result = false;
        }
        return result;
    }

}
