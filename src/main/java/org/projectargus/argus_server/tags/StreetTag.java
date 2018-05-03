package org.projectargus.argus_server.tags;

import org.projectargus.argus_server.pictures.TagPicture;
import org.projectargus.argus_server.users.User;

import javax.persistence.*;

@Entity
public class StreetTag {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private TagPicture picture;

    @ManyToOne
    private User user;

    @OneToOne
    private GeoData geoData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TagPicture getPicture() {
        return picture;
    }

    public void setPicture(TagPicture picture) {
        this.picture = picture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GeoData getGeoData() {
        return geoData;
    }

    public void setGeoData(GeoData geoData) {
        this.geoData = geoData;
    }
}
