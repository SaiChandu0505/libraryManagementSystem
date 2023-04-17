package com.example.libraryManagementSystem.Repositorylayers;

import com.example.libraryManagementSystem.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
