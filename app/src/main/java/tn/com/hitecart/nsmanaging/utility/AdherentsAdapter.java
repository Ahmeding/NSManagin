package tn.com.hitecart.nsmanaging.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tn.com.hitecart.nsmanaging.R;
import tn.com.hitecart.nsmanaging.model.Adherent;

/**
 * Created by dellcapo on 27/04/17.
 */

public class AdherentsAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Adherent> mAdherents;
    private LayoutInflater inflater;

    public AdherentsAdapter(Context c, ArrayList<Adherent> adherents) {
        inflater = LayoutInflater.from(c);
        mContext = c;
        mAdherents = adherents;
    }

    @Override
    public int getCount() {
        return mAdherents.size();
    }

    @Override
    public Object getItem(int position) {
        return mAdherents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextView nametextView;
        TextView gradetextView;
        if (v == null) {
            v = inflater.inflate(R.layout.adherent_row, parent, false);
            v.setTag(R.id.name_text_view, v.findViewById(R.id.name_text_view));
        }
        nametextView = (TextView) v.getTag(R.id.name_text_view);
        Adherent adherent= (Adherent) getItem(position);
        nametextView.setText(adherent.getNameAdherent());
        return v;
    }
}
