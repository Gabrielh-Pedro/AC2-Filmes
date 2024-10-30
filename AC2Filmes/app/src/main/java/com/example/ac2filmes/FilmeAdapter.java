package com.example.ac2filmes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {
    private ArrayList<Filme> filmes;
    private Context context;

    public FilmeAdapter(Context context, ArrayList<Filme> filmes) {
        this.context = context;
        this.filmes = filmes;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_filme, parent, false);
        return new FilmeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Filme filme = filmes.get(position);
        holder.textTitulo.setText(filme.getTitulo());
        holder.textAno.setText(String.valueOf(filme.getAno()));
        holder.textDiretor.setText(filme.getDiretor());
        holder.imagePoster.setImageResource(filme.getImagem());

        holder.buttonSinopse.setOnClickListener(v -> {
            Toast.makeText(context, filme.getSinopse(), Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder {
        TextView textTitulo, textAno, textDiretor;
        ImageView imagePoster;
        Button buttonSinopse;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitulo = itemView.findViewById(R.id.textTitulo);
            textAno = itemView.findViewById(R.id.textAno);
            textDiretor = itemView.findViewById(R.id.textDiretor);
            imagePoster = itemView.findViewById(R.id.imagePoster);
            buttonSinopse = itemView.findViewById(R.id.buttonSinopse);
        }
    }
}
