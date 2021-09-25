package com.art.senla.repository.entity;

import lombok.Data;

@Data
public class User extends AbstractEntity {
    private String name;
    private String lastname;
    private String email;
    private String password;
}
