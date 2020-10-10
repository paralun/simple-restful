package com.paralun.app.dto;

import lombok.Data;
import java.util.Date;

@Data
public class PlayerResponse {
    private String id;
    private String name;
    private String region;
    private String team;
    private int age;
    private Date createdAt;
    private Date updatedAt;
}
