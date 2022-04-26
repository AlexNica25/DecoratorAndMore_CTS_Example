package decoratorAndMoreMe;

public class Main {
    public static void main(String[] args) {
        PizzaType p1 = PizzaType.Capriciosa;
        PizzaType p2 = PizzaType.Capriciosa; //only one object can be instantiated
        PizzaType p3 = PizzaType.QuatroStagioni;


        PizzaFactory pizzaFactory1 = PizzaFactory.getPizzaFactory(p1);
        PizzaFactory pizzaFactory2 = PizzaFactory.getPizzaFactory(p2);
        PizzaFactory pizzaFactory3 = PizzaFactory.getPizzaFactory(p3);


        System.out.println(p1 == p2);
        System.out.println(p1 == p3);

        PizzaDetails basicPizza = new TomatoSauce(PizzaFactory.getPizzaFactory(p1));
        System.out.println();

        System.out.println("Details: " + basicPizza.getDescription());
        System.out.println("Price: " + basicPizza.getCost());

        //------------------------------------------------------//

        System.out.println();

        Command command1 = new Command("Command 1", pizzaFactory1, PizzaType.Marguerita);
        Command command2 = new Command("Command 2", pizzaFactory2,  PizzaType.Capriciosa);


        Client c1 = new Client("Alin");
        Client c2 = new Client("Paul");

        c1.acceptAquisition(command1);
        c2.acceptAquisition(command2);

        command1.notifyBuyer();
        command2.notifyBuyer();

    }
}
