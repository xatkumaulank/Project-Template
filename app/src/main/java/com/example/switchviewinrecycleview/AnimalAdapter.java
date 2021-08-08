package com.example.switchviewinrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private final List<Animal> animalList;

    public AnimalAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case Animal.TYPE_GRID:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid,parent,false);
                break;
            case Animal.TYPE_LIST:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

                break;
            case Animal.TYPE_STAGGERED:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_staggered,parent,false);

                break;
        }

        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animalList.get(position);
        if (animal == null){
            return;
        }
        holder.imgAnimal.setImageResource(animal.getResourceImage());
        //Glide.with(holder.imgAnimal.getContext()).load(animal.getResourceImage()).into(holder.imgAnimal);
    }

    @Override
    public int getItemCount() {
        if (animalList != null){
            return animalList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        Animal animal = animalList.get(position);
        return animal.getTypeDisplay();
    }

    static class AnimalViewHolder extends RecyclerView.ViewHolder{
        private final ImageView imgAnimal;
        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAnimal = itemView.findViewById(R.id.img_animal);
        }
    }
}
