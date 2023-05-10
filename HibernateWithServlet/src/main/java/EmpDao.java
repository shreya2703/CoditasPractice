import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpDao {


    private SessionFactory sessionFactory;
    public EmpDao(SessionFactory sessionFactory){
        super();
        this.sessionFactory = sessionFactory;
    }

    public boolean  saveEmp(Employee emp){
        boolean f = false;
        Session session = sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        int i = (int)session.save(emp);
        if(i>0){
            f=true;

        }
        transaction.commit();
        session.close();
        return f;

    }





}
