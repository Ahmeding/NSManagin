package tn.com.hitecart.nsmanaging.database;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import tn.com.hitecart.nsmanaging.model.Adherent;

/**
 * Created by dellcapo on 27/04/17.
 */

public class AdherentRepository {
    private DatabaseHelper db;
    Dao<Adherent,Integer> adherentDao;

    public AdherentRepository(Context context) {
        DatabaseManager dbManager= new DatabaseManager();
        db=dbManager.getHelper(context);
        adherentDao=db.getAdherentDao();
    }

    public int create(Adherent adherent){
        try {
            return adherentDao.create(adherent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int upadate(Adherent adherent){
        try {
            return adherentDao.update(adherent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(Adherent adherent){
        try {
            return adherentDao.delete(adherent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public List<Adherent> getAll(){
        try {
            return adherentDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
