package advertisement;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            CarBody d = CarBody.of("Body");
            Manufacturer m = Manufacturer.of("Manufacture1");
            Cars car = Cars.of("Toyota", d, m);
            User user = User.of("Alex", "@", "23234324");
            Advertisement advertisement = Advertisement.of("dfdafdf", car, user);
            user.add(advertisement);
            session.save(advertisement);
            session.getTransaction().commit();
        }
    }
}
