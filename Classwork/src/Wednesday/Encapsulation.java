package Wednesday;


//this keyword
class Student{

    //private variables
    private int id;
    private String name,city;
    private float percentage;

    //public methods: getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
public class Encapsulation {
    public static void main(String[] args) {

        Student student = new Student();
        //System.out.println(student); This will give the memory address of the student object without to string
        System.out.println(student);
        student.setId(121);
        student.setName("Coditas");
        student.setCity("Pune");
        student.setPercentage(87.5f);
        System.out.println(student);
        System.out.println(student.getId());

    }
}
