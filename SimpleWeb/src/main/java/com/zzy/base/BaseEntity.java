package com.zzy.base;

import java.io.Serializable;

/**
 * @author zero
 * @version 1.0.0
 * @date:2016年9月30日
 * @description: 基础实体类
 */

public class BaseEntity implements Serializable{
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
