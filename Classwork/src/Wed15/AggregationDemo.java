package Wed15;
class Employee{
    Address address;
    int id;
    String name;

    public Employee(Address address, int id, String name) {

        this.address = address;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
public class AggregationDemo {
    public static void main(String[] args){
        //Independent Entity
        Address address1 = new Address(12,101,455001,"Shakuntala",
                "Punekar","Pune","Maharashtra","India");

        //dependentEntity
        Employee employee1 = new Employee(address1,12,"Coditas");
    }
}
