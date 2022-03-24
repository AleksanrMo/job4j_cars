package advertisement;

import javax.persistence.*;

@Entity
@Table(name = "car_body")
public class CarBody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public static CarBody of(String name) {
        CarBody carBody = new CarBody();
        carBody.name = name;
        return carBody;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
