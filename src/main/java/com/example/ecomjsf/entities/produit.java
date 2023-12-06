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
public class produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produit;

    private String nom ;

    private Double prixU ;

    @ManyToMany
    private List<panier> paniers;

    @ManyToMany
    private List<commande> commandes;



}
