package com.example.offense;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "offence")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Offence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long userId;

    String description;

    long price;
}
