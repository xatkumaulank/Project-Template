package com.example.switchviewinrecycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.switchviewinrecycleview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private AnimalAdapter animalAdapter;

    private List<Animal> animalList;

    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    private int currentType = Animal.TYPE_GRID;
    private Menu menu;

    private int currentPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        gridLayoutManager = new GridLayoutManager(this,2);
        linearLayoutManager = new LinearLayoutManager(this);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);


        binding.rcvAnimals.setLayoutManager(gridLayoutManager);
        animalList = getListAnimal();
        setTypeDisplayRCV(Animal.TYPE_GRID);
        animalAdapter = new AnimalAdapter(animalList);

        binding.rcvAnimals.setAdapter(animalAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id  = item.getItemId();
        if (id == R.id.action_menu){
            setCurrentPosition();
            clickChangeTypeDisplay();
        }
        return true;
    }

    private void clickChangeTypeDisplay() {
        if (currentType == Animal.TYPE_GRID){
            setTypeDisplayRCV(Animal.TYPE_LIST);
            binding.rcvAnimals.setLayoutManager(linearLayoutManager);

        }else if(currentType == Animal.TYPE_LIST){
            setTypeDisplayRCV(Animal.TYPE_STAGGERED);
            binding.rcvAnimals.setLayoutManager(staggeredGridLayoutManager);

        }else if (currentType == Animal.TYPE_STAGGERED){
            setTypeDisplayRCV(Animal.TYPE_GRID);
            binding.rcvAnimals.setLayoutManager(gridLayoutManager);

        }
        animalAdapter.notifyDataSetChanged();
        setIconMenu();
        //binding.rcvAnimals.scrollToPosition(currentPosition);
    }

    private void setIconMenu() {
        switch (currentType){
            case Animal.TYPE_GRID:
                menu.getItem(0).setIcon(R.drawable.ic_baseline_grid_on_24);
                break;
            case Animal.TYPE_LIST:
                menu.getItem(0).setIcon(R.drawable.ic_baseline_view_list_24);
                break;
            case Animal.TYPE_STAGGERED:
                menu.getItem(0).setIcon(R.drawable.ic_baseline_list_alt_24);
                break;
        }
    }

    private List<Animal> getListAnimal(){
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal(R.drawable.bird));
        animalList.add(new Animal(R.drawable.deer));
        animalList.add(new Animal(R.drawable.dog));
        animalList.add(new Animal(R.drawable.fox));
        animalList.add(new Animal(R.drawable.fox2));
        animalList.add(new Animal(R.drawable.huou));
        animalList.add(new Animal(R.drawable.leopard));
        animalList.add(new Animal(R.drawable.lion));
        animalList.add(new Animal(R.drawable.pattrot));
        animalList.add(new Animal(R.drawable.rat));
        animalList.add(new Animal(R.drawable.zebra));
        animalList.add(new Animal(R.drawable.turtle));

        animalList.add(new Animal(R.drawable.bird));
        animalList.add(new Animal(R.drawable.deer));
        animalList.add(new Animal(R.drawable.dog));
        animalList.add(new Animal(R.drawable.fox));
        animalList.add(new Animal(R.drawable.fox2));
        animalList.add(new Animal(R.drawable.huou));
        animalList.add(new Animal(R.drawable.leopard));
        animalList.add(new Animal(R.drawable.lion));
        animalList.add(new Animal(R.drawable.pattrot));
        animalList.add(new Animal(R.drawable.rat));
        animalList.add(new Animal(R.drawable.zebra));
        animalList.add(new Animal(R.drawable.turtle));

        return animalList;
    }
    private void setCurrentPosition(){
        RecyclerView.LayoutManager layoutManager = binding.rcvAnimals.getLayoutManager();
        switch (currentType){
            case Animal.TYPE_GRID:
                assert layoutManager != null;
                currentPosition = ((GridLayoutManager)layoutManager).findFirstVisibleItemPosition();
                break;
            case Animal.TYPE_LIST:
                assert layoutManager != null;
                currentPosition = ((LinearLayoutManager)layoutManager).findFirstVisibleItemPosition();
                break;
            case Animal.TYPE_STAGGERED:
                int[] tempPosition = null;
                assert layoutManager != null;
                tempPosition = ((StaggeredGridLayoutManager)layoutManager).findFirstVisibleItemPositions(tempPosition);
                currentPosition = tempPosition[0];
                break;
        }
    }
    private void setTypeDisplayRCV(int typeDisplayRCV){
        if (animalList == null || animalList.isEmpty() ){
            return;
        }
        currentType = typeDisplayRCV;
        for (Animal animal : animalList){
            animal.setTypeDisplay(typeDisplayRCV);
        }
    }
}