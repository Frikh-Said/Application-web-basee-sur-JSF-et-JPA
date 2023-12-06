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
public class commande {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_commande;

    private String nom ;

    @ManyToOne
    private user user;

    @ManyToOne
    private produit produit ;

    @ManyToOne
    private panier panier;

}
