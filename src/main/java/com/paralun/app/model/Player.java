package com.paralun.app.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_player")
public class Player {
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "team")
    private String team;

    @Column(name = "age")
    private int age;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
