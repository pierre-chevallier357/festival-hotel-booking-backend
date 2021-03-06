package com.example.api_utilisateur;
import java.util.ArrayList;

import com.example.utilisateur.Utilisateur;

public interface AppInterfaceUser {
    
    ArrayList<Utilisateur> listUserConnect = new ArrayList<>();
    

    public int createUser(String nom , String email);

    public Utilisateur getUser(int id);

    public boolean updateUser(Integer id, String nom , String email);

    public ArrayList<Utilisateur> getListOfUser();

    public Integer connection(String email, String password);

    
}
