package entity;


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
        Engine engine1 = Engine.of("V4");
        Engine engine2 = Engine.of("V6");
        Engine engine3 = Engine.of("V8");
        session.save(engine1);
        session.save(engine2);
        session.save(engine3);
        Car car1 = Car.of("CityCar", engine1);
        Car car2 = Car.of("Jeep", engine2);
        Car car3 = Car.of("Truck", engine3);
        Driver driver1 = Driver.of("Evgeniy");
        Driver driver2 = Driver.of("Taras");
        Driver driver3 = Driver.of("Petr");
        car1.add(driver1);
        car1.add(driver2);
        car1.add(driver3);
        car2.add(driver2);
        car2.add(driver3);
        car3.add(driver3);
        session.save(car1);
        session.save(car2);
        session.save(car3);
        session.getTransaction().commit();
    }
}

}
