package org.projectargus.argus_server.tags;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class GeoData {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "geoData")
    private StreetTag tag;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private BigDecimal altitude;

    private BigDecimal targetLongitude;

    private BigDecimal targetLatitude;

    private float bearing;

    private float tilt;

    private float zoom;

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

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getAltitude() {
        return altitude;
    }

    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }

    public BigDecimal getTargetLongitude() {
        return targetLongitude;
    }

    public void setTargetLongitude(BigDecimal targetLongitude) {
        this.targetLongitude = targetLongitude;
    }

    public BigDecimal getTargetLatitude() {
        return targetLatitude;
    }

    public void setTargetLatitude(BigDecimal targetLatitude) {
        this.targetLatitude = targetLatitude;
    }

    public float getBearing() {
        return bearing;
    }

    public void setBearing(float bearing) {
        this.bearing = bearing;
    }

    public float getTilt() {
        return tilt;
    }

    public void setTilt(float tilt) {
        this.tilt = tilt;
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }
}
