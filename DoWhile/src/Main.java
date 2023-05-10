
class DoWhile {
    public void deliveryCharge() {
        int price = 10;
        do {
            int total_amount = price + 30;  //price+deliverycharge
            System.out.println("Total amount to be paid is ::" + total_amount);
            price++;
        } while (price < 15);
    }
}

class While{
    public void details(){
        int totalQuantity=1;
        while(totalQuantity<7)
        {
            System.out.println("Total Quantity of product is::"+totalQuantity);
            totalQuantity++;

        }
    }
}



class SwitchDemo{
    public void gameDetails(){
        String game = "Chess";
        switch(game){
            case "Carrom":
                System.out.println("Carrom increases your memory power");
                break;
            case "Chess":
                System.out.println("Game of chess increases your quick response giving ability");
                break;
            case "Football":
                System.out.println("Football helps to increase the muscle power");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("***************** WHILE ******************");
        DoWhile dowhile =new DoWhile();
        dowhile.deliveryCharge();

        System.out.println("************* DO WHILE ******************");
        While egwhile = new While();
        egwhile.details();

        System.out.println("************* SWITCH ******************");
        SwitchDemo sdemo = new SwitchDemo();
        sdemo.gameDetails();
    }
}