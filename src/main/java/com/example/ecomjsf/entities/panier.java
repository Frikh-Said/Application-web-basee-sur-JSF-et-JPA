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
public class panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_panier;

    @ManyToMany
    private List<produit> produits;

    @OneToMany
    private List<commande> commandes;

    @ManyToOne
    private user user;
}
