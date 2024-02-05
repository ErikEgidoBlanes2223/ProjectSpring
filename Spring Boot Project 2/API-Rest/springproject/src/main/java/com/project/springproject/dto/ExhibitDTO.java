package com.project.springproject.dto;

public class ExhibitDTO {

    private Long id;
    private String name;
    private String category;
    private String description;

    public ExhibitDTO() {
        // Default constructor
    }

    public ExhibitDTO(Long id, String name, String category, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ExhibitDTO{ id=" + id +", name='" + name + '\'' +", category='" + category + '\'' +", description='" + description + '\'' +'}';
    }
}
