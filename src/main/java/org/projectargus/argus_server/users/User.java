package org.projectargus.argus_server.users;

import org.projectargus.argus_server.tags.StreetTag;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    @OneToMany(mappedBy = "user")
    private Set<StreetTag> tagSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<StreetTag> getTagSet() {
        return tagSet;
    }

    public void setTagSet(Set<StreetTag> tagSet) {
        this.tagSet = tagSet;
    }
}
