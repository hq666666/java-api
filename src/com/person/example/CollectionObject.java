package com.person.example;

public class CollectionObject {

    private String id ;

    private String name;

    private String passwd;

    private Double order;

    public CollectionObject() {
    }

    public CollectionObject(String id, String name, String passwd, Double order) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.order = order;
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Double getOrder() {
        return order;
    }

    public void setOrder(Double order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "CollectionObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", order=" + order +
                '}';
    }
}
