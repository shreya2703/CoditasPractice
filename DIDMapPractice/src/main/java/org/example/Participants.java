package org.example;

public class Participants {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public Participants() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Participants(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Participants{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
