package pl.spring.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 **/
@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private Timestamp date;
    @NotEmpty
    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "discovery_id")
    private Discovery discovery;

    public Vote() {
    }

    public Vote(Timestamp date, String type, User user, Discovery discovery) {
        this.date = date;
        this.type = type;
        this.user = user;
        this.discovery = discovery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Discovery getDiscovery() {
        return discovery;
    }

    public void setDiscovery(Discovery discovery) {
        this.discovery = discovery;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", user=" + user +
                ", discovery=" + discovery +
                '}';
    }
}
