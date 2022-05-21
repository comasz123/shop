public class GUI {

    static void showMainMenu (int user) {
        System.out.println("1. Wyświetl listę produktów");
        System.out.println("2. Kup produkt");
        System.out.println("3. Exit");
        if (user == 2){
            System.out.println("4. Uzupełnij produkt");
        }
    }
    static public void printDataBase (Product[] dataBase){
        for (Product product: dataBase) {
            if(product.quantityAvailable > 0) {
                product.printProduct();
            }
        }
    }

}
