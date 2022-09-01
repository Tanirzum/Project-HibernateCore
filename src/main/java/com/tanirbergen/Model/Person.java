package com.tanirbergen.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
