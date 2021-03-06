package com.example.panier;

import java.util.ArrayList;

public class Panier {

    ArrayList<Produit> listProduit = new ArrayList<>();
    
    Integer idFestivalier;

    Integer idPanier;

    public Integer getIdPanier() {
        return this.idPanier;
    }

    public void setIdPanier(Integer idPanier) {
        this.idPanier = idPanier;
    }

    public void addProduct(Produit produit){

        listProduit.add(produit);
    }

    public Integer getIdFestivalier() {
        return this.idFestivalier;
    }

    public void setIdFestivalier(Integer idFestivalier) {
        this.idFestivalier = idFestivalier;
    }

    public ArrayList<Produit> getProductInPanier(){
        return listProduit;
    }

    public Produit getFirstProductInPanier(){
        return listProduit.get(0);
    }
    
}
