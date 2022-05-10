package com.example.appvacaciones.RecyclerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appvacaciones.ClickListener;
import com.example.appvacaciones.Model.Casa;
import com.example.appvacaciones.R;

import java.util.List;

public class RecyclerCasaAdapter extends RecyclerView.Adapter<RecyclerCasaAdapter.ViewHolder> {

    List<Casa> casaList;
    Context context;
    ClickListener clickListener;

    public RecyclerCasaAdapter(List<Casa> casaList, Context context, ClickListener clickListener) {
        this.casaList = casaList;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerCasaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_casa_lista, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerCasaAdapter.ViewHolder holder, int position) {
        Casa item = casaList.get(position);

        holder.imageViewCasa.setImageResource(item.getImagen());
        holder.textViewNombreCasa.setText(item.getNombre());
        holder.textViewPaisCasa.setText(item.getPais());
        holder.textViewPrecioCasa.setText("Precio: " + item.getPrecio() + " €");
    }

    @Override
    public int getItemCount() {
        return casaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageViewCasa;
        TextView textViewNombreCasa, textViewPaisCasa, textViewPrecioCasa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewCasa = itemView.findViewById(R.id.imageViewCasa);
            textViewNombreCasa = itemView.findViewById(R.id.textViewNombreCasa);
            textViewPaisCasa = itemView.findViewById(R.id.textViewPaisCasa);
            textViewPrecioCasa = itemView.findViewById(R.id.textViewPrecioCasa);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition());
        }
    }
}
