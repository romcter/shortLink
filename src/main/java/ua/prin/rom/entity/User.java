package ua.prin.rom.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String hashPass;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ShortLink> shortLink;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Role role;//it's Enum

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private State state;// it's create bellow in this class

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ShortLink> getShortLink() {
        return shortLink;
    }

    public void setShortLink(List<ShortLink> shortLink) {
        this.shortLink = shortLink;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public enum Role{
        USER,ADMIN;
    }
    public enum State{
        BANNED, ACTIVE, DELETE
    }

    public static class Builder{
        private User newUser;

        public Builder(){
            newUser = new User();
        }
        public Builder withLogin(String login){
            newUser.login = login;
            return this;
        }
        public Builder withHashPass(String hashPass){
            newUser.hashPass = hashPass;
            return this;
        }
        public Builder withFirstName(String firstName){
            newUser.firstName = firstName;
            return this;
        }
        public Builder withLastName(String lastName){
            newUser.lastName = lastName;
            return this;
        }
        public Builder withRole(Role role){
            newUser.role = role;
            return this;
        }
        public Builder withState(State state){
            newUser.state = state;
            return this;
        }
        public Builder withId(Long id){
            newUser.id = id;
            return this;
        }
        public Builder withEmail(String email){
            newUser.email = email;
            return this;
        }
        public Builder withPhone(String phone){
            newUser.phone = phone;
            return this;
        }
        public Builder withShortLink(List<ShortLink> shortLink){
            newUser.shortLink = shortLink;
            return this;
        }
        public User build(){
            return newUser;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", hashPass='" + hashPass + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", shortLink=" + shortLink +
                ", role=" + role +
                ", state=" + state +
                '}';
    }
}
