package br.com.aircnc.aircnc.dtos;

import br.com.aircnc.aircnc.entities.Spot;
import br.com.aircnc.aircnc.entities.User;

import java.io.Serializable;

public class SpotDTO implements Serializable {

    private String id;
    private String company;

    private Double price;

    private String thumbnail;

    private String[] techs;
    private User user;

    public SpotDTO(){}

    public SpotDTO(String id, String company, Double price, String thumbnail, String[] techs, User user){
        this.id = id;
        this.company = company;
        this.price = price;
        this.thumbnail = thumbnail;
        this.techs = techs;
        this.user = user;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
