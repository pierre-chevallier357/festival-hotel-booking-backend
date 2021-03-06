package com.example.api_utilisateur;

import java.sql.Connection;
import java.util.ArrayList;

import com.example.DAO.DAO;
import com.example.DAO.HebergeurDAO;
import com.example.bdConnection.TheConnection;
import com.example.utilisateur.Hebergeur;
import com.example.utilisateur.Utilisateur;

public class AppRequestHebergeur implements AppInterfaceUser{
    
    static Connection conn;

    @Override
    public int createUser(String nom , String email){
        conn = TheConnection.getInstance();
        DAO<Hebergeur> hebergeurDAO = new HebergeurDAO(conn);
        Hebergeur hebergeur = new Hebergeur();
        int id = -1;
        hebergeur.setNom(nom);
        hebergeur.setEmail(email);
        if(!hebergeurDAO.create(hebergeur)){

            id =  ((HebergeurDAO) hebergeurDAO).getIdHebergeur(hebergeur.getEmail());
            
            hebergeur.setIdUser(id);
            listUserConnect.add(hebergeur);
        }
        return id;
    }

    @Override
    public Integer connection(String email, String password){
        DAO<Hebergeur> hebergeurDAO = new HebergeurDAO(conn);
        Integer id =((HebergeurDAO) hebergeurDAO).find(email, password);
        return id;
    }

    @Override
    public Hebergeur getUser(int id){
        
        conn = TheConnection.getInstance();
        DAO<Hebergeur> hebergeurDAO = new HebergeurDAO(conn);
        Hebergeur hebergeur =  hebergeurDAO.read(id);
        return hebergeur;
        
    }
    
    @Override
    public boolean updateUser(Integer id, String nom , String email){
        conn = TheConnection.getInstance();
        Hebergeur hebergeur = new Hebergeur();
        hebergeur.setIdUser(id);
        hebergeur.setEmail(email);
        hebergeur.setNom(nom);
        DAO<Hebergeur> hebergeurDAO = new HebergeurDAO(conn);
        boolean res = hebergeurDAO.update((Hebergeur) hebergeur); 
        return res;
    }

    public ArrayList<Utilisateur> getListOfUser(){
        
        conn = TheConnection.getInstance();
        DAO<Hebergeur> hebergementrDAO = new HebergeurDAO(conn);
        ArrayList<Hebergeur> list =  ((HebergeurDAO) hebergementrDAO).listHebergeur();
        ArrayList<Utilisateur> users = cast(list);
        return users;
    }




    @SuppressWarnings("unchecked")
    public static <T> ArrayList<Utilisateur> cast(ArrayList<T> list) {
        return (ArrayList<Utilisateur>) list;
    }
    
}
