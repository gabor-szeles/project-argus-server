package org.projectargus.argus_server.tags;

import org.projectargus.argus_server.tags.pictures.TagPicture;
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

    @Enumerated(value = EnumType.STRING)
    private Privacy privacy;

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

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }
}
