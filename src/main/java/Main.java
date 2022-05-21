import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataBase dataBase = new DataBase();
        int user = 0;
        boolean logUser = true;

        while(logUser){
            System.out.println("podaj login i haslo:");
            String login = br.readLine();
            String password = br.readLine();
            if(login.equals("user")&&password.equals("user")){
                user = 1;
                logUser = false;
            } else if(login.equals("admin")&&password.equals("admin")){
                user = 2;
                logUser = false;
            }
        }
        while (true) {
            GUI.showMainMenu(user);
            String choice = br.readLine();

            switch (choice) {
                case "1":
                    GUI.printDataBase(dataBase.productDataBase);
                    break;
                case "2":
                    System.out.println("podaj ID produktu");
                    int inputID = Integer.parseInt(br.readLine());
                    Product product = dataBase.findProduct(inputID);
                    if (!(product==null)){
                        System.out.println("podaj ilość:");
                        int quantity = Integer.parseInt(br.readLine());
                        if(dataBase.checkQuantity(product, quantity)){
                            System.out.println("sprzedano: " + quantity + "  " + product.name + " za "+
                                    quantity* product.price+" PLN");
                            break;
                        }
                    }
                    break;
                case "3":
                    System.exit(0);
                    break;
                case "4":
                    if(user==2){
                        System.out.println("Zwiększamy ilość produktu na stanie");
                        System.out.println("Podaj ID produktu:");
                        int productID1 = Integer.parseInt(br.readLine());
                        Product product1 = dataBase.findProduct(productID1);
                        if (!(product1 == null)){
                            System.out.println("podaj ilość");
                            int numberToIncrease = Integer.parseInt(br.readLine());
                            product1.quantityAvailable=product1.quantityAvailable+numberToIncrease;
                            dataBase.productDataBase[product1.productID-1]=product1;
                        }

                    }
                    break;
                default:
                    break;
            }
        }
    }
}
