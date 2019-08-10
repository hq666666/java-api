package com.person.example;

import java.util.Objects;

public class Example {

    private String  name;

    private Integer  age;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Example)) return false;
        Example example = (Example) o;
        return Objects.equals(getName(), example.getName()) &&
                Objects.equals(getAge(), example.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

}
