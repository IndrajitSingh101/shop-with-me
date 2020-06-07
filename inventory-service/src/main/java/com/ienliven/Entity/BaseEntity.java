package com.ienliven.Entity;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public abstract class BaseEntity implements Serializable {
    @Id
    private String id;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private Date updatedDate;
}