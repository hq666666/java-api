package com.person.example;

import java.util.Objects;

public class ArrayObject  {

    private String name;

    private Integer age;

    private Integer order;

    public ArrayObject() {
    }

    public ArrayObject(String name, Integer age, Integer order) {
        this.name = name;
        this.age = age;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ArrayObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", order=" + order +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayObject)) return false;
        ArrayObject that = (ArrayObject) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAge(), that.getAge()) &&
                Objects.equals(getOrder(), that.getOrder());
    }



    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getOrder());
    }
}
