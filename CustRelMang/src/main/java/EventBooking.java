import javax.persistence.*;

@Entity
public class EventBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eventDatetime;
    @ManyToOne
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventDatetime() {
        return eventDatetime;
    }

    public void setEventDatetime(String eventDatetime) {
        this.eventDatetime = eventDatetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EventBooking(String eventDatetime, User user) {
        this.eventDatetime = eventDatetime;
        this.user = user;
    }
    public EventBooking(){

    }


    @Override
    public String toString() {
        return "EventBooking{" +
                "id=" + id +
                ", eventDatetime='" + eventDatetime + '\'' +
                ", user=" + user +
                '}';
    }
}
