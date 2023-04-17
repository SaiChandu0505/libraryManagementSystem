package com.example.libraryManagementSystem.Entity;

import com.example.libraryManagementSystem.enums.CardStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {
    private int id;
    private Data issueDate;
    @Enumerated(EnumType.STRING)
    private CardStatus cardstatus;
    private String ValidDate;

    @OneToOne
    @JoinColumn
    Student student;


    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> booksIssued = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();
}
