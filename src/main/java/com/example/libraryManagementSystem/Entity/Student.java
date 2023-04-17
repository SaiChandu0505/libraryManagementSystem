package com.example.libraryManagementSystem.Entity;

import com.example.libraryManagementSystem.enums.Department;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Department depertment;
    private String mobNo;

    @OneToOne(mappedBy = "student",cascade=CascadeType.ALL)
    Card card;


}
