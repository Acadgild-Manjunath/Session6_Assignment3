package com.acadgild.com.session6_assignment3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends android.support.v4.app.ListFragment {
    String[] countryNames = {"Afghanistan","Argentina", "Australia", "Canada", "Cuba", "Great Britain",
                            "India", "New Zealand", "Russia", "United States"};
    Integer[] flagImages = {R.drawable.afghanistan, R.drawable.argentina, R.drawable.australia, R.drawable.canada, R.drawable.cuba,
            R.drawable.britain, R.drawable.india, R.drawable.newzealand, R.drawable.russia, R.drawable.unitedstates};
    String[] description = {"Afghani", "Argentine peso", "Australian dollar", "Dollar", "Peso", "British Pound", "Indian Rupees",
                            "New Zealand dollar","Ruble", "US dollar"};

    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();

    SimpleAdapter adp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        HashMap<String,String> map = new HashMap<String, String>();

        for(int i=0;i<countryNames.length;i++)
        {
            map = new HashMap<String, String>();
            map.put("Names", countryNames[i]);
            map.put("Images", Integer.toString(flagImages[i]));
            map.put("Desc", description[i]);

            data.add(map);
        }

        //Keys in Map
        String[] keys = {"Names", "Images", "Desc"};

        // Ids of Views
        int[] viewIds = {R.id.txtName, R.id.imageFlag1, R.id.txtDescription};


        //Adapter
        adp = new SimpleAdapter(getActivity(), data, R.layout.list_fragment, keys, viewIds);
        setListAdapter(adp);


        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);

    }


    @Override
    public void onStart() {
        super.onStart();

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Toast.makeText(getActivity(), data.get(pos).get("Names"), Toast.LENGTH_SHORT).show();
            }
        });














    }
}
