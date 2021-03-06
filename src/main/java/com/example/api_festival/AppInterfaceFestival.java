package com.example.api_festival;

import java.util.ArrayList;

public interface AppInterfaceFestival {
    
    public int createFestival(Festival festival);

    public Festival getFestival(int id);

    public boolean updateFestival(Festival festival);

    public ArrayList<Festival> getListOfFestival(String nom, String ville, String type, String departement, String mois);
    
    public ArrayList<Festival> getListOfHundredFestival();
}
