package decoratorAndMoreMe;

public class Client implements Buyer{
    private String name;

    public Client(String name) {
        this.name = name;
    }


    @Override
    public void receiveNotification(String notification) {
        System.out.println(notification + " " +  this.name);
    }

    @Override
    public void acceptAquisition(Aquisition aquisition) {
        aquisition.addBuyer(this);
    }


}
