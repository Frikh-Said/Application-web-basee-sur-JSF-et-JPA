package com.example.ecomjsf.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    private String nom ;

    @OneToMany
    private List<panier> paniers;

    @OneToMany
    private List<commande> commandes;
}
