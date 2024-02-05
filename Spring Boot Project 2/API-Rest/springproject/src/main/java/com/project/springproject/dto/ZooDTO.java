package com.project.springproject.dto;

import java.util.List;

public class ZooDTO {

    private Long id;
    private String name;
    private String location;
    private int capacity;
    private String openingHours;
    private List<ExhibitDTO> exhibits;

    public ZooDTO() {
        // Default constructor
    }

    public ZooDTO(Long id, String name, String location, int capacity, String openingHours, List<ExhibitDTO> exhibits) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.openingHours = openingHours;
        this.exhibits = exhibits;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public List<ExhibitDTO> getExhibits() {
        return exhibits;
    }

    public void setExhibits(List<ExhibitDTO> exhibits) {
        this.exhibits = exhibits;
    }

    @Override
    public String toString() {return "ZooDTO{" +"id=" + id +", name='" + name + '\'' +", location='" + location + '\'' +
                ", capacity=" + capacity +", openingHours='" + openingHours + '\'' +", exhibits=" + exhibits +'}';}
}
