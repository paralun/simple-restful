package com.paralun.app.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PlayerRequest {

    @NotBlank
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String region;

    @NotBlank
    private String team;

    @NotNull
    @Min(value = 1)
    private int age;
}
