package com.example.other;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.DAO.*;
import com.example.api_festival.AppInterfaceFestival;
import com.example.api_festival.AppRequestFestival;
import com.example.api_festival.Festival;
import com.example.etablissement.*;
import com.example.panier.AppInterfacePanier;
import com.example.panier.AppRequestPanier;
import com.example.panier.Panier;
import com.example.panier.Produit;
import com.example.utilisateur.*;
import com.example.bdConnection.*;


public class Main {
    static Connection conn;
    public static void main(String args[]) {
        conn = TheConnection.getInstance();

       //FestivalDAO festivalDAO ;
        /* DAO<Etablissement> etablissementDAO = new EtablissementDAO(conn);
        ArrayList<Etablissement> list = ((EtablissementDAO) etablissementDAO).listEtab(1, "H�TEL");

        for (Etablissement etab : list) {
            System.out.println(etab.getNomCommercial()); 
        }
        System.out.println("---------------------L'HOTEL ID :12379  --------------------------");
        
        Etablissement etabById = ((EtablissementDAO) etablissementDAO).read(12379);
        
        System.out.println(etabById.getNomCommercial()); 

        System.out.println("---------------------AU REVOIR --------------------------");
        
       
        DAO<Festival> festivalDAO = new FestivalDAO(conn);

        System.out.println("---------------------Le Festival par ville  --------------------------");
        
       
        ArrayList<Festival> listFesti = ((FestivalDAO) festivalDAO).listFestivalReachByVille("REIMS");

        for (Festival festi : listFesti) {
            System.out.println(festi.getNom()); 
        }
        
        System.out.println("---------------------Le Festival par departement  --------------------------");
        
        ArrayList<Festival> listDep = ((FestivalDAO) festivalDAO).listFestivalReachByDepartement("Bouches-du-Rh�ne");

        for (Festival festi : listDep) {
            System.out.println(festi.getNom()); 
        }
        
        System.out.println("---------------------Le Festival ID :111  --------------------------");
        
        Festival festibyId = ((FestivalDAO) festivalDAO).read(111);
        
        System.out.println(festibyId.getLocalisation().getCommune()); 
        

        System.out.println("---------------------Le Festival de Musique Classique  --------------------------");
        
        DAO<Festival> festivalDAO = new FestivalDAO(conn);
        //ArrayList<Festival> listDomaine = ((FestivalDAO) festivalDAO).searchFestivalsByVille("REIMS");
        AppInterfaceFestival requestFestival = new AppRequestFestival();
        ArrayList<Festival> listDomaine = requestFestival.getListOfFestival(1,"AU COEUR DE COSNE");
    	
        for (Festival festi : listDomaine) {
            System.out.println(festi.getNom()); 
        }
        */
        
       /*
        System.out.println("---------------------Le Festival de Musique Classique voir ces  domaines  --------------------------");
        
        
        ArrayList<Festival> listComp = ((FestivalDAO) festivalDAO).listFestivalReachByType("Musiques classiques");
    	
        for (Festival festi : listComp) {
        	if (festi.getComplementDomaine() != null) {
        		System.out.println(festi.getComplementDomaine() +"   ID : "+ festi.getIdFestival()); 
        	}
        }
        
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        
        Festivalier festivalier = new Festivalier();
        festivalier.setEmail("mounir@gmail.com");
        festivalier.setNom("MIKL");
       
        festivalierDAO.create(festivalier);
        

        int id = ((FestivalierDAO) festivalierDAO).getIdFestivalier(festivalier.getEmail());
        //System.out.println("---------------------ID GENERER : "+id+" --------------------------");
        
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        Festivalier festivalier = new Festivalier();
        festivalier = festivalierDAO.read(7); 
        
        System.out.println(festivalier.getNom() +" Email : "+festivalier.getEmail());
        ArrayList<Festivalier> listFestivalier;
        listFestivalier = ((FestivalierDAO) festivalierDAO).listFestivalier();
        for (Festivalier festi : listFestivalier) {
        	System.out.println(festi.getNom() +"   ID : "+ festi.getIdUser()); 
        }
        System.out.println("---------------------AU REVOIR --------------------------");
    
        try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/

       /* AppInterfacePanier panier = new AppRequestPanier();

        Produit produit = new Produit();
        int idFestivalier = 1;
        produit.setIdEtablissement(123);
        produit.setIdFestival(124);
        produit.setIdFestivalier(idFestivalier);
        produit.setNbPass(2);
        Integer id = panier.createPanier(idFestivalier, produit);
        Produit produit2 = new Produit();
        produit2.setIdEtablissement(1414141);
        produit2.setIdFestival(55555);
        produit2.setIdFestivalier(11111);
        produit2.setNbPass(5);
        panier.addProduct(id, produit2);
        ArrayList<Produit> listProduit =  ((AppRequestPanier) panier).getProduct(id);
        for(Produit produit3 : listProduit){
            System.out.println(produit3.getIdFestivalier());
        }*/

        DAO<Panier> panierDAO = new PanierDAO(conn);

        Produit produit = ((PanierDAO) panierDAO).getProduit(1);
        System.out.println(produit.getIdProduit());
        


    }



}
