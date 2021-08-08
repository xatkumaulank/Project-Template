package com.example.switchviewinrecycleview;

public class Animal {
    public static final int TYPE_GRID = 1;
    public static final int TYPE_LIST = 2;
    public static final int TYPE_STAGGERED = 3;

    private int typeDisplay;
    private int resourceImage;



    public Animal(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public int getTypeDisplay() {
        return typeDisplay;
    }

    public void setTypeDisplay(int typeDisplay) {
        this.typeDisplay = typeDisplay;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }
}
