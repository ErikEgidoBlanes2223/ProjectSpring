package com.project.springproject.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a zoo in the wildlife project.
 * 
 * This class contains information about the zoo, such as its name, location,
 * capacity, opening hours, and a list of exhibits.
 * It is annotated with JPA annotations to define its mapping to the database
 * table "zoos".
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "zoos")
public class Zoo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String location;
    private int capacity;
    private String openingHours;

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
    private List<Exhibit> exhibits;
}
