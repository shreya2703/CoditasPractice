package Wed15;
//constructor to create an object of some kind
//no return type is allowed all variable are same if are returning some variable then it will be partial
//so to avoid that no return type because constructor is of the class only

public class Address {
    int pno,fno,pincode;  //yeh private bhi karr sakte hai
    String hname,area,city,state,country;



    //argument constructor or parameterised constructor


    public Address(int pno, int fno, int pincode, String hname, String area, String city, String state, String country) {
        this.pno = pno;
        this.fno = fno;
        this.pincode = pincode;
        this.hname = hname;
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "pno=" + pno +
                ", fno=" + fno +
                ", pincode=" + pincode +
                ", hname='" + hname + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
