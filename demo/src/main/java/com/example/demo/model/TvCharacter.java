package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "characters")
public class TvCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterId;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    private String universe;  // Extra attribute 1
    private String role;      // Extra attribute 2
    private LocalDate activeDate;

    public TvCharacter() {}

    public TvCharacter(String name, String description, String universe, String role, LocalDate activeDate) {
        this.name = name;
        this.description = description;
        this.universe = universe;
        this.role = role;
        this.activeDate = activeDate;
    }

    // Getters and Setters
    public Long getCharacterId() { return characterId; }
    public void setCharacterId(Long characterId) { this.characterId = characterId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUniverse() { return universe; }
    public void setUniverse(String universe) { this.universe = universe; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDate getActiveDate() { return activeDate; }
    public void setActiveDate(LocalDate activeDate) { this.activeDate = activeDate; }
}