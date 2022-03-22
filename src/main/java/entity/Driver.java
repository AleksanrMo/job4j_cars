package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "history_owner", joinColumns = @JoinColumn(
            name = "driver_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "car_id", nullable = false, updatable = false))
    private Set<Car> cars = new HashSet<>();

  public static Driver of(String st) {
      Driver d = new Driver();
      d.name = st;
      return d;
  }
    public void add(Car car) {
        cars.add(car);
    }
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
}
