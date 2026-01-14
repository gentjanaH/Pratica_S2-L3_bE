import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //PRODOTTI
        Product primoProdotto = new Product("Ciuccio", "Baby", 5.9);
        System.out.println(primoProdotto);

        List<Product> prodotti = new ArrayList<>();
        prodotti.add(primoProdotto);
        prodotti.add(new Product("Sciarpa", "Abbigliamento", 35.9));
        prodotti.add(new Product("Biberon", "Baby", 10.5));
        prodotti.add(new Product("L'ultimo segreto", "Books", 32.9));
        prodotti.add(new Product("Pannolini", "Baby", 60.5));
        prodotti.add(new Product("Berretto", "Boys", 15.9));
        prodotti.add(new Product("Pomata", "Baby", 10.5));
        prodotti.add(new Product("Macchina telecomandata", "Boys", 35.9));
        prodotti.add(new Product("Donne che pensano troppo", "Books", 20.5));
        prodotti.add(new Product("Harry Potter", "Books", 17.9));
        prodotti.add(new Product("Passeggino", "Baby", 80.5));
        prodotti.add(new Product("Collana", "Accessori", 55.9));
        prodotti.add(new Product("Biberon Rosa", "Baby", 13.5));
        prodotti.add(new Product("Il piccolo principe", "Books", 12.9));
        prodotti.add(new Product("Fionda", "Boys", 6.5));
        prodotti.add(new Product("Gormiti", "Boys", 10.9));
        prodotti.add(new Product("Termometro", "Baby", 10.5));
        prodotti.add(new Product("Drone", "Boys", 305.9));
        prodotti.add(new Product("Il signore degli Anelli:tutta la saga", "Books", 200.5));
        prodotti.add(new Product("Orgoglio e pregiudizio", "Books", 107.9));
        prodotti.add(new Product("Copertina", "Baby", 20.5));
        prodotti.add(new Product("La divina Commedia", "Books", 100.5));
        prodotti.add(new Product("Il silenzio dei colpevoli", "Books", 110.5));

        //CLIENTI
        Customer primoCliente = new Customer("Mario", 2);
        System.out.println(primoCliente);
        List<Customer> clienti = new ArrayList<>();
        clienti.add(primoCliente);
        clienti.add(new Customer("Sara", 1));
        clienti.add(new Customer("Lucia", 2));
        clienti.add(new Customer("Mikol", 2));
        clienti.add(new Customer("Alfredo", 1));
        clienti.add(new Customer("Giangiorno", 2));
        clienti.add(new Customer("Pupo", 1));
        clienti.add(new Customer("Samira", 3));
        clienti.add(new Customer("Francesco", 3));
        clienti.add(new Customer("Marco", 1));
        clienti.add(new Customer("Sabrina", 2));
        System.out.println(clienti);

        //ORDINI
        //lista di ordini
        List<Product> carrello1 = List.of(
                prodotti.get(4),
                prodotti.get(7),
                prodotti.get(2)
        );
        List<Product> carrello2 = List.of(
                prodotti.get(4),
                prodotti.get(7),
                prodotti.get(3)
        );

        List<Product> carrelloBaby = List.of(
                prodotti.get(2),
                prodotti.get(4),
                prodotti.get(6)
        );

        Order primoOrdine = new Order(
                "Spedito",
                LocalDate.now(),
                LocalDate.now().plusDays(3),
                carrello1,
                primoCliente);

        Order secondoOrdine = new Order(
                "In lavorazione",
                LocalDate.now(),
                LocalDate.now().plusDays(10),
                carrelloBaby,
                clienti.get(2));

        Order terzoOrdine = new Order(
                "In ritardo",
                LocalDate.now(),
                LocalDate.now().plusDays(15),
                carrello2,
                clienti.get(6));

        System.out.println("PRIMO ORDINE:  " + primoOrdine);
        System.out.println("SECONDO ORDINE:  " + secondoOrdine);

        List<Order> ordini = new ArrayList<>();
        ordini.add(primoOrdine);
        ordini.add(secondoOrdine);
        ordini.add(terzoOrdine);

        //1-Ottenere una lista di prodotti che appartengono alla categoria "Books" ed hanno un prezzo > 100
        List<Product> booksOver100 = prodotti.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books") && p.getPrice() > 100)
                .toList();

        System.out.println("Lista di libri con prezzo superiore a 100: ");
        System.out.println(booksOver100);

//        2-Ottenere una lista di ordini con prodotti che appartengono alla categoria "Baby"
        List<Order> ordiniCategoriaBaby = ordini.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby")))
                .toList();

        System.out.println("ORDINI CATEGORIA BABY: " + ordiniCategoriaBaby);

        //3-Ottenere una lista di prodotti che appartengono alla gategoria "Boys" ed applicare il 10% di sconto
        List<Product> productsForBoys = prodotti.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Boys"))
                .map(p -> new Product(
                        p.getName(),
                        p.getCategory(),
                        p.getPrice() * 0.9

                ))
                .toList();
        System.out.println("Prodotti per bambini scontati del 10%: ");
        System.out.println(productsForBoys);

        //4-
    }

}

