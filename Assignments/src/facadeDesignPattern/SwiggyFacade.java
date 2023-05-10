package facadeDesignPattern;
//Facade is a structural design pattern.

public class SwiggyFacade {
    private Restaurant restaurant;
    private DeliveryBoy deliveryBoy;
    private DeliveryTeam deliveryTeam;

    public void placeOrder(){
        restaurant.prepareOrder();
        deliveryTeam.assignDeliveryBoy();
        deliveryBoy.pickUpOrder();
        deliveryBoy.deliverOrder();
    }
}





//whenever working with third party function
//we have a library it has many functions and all
//but from that you only want few functions
//so instead of using that library you create a class
//helper class which will help you to use the function of that library

//The Facade design pattern is a structural design pattern that provides a simplified interface
// to a complex system of classes, libraries, or APIs. It is also known as the "Service Facade" pattern.

//The idea behind the Facade pattern is to create a single class that provides a simple,
// easy-to-use interface to a complex subsystem. The Facade acts as a "facade" or
// "front door" to the subsystem, shielding clients from its complexity.

