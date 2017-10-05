package pl.spring.models;

import org.springframework.stereotype.Component;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 **/
@Component
public class Person {

//    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String nick;
    private String password;

//    private Set<UserRole> roles = new HashSet<>();

    public Person() {
    }

    public Person( String email, String firstName, String lastName, String nick, String password) {
//        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
        this.password = password;
//        this.roles = roles;


    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<UserRole> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<UserRole> roles) {
//        this.roles = roles;
//    }

    @Override
    public String toString() {
        return "Person{" +
//                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
//                ", roles=" + roles +
                '}';
    }
}
