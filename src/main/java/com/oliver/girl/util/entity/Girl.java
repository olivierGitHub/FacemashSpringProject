package com.oliver.girl.util.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by oliver on 08/08/15.
 */
@Entity
@Table(name="Girl")
@XmlRootElement
public class Girl {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="NAME")
    private String name;

    @Column(name="PATH")
    private String path;

    @Column(name="RATE")
    private Double rate;

    @Column(name="VICTORIOUS")
    private Boolean victorious;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPath() {return path;}
    public void setPath(String path) {this.path = path;}

    public Double getRate() {return rate;}
    public void setRate(Double rate) {this.rate = rate;}

    public Boolean getVictorious() {return victorious;}
    public void setVictorious(Boolean victorious) {this.victorious = victorious;}

}
