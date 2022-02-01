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
    public ArrayList<Etablissement> getListOfEtablissement(Integer idFestival, String type, int typeOfReach, String option) {
        
        conn = TheConnection.getInstance();

        DAO<Etablissement> etablissementDAO = new EtablissementDAO(conn);
        ArrayList<Etablissement> list;

        switch (typeOfReach){

            case 1 : 
                list  = ((EtablissementDAO) etablissementDAO).listEtabByName(idFestival, type, option);
                break;

            case 2 :
                list  = ((EtablissementDAO) etablissementDAO).listEtabByVille(idFestival, type, option);
                break;

            case 3 :
                list  = ((EtablissementDAO) etablissementDAO).listEtabByType(idFestival, type);
                break;

            default :
                list = new ArrayList<>();
                break;

        }

        return list;
    }


    
}
