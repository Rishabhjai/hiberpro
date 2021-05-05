package stud;

import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate project started" );
        SessionFactory fac= new Configuration().configure("stud/hibernate.cfg.xml").buildSessionFactory();
        
        Teacher t1 = new Teacher() ;
        ArrayList<Student> studs = new ArrayList<Student>();
        Student s1= new Student();
        s1.setName("Rish");
        s1.setId(2);
        Student s2= new Student("abhid",3,t1);
        Student s3= new Student("Rbh",34,t1);
        Student s4= new Student("Rh",43,t1);
       
        studs.add(s1);
        studs.add(s2);
        studs.add(s3);
        studs.add(s4);
        t1 =new Teacher("Jacob",23,studs);
        
        Session s = fac.openSession();
        
        Transaction tx = s.beginTransaction();
        s.save(s1);
        s.save(s2);
        s.save(s3);
        s.save(s4);
       // s.save(t1);
        tx.commit();
        s.close();
    }
}
