package com.example.eva1_11_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity
implements AdapterView.OnItemClickListener{

    ListView lstVwDatos;
    String[] aDatos = {
            "Kurisu",
            "Yotsuba",
            "Miku",
            "Itsuki",
            "Nino",
            "Ichika",
            "Tohka",
            "Noelle",
            "Jean",
            "Anila",
            "Andira",
            "Vikala",
            "Pecorine",
            "Kyaru",
            "Kokkoro",
            "Arturia",
            "Hu tao",
            "Katarinna",
            "Beatrix",
            "Cagliostro"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        lstVwDatos=findViewById(R.id.lstVwDatos);
        lstVwDatos.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                aDatos));
        lstVwDatos.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,aDatos[position],Toast.LENGTH_SHORT).show();
    }
}