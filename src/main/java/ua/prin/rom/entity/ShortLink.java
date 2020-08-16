package ua.prin.rom.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ShortLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String longLink;

    @Column(nullable = false)
    private Integer shortlink;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Long count;

    public ShortLink(String longLink, Integer shortLink, User user, Long count) {
        this.longLink = longLink;
        this.shortlink = shortLink;
        this.user = user;
        this.count = count;
    }
    public ShortLink() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongLink() {
        return longLink;
    }

    public void setLongLink(String longLink) {
        this.longLink = longLink;
    }

    public Integer getShortlink() {
        return shortlink;
    }

    public void setShortlink(Integer shortlink) {
        this.shortlink = shortlink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortLink shortLink = (ShortLink) o;
        return Objects.equals(id, shortLink.id) &&
                Objects.equals(longLink, shortLink.longLink) &&
                Objects.equals(shortlink, shortLink.shortlink) &&
                Objects.equals(user, shortLink.user) &&
                Objects.equals(count, shortLink.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, longLink, shortlink, user, count);
    }

    @Override
    public String toString() {
        return "ShortLink{" +
                ", longLink='" + longLink + '\'' +
                ", shortlink=" + shortlink +
                ", count=" + count +
                '}';
    }
}
