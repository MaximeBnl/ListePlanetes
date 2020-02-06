package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> planetes;
    ListView listview;
    PlaneteAdapter adapter;
    Button verifier = null;
    Data datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datas = new Data();
        listview = (ListView) findViewById(R.id.listview);
        adapter = new PlaneteAdapter(datas.getPlanetesName(),MainActivity.this);
        listview.setAdapter(adapter);

        verifier = (Button) findViewById(R.id.verifier_btn);
        verifier.setOnClickListener(verifierListener);
        verifier.setEnabled(false);



    }

    private View.OnClickListener verifierListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            for (int i = 0; i < datas.getPlanetesName().size(); i++) {
                // View x = (View) listview.getAdapter().getView(0,null,listview);
                View x = (View) listview.getChildAt(i);
                Spinner sp = (Spinner) x.findViewById(R.id.spinner);

                if (!sp.getSelectedItem().toString().equals(datas.getPlanetesSize()[i])) {
                    popUp("Vous n'avez pas les bonnes associations");
                    return;
                }
            }
            popUp("Bien joué ! Vous avez les bons résultats");
        }
    };

    /*
    private void installePlanetes() {
        planetes = new ArrayList<String>();
        planetes.add("Mercure");
        planetes.add("Venus");
        planetes.add("Terre");
        planetes.add("Mars");
        planetes.add("Jupiter");
        planetes.add("Saturne");
        planetes.add("Uranus");
        planetes.add("Neptune");
        planetes.add("Pluton");
    }*/

    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}