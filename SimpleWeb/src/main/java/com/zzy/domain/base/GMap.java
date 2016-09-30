package com.zzy.domain.base;

import com.zzy.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "g_map", catalog = "zero")
public class GMap extends BaseEntity implements java.io.Serializable {

    private String id;
    private String name;
    private Integer width;
    private Integer height;
    private Integer status;
    public GMap() {
    }

    public GMap(String id) {
        this.id = id;
    }

    public GMap(String id, String name,  Integer width, Integer height) {
        this.id = id;
        this.name = name;
        this.width=width;
        this.height=height;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 32)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "height")
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
    @Column(name = "width")
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public GMap setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
