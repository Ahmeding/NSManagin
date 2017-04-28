package tn.com.hitecart.nsmanaging.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by dellcapo on 26/04/17.
 */
@DatabaseTable(tableName = "groupe")
public class Groupe {
    @DatabaseField(generatedId = true)
    private int _id;
    @DatabaseField(foreignColumnName = "name")
            private String nameGroupe;

    public Groupe() {
    }

    public Groupe(String nameGroupe) {
        this.nameGroupe = nameGroupe;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNameGroupe() {
        return nameGroupe;
    }

    public void setNameGroupe(String nameGroupe) {
        this.nameGroupe = nameGroupe;
    }
}
