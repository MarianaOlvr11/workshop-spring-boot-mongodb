package com.mavioliveira.workshopMongoDB.dto;

import com.mavioliveira.workshopMongoDB.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO (User obj){ // forma automatizada de instanciar um DTO com user
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
