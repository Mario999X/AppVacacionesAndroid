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
import com.example.appvacaciones.Model.Ubicacion;
import com.example.appvacaciones.R;

import java.util.List;

public class RecyclerUbicacionAdapter extends RecyclerView.Adapter<RecyclerUbicacionAdapter.ViewHolder>{

    List<Ubicacion> ubicacionList;
    Context context;
    ClickListener clickListener;

    public RecyclerUbicacionAdapter(List<Ubicacion> ubicacionList, Context context, ClickListener clickListener) {
        this.ubicacionList = ubicacionList;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerUbicacionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_ubicacion_lista, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerUbicacionAdapter.ViewHolder holder, int position) {

        Ubicacion item = ubicacionList.get(position);

        holder.imageViewUbi.setImageResource(item.getImagen());
        holder.textViewNombreUbi.setText(item.getNombre());
        holder.textViewPaisUbi.setText(item.getPais());
        holder.textViewCodigoUbi.setText("ID: " + item.getCodigoId());


    }

    @Override
    public int getItemCount() {
        return ubicacionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageViewUbi;
        TextView textViewNombreUbi, textViewPaisUbi, textViewCodigoUbi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewUbi = itemView.findViewById(R.id.imageViewUbi);
            textViewNombreUbi = itemView.findViewById(R.id.textViewNombreUbi);
            textViewPaisUbi = itemView.findViewById(R.id.textViewPaisUbi);
            textViewCodigoUbi = itemView.findViewById(R.id.textViewCodigoUbi);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition());
        }
    }
}
