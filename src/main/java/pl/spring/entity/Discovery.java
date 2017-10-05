package pl.spring.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 **/
@Entity
@Table(name = "discovery")
public class Discovery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotNull
    private String description;
    @NotEmpty
    private String url;
    private int up_vote;
    private int down_vote;
    @Transient
    private Long user_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Discovery() {
    }

    public Discovery(String title, String description, String url, int up_vote, int down_vote, User user) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.up_vote = up_vote;
        this.down_vote = down_vote;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUp_vote() {
        return up_vote;
    }

    public void setUp_vote(int up_vote) {
        this.up_vote = up_vote;
    }

    public int getDown_vote() {
        return down_vote;
    }

    public void setDown_vote(int down_vote) {
        this.down_vote = down_vote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "Discovery{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", up_vote=" + up_vote +
                ", down_vote=" + down_vote +
                ", user=" + user +
                '}';
    }
}
