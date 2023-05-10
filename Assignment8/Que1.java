package Assignment8;


class Employee{

    int hrs;
    int rate;



    public void computeSalary(){
        int salary = hrs*rate ;
        System.out.println(salary);
    }
}

class WageEmployee extends Employee{
      WageEmployee(int hrs,int rate){

        super.hrs=hrs;
        super.rate=rate;
        super.computeSalary();

    }

}
class SalesPerson extends WageEmployee{
    int sales;
    int commision;
    SalesPerson(int slaes,int commision,int hrs,int rate){
        super(hrs,rate);
        this.sales = slaes;
        this.commision = commision;
    }
    public void computeSalary(){
        System.out.println(sales*commision*hrs*rate);
    }


}

class Manager extends Employee{
    int fixedSalary;
    int incentives;
    public void computeSalary(){
        int salary=fixedSalary*incentives ;
        System.out.println(salary);

    }
}





public class Que1 {
    public static void main(String[] args) {
        //WageEmployee we = new WageEmployee(9,20);


        SalesPerson sp = new SalesPerson(9, 10, 15, 20);
        sp.computeSalary();

        Manager m = new Manager();
        m.fixedSalary = 30;
        m.incentives = 100;
        m.computeSalary();

        Employee[] employee = new Employee[1];
        employee[0] = new Employee();
        employee[0].hrs = 6;
        employee[0].rate = 10;
        employee[0].computeSalary();



    }
}

