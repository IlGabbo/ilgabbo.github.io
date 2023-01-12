import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class Main {
    static Scanner k = new Scanner(System.in);
    static void print(String arg) {
        System.out.println(arg);
    }
    public static void main(String[] args) {
        ArrayList<Burgers> burgers = new ArrayList<>();
        int choice = 0;
        String status;
        burgers.add(new Burgers(05, "Gran Crispy", 20, 5));
        burgers.add(new Burgers(10, "Hamburger", 20, 1));
        burgers.add(new Burgers(15, "Big Mac", 20, 5));
        burgers.add(new Burgers(20, "Cheeseburger", 20, 4));
        burgers.add(new Burgers(25, "My Selection", 20, 6));

        while (true) {
            do {
                System.out.println("""
                Benvenuto, seleziona un'opzione:
                [1] Mostra i panini
                [2] Ordina
                [3] Esci
                """);
                choice = k.nextInt();
            } while (choice > 3 || choice < 1);

            switch (choice) {
                case 1:
                    print_burgers(burgers);
                    break;
                case 2:
                    status = order(burgers);
                    print(status);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    static String print_burgers(ArrayList<Burgers> burgers) {
        for (Burgers burg: burgers) {
            print("[i] Codice: " + burg.code + ", nome: " + burg.description + ", disponibilità: " + burg.available_quantity + ", prezzo: " + burg.price);
        }
        return null;
    }

    static String order(ArrayList<Burgers> burgers) {
        print_burgers(burgers);
        int choice = 0;
        int quantity;
        String order_status = null;
        boolean valid_answer = true;
        print("[i] Scegli in base al codice");
        choice = k.nextInt();
        for (Burgers burg: burgers) {
            if (choice == burg.code) {
                print("Quantità: ");
                quantity = k.nextInt();
                if ((burg.available_quantity - quantity) > 2) {
                    burg.available_quantity -= quantity;
                    order_status = payment(burg.code, burg.description, burg.price, quantity);
                } else {
                    order_status = "[:(] Ci dispiace, hai ordinato troppo rispetto alle nostre scorte";
                }
                valid_answer = true;
                break;
            } else {
                valid_answer = false;
            }
        }
        if (!valid_answer) {
            order_status = "[!] " + choice + " is not a valid answer";
        }

        return order_status;
    }


    static String payment(int code, String burger_name, float price, int quantity) {
        String status, order;
        Random rand = new Random();
        int num_order = 0;
        float pay = 0;

        num_order = rand.nextInt(100);
        print(burger_name + " €" + price * quantity);
        do {
            print("Inserisci l'importo da pagare");
            pay = k.nextFloat();
            status = print_ticket(burger_name, quantity, price*quantity, pay, num_order);
        } while (pay < price*quantity);

        return status;
    }

    static String print_ticket(String order, float quantity, float price, float money_amount, int order_number) {
        String ticket = String.format("""
                ------------------------------------
                              McDonald
                ------------------------------------
                   
                   Panini: %s
                   Quantità: %s   
                   Prezzo: €%s
                   Pagato: €%s                                        
                   Resto: €%s
                   Numero ord: %s             
                """, new String[]{order, Float.toString(quantity), Float.toString(price), Float.toString(money_amount), Float.toString(money_amount-price), Integer.toString(order_number)});

        return ticket;
    }

}

class Burgers {
    int code, available_quantity;
    float price;
    String description;

    public Burgers(int code, String description, int available_quantity, float price) {
        this.code = code;
        this.description = description;
        this.available_quantity = available_quantity;
        this.price = price;
    }
}
