package decoratorAndMoreMe;



enum PizzaType{Marguerita, ProsciuttoFunghi, Capriciosa, QuatroStagioni}

/*abstract class*/interface PizzaDetails {
     double getCost();
     String getDescription();
}

public class PizzaFactory implements PizzaDetails{

    private static PizzaFactory pizzaFactory;
    private PizzaType p;


    private PizzaFactory (PizzaType p) {  //1. The constructor --> private
        System.out.println("This pizza is a " + p);
    }


    public static PizzaFactory getPizzaFactory(PizzaType p) {   //2. A static method that returns type object of SingletonClass
        if(pizzaFactory == null) {
            pizzaFactory = new PizzaFactory(p); //it creates only one instance
        }
        return pizzaFactory;
    }

    public PizzaType getType() {
        return p;
    }


    //DECORATOR
    @Override
    public double getCost() {
        return 10.2;
    }

    @Override
    public String getDescription() {
        return "This pizza can be: Marguerita, ProsciuttoFunghi, Capriciosa or QuatroStagioni";
    }


}


//DECORATOR
abstract class ToppingDecorator implements PizzaDetails {

    protected PizzaDetails tempPizza;

    public ToppingDecorator(PizzaDetails newPizza) {
        tempPizza = newPizza;
    }

    public String getDescription() {
        return tempPizza.getDescription();
    }

    public double getCost() {
        return tempPizza.getCost();
    }
}

//DECORATOR EXAMPLE
class TomatoSauce extends ToppingDecorator {

    public TomatoSauce(PizzaDetails newPizza) {
        super(newPizza);

        System.out.println("Adding ketchup ");
    }


    public String getDescription() {
        return tempPizza.getDescription() + ", and ketchup";
    }

    public double getCost() {
        System.out.println("Cost of Sauce: " + .75);
        return tempPizza.getCost() + .35;
    }
}

