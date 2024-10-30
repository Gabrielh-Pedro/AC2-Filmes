package com.example.ac2filmes;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FilmeAdapter filmeAdapter;
    private ArrayList<Filme> listaFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewFilmes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        listaFilmes = new ArrayList<>();
        listaFilmes.add(new Filme("Aaaaaa", 2015, "Freeza retorna para tentar derrotar Goku.", "Akira Toriyama", R.drawable.dbz));
        listaFilmes.add(new Filme("Dragon Ball Super: Broly", 2019, "A história do lendário super sayajin.", "Akira Toriyama", R.drawable.dbzb));
        listaFilmes.add(new Filme("Nanatsu No Taizai: A Fúria de Emboor", 2022, "Os pecados se juntam novamente para salvar o mundo.", "Yasuhito Nishikata", R.drawable.nnt));

        filmeAdapter = new FilmeAdapter(this, listaFilmes);
        recyclerView.setAdapter(filmeAdapter);
    }
}
