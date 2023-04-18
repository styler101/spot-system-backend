package br.com.aircnc.aircnc.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "spots")
public class Spot implements Serializable {

    @Id
    private String id;
    private String company;
    private Double price;

    private String techs;

    private String thumbnail;
    private User user;

    public Spot(){}

    public Spot(String id, String company, Double price, String techs, String thumbnail, User user){

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

    public String getTechs() {
        return techs;
    }

    public void setTechs(String techs) {
        this.techs = techs;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id='" + id + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", techs='" + techs + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", user=" + user +
                '}';
    }
}
