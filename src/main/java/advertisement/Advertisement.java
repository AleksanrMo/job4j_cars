package advertisement;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "advertisement")
public class Advertisement {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String description;
        private LocalDateTime created;
        private String photo;
        private boolean status;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "car_id")
        private Cars car;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "user_id")
        private User user;

public static Advertisement of(String description, Cars car, User user) {
    Advertisement advertisement = new Advertisement();
    advertisement.description = description;
    advertisement.created = LocalDateTime.now();
    advertisement.user = user;
    advertisement.car = car;
    advertisement.status = false;
    return advertisement;
}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
