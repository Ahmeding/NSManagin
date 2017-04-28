package tn.com.hitecart.nsmanaging.database;

import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tn.com.hitecart.nsmanaging.model.Adherent;

/**
 * Created by dellcapo on 26/04/17.
 */

public class DBManager {
    private DatabaseHelper helper;
    public static DBManager ourInstace;

    public DBManager(Context context) {
        helper=new DatabaseHelper(context);
    }

    public static void Init(Context context){
        if(ourInstace == null){
            ourInstace= new DBManager(context);
        }
    }
    public static DBManager getInstace(){
        return ourInstace;
    }

    private DatabaseHelper getHelper(){
        return helper;
    }

    /**
     * Methode crud
     */
    public List<Adherent> getAdherents(){
        try {
            return getHelper().getAdherentDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Adherent>();
        }
    }
    public long createAdherent(Adherent adherent){
        try {
            getHelper().getAdherentDao().create(adherent);
            return adherent.get_id();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public long updateAdheren(Adherent adherent){
        try {
            getHelper().getAdherentDao().update(adherent);
            return adherent.get_id();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Adherent> getPersonByName(String name){
        try {
            return getHelper().getAdherentDao().queryForEq("name",name);

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Adherent>();
        }
    }

    public void removeAdherent(Collection<Adherent> adherents){
        try {
            getHelper().getAdherentDao().delete(adherents);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
