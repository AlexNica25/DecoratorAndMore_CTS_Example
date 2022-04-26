package decoratorAndMoreMe;

import java.util.ArrayList;
import java.util.List;

public class Command implements Aquisition {
    private String name;
    PizzaFactory p;
    PizzaType t;
    List<Buyer> clients = new ArrayList<>();

    public Command(String name, PizzaFactory p, PizzaType t) {
        this.name = name;
        this.p = PizzaFactory.getPizzaFactory(t);
    }

    @Override
    public void addBuyer(Buyer b) {
        clients.add(b);
    }

    @Override
    public void notifyBuyer() {
        for(Buyer b : clients) {
            b.receiveNotification("Your pizza costs " + p.getCost() + " and is ready to be eaten, ");

        }

    }
}
