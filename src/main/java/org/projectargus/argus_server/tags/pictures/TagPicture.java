package org.projectargus.argus_server.tags.pictures;

import org.projectargus.argus_server.tags.StreetTag;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TagPicture {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "picture")
    private StreetTag tag;

    private byte[] tagData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StreetTag getTag() {
        return tag;
    }

    public void setTag(StreetTag tag) {
        this.tag = tag;
    }

    public byte[] getTagData() {
        return tagData;
    }

    public void setTagData(byte[] tagData) {
        this.tagData = tagData;
    }
}
