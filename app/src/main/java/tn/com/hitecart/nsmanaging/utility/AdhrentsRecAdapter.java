package tn.com.hitecart.nsmanaging.utility;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tn.com.hitecart.nsmanaging.R;
import tn.com.hitecart.nsmanaging.database.AdherentRepository;
import tn.com.hitecart.nsmanaging.model.Adherent;

/**
 * Created by dellcapo on 27/04/17.
 */

public class AdhrentsRecAdapter extends RecyclerView.Adapter<AdhrentsRecAdapter.AdherentViewHolder> {
private AdherentRepository repos;
private Context context;
    private List<Adherent> adherentList;

    public AdhrentsRecAdapter(Context context, List<Adherent> adherentList) {
        this.adherentList = adherentList;
        this.context=context;
        repos= new AdherentRepository(context);
    }

    @Override
    public AdherentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.cardviewadhere, parent, false);

        return new AdherentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdherentViewHolder adherentViewHolder, final int position) {
        Adherent adherent = getAdherentPosition(position);
        adherentViewHolder.vName.setText(adherent.getNameAdherent().toString()+" "
                +adherent.getLastnameAdherent().toString());
        adherentViewHolder.vGrade.setText(adherent.getGrade());
        adherentViewHolder.vSeemore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v,position);
            }
        });

    }
    private Adherent getAdherentPosition(int position){
        return adherentList.get(position);
    }
    private void deleteAdherent(int pos){
        repos.delete(getAdherentPosition(pos));
        notifyDataSetChanged();
    }

    public void showMenu (View view, final int itemPosition)
    {

        PopupMenu menu = new PopupMenu (context, view);
        menu.setOnMenuItemClickListener (new PopupMenu.OnMenuItemClickListener ()
        {
            @Override
            public boolean onMenuItemClick (MenuItem item)
            {
                int id = item.getItemId();
                switch (id)
                {
                    case R.id.action_update:Log.i ("Tag", "settings"); break;
                    case R.id.action_delete:
                        deleteAdherent(itemPosition);
                        Log.i ("Tag", "delete"); break;
                }
                return true;
            }
        });
        menu.inflate (R.menu.updatedelete);
        menu.show();
    }


    @Override
    public int getItemCount() {
        return adherentList.size();
    }

    public static class AdherentViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vGrade;
        protected ImageView vSeemore;

        public AdherentViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.name_text_view);
            vGrade = (TextView)  v.findViewById(R.id.grade_text_view);
            vSeemore= (ImageView) v.findViewById(R.id.seemore_action);
        }
    }
}
