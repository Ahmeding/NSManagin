package tn.com.hitecart.nsmanaging.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import tn.com.hitecart.nsmanaging.R;
import tn.com.hitecart.nsmanaging.database.AdherentRepository;
import tn.com.hitecart.nsmanaging.model.Adherent;
import tn.com.hitecart.nsmanaging.utility.AdherentsAdapter;
import tn.com.hitecart.nsmanaging.utility.AdhrentsRecAdapter;


public class ListeAdherents extends Fragment {


    private AdherentRepository repos;
    private AdherentsAdapter adherentsAdapter;
    private ArrayList<Adherent> adherents;
    private View view;
    private ListView listView;
    //
    private RecyclerView recyclerView;
    private AdhrentsRecAdapter recAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_liste_adherents, container, false);
       // listView = (ListView) view.findViewById(R.id.adhrentsList);
        //
        recyclerView= (RecyclerView) view.findViewById(R.id.adherentcardList);
        //recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm=new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);


        repos = new AdherentRepository(getContext());
        adherents = (ArrayList<Adherent>) repos.getAll();
        //adherentsAdapter = new AdherentsAdapter(getContext(), adherents);
        //listView.setAdapter(adherentsAdapter);
        //
        recAdapter = new AdhrentsRecAdapter(getContext(),adherents);
        recyclerView.setAdapter(recAdapter);

        return view;
    }


}
