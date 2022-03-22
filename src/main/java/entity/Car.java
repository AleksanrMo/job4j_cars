package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "history_owner", joinColumns = @JoinColumn(
            name = "car_id", nullable = false, updatable = false),
    inverseJoinColumns = @JoinColumn(name = "driver_id", nullable = false, updatable = false))
    private Set<Driver> drivers = new HashSet<>();

  public static Car of(String st, Engine engine) {
      Car car = new Car();
      car.name = st;
      car.engine = engine;
      return car;
  }

  public void add(Driver driver) {
      drivers.add(driver);
  }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }
}
