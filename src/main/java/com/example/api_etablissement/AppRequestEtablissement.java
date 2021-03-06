package com.example.api_etablissement;

import java.sql.Connection;
import java.util.ArrayList;

import com.example.DAO.DAO;
import com.example.DAO.EtablissementDAO;
import com.example.bdConnection.TheConnection;
import com.example.etablissement.Etablissement;

public class AppRequestEtablissement implements AppInterfaceEtablissement{
    static Connection conn;

    @Override
    public int createEtablissement(Etablissement etablissement) {
        conn = TheConnection.getInstance();
        DAO<Etablissement> etablissementDAO = new EtablissementDAO(conn);
        int id = -1;
        if (etablissementDAO.create(etablissement)) {

            id = ((EtablissementDAO) etablissementDAO).getIdEtablissement(etablissement.getEmail());

            etablissement.setIDEtab(id);

        }
        return etablissement.getIDEtab();
    }

    @Override
    public Etablissement getEtablissement(Integer id) {
        conn = TheConnection.getInstance();

        DAO<Etablissement> etablissementDAO = new EtablissementDAO(conn);
        Etablissement etablissement = etablissementDAO.read(id);

        return etablissement;
    }

    @Override
    public boolean updateEtablissement(Etablissement etablissement) {
        conn = TheConnection.getInstance();
        DAO<Etablissement> etablissementDAO = new EtablissementDAO(conn);
        return etablissementDAO.update(etablissement); 
    }

    @Override
    public ArrayList<Etablissement> getListOfEtablissement(Integer idFestival, String nom, String type, String ville) {
        
        conn = TheConnection.getInstance();

        DAO<Etablissement> etablissementDAO = new EtablissementDAO(conn);
      
        return ((EtablissementDAO) etablissementDAO).searchEtablissement(idFestival, nom, type, ville);   

        
    }

    

    public ArrayList<Etablissement> getListOfEtablissementByVille(Integer idFestival,String ville) {
        
        conn = TheConnection.getInstance();

        DAO<Etablissement> etablissementDAO = new EtablissementDAO(conn);
      
        return ((EtablissementDAO) etablissementDAO).searchEtablissementByVille(idFestival, ville);   

        
    }

    public Etablissement getEtabById(Integer idEtab){

        conn = TheConnection.getInstance();

        DAO<Etablissement> etablissementDAO = new EtablissementDAO(conn);

        return etablissementDAO.read(idEtab);
		
	}

    
}
