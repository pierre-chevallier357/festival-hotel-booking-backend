package com.example.api_utilisateur;

import java.sql.Connection;
import java.util.ArrayList;

import com.example.Tools;
import com.example.DAO.DAO;
import com.example.DAO.FestivalierDAO;
import com.example.bdConnection.TheConnection;
import com.example.utilisateur.Festivalier;
import com.example.utilisateur.Utilisateur;

public class AppRequestFestivalier implements AppInterfaceUser {

    static Connection conn;

    @Override
    public int createUser(String nom , String email){
        conn = TheConnection.getInstance();
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        Festivalier festivalier = new Festivalier();
        int id = -1;
        festivalier.setNom(nom);
        festivalier.setEmail(email);
        if(festivalierDAO.create(festivalier)){
            id =  ((FestivalierDAO) festivalierDAO).getIdFestivalier(festivalier.getEmail());
            festivalier.setIdUser(id);
            listUserConnect.add(festivalier);
        }
        return id;
    }

    public int createTempUser(){
        conn = TheConnection.getInstance();
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        Festivalier festivalier = new Festivalier();
        festivalier.setEmail("tempEmail"+Tools.randomNum());
        int id = -1;
        if(((FestivalierDAO) festivalierDAO).createTempFestivalier(festivalier.getEmail())){
            id =  ((FestivalierDAO) festivalierDAO).getIdFestivalier(festivalier.getEmail());
            festivalier.setIdUser(id);
            listUserConnect.add(festivalier);
        }
        return id;
    }

    @Override
    public Festivalier getUser(int id){

        conn = TheConnection.getInstance();
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        Festivalier festivalier = festivalierDAO.read(id);
        return festivalier;
    }

    @Override
    public boolean updateUser(Integer id, String nom , String email){
        conn = TheConnection.getInstance();
        Festivalier festivalier = new Festivalier();
        festivalier.setIdUser(id);
        festivalier.setEmail(email);
        festivalier.setNom(nom);
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        boolean res = festivalierDAO.update((Festivalier) festivalier); 
        return res;
    }

    @Override
    public Integer connection(String email, String password){
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        Integer id =((FestivalierDAO) festivalierDAO).find(email, password);
        return id;
    }

    @Override
    public ArrayList<Utilisateur> getListOfUser(){
        
        conn = TheConnection.getInstance();
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);       
        ArrayList<Festivalier> list =  ((FestivalierDAO) festivalierDAO).listFestivalier();
        ArrayList<Utilisateur> users = cast(list);
        return users;
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<Utilisateur> cast(ArrayList<T> list) {
        return (ArrayList<Utilisateur>) list;
    }

    public void deleteUser(Integer id) {
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);   
        ((FestivalierDAO) festivalierDAO).deleteUser(id);
    }

    
}
