package br.com.aircnc.aircnc.dtos;

import br.com.aircnc.aircnc.entities.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private String email;

    public UserDTO(){}

    public UserDTO(String id, String email){
        this.id = id;
        this.email = email;
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.email = user.getEmail();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
