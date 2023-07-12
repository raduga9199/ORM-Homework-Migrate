package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "courses")
public class Course extends BaseEntity{
    private String name;
    private String category;
    private String rating;
    private String description;
}
