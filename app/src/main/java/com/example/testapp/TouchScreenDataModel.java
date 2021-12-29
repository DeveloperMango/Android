package com.example.testapp;

public class TouchScreenDataModel {
    private boolean isSelected;
    private int position;

    public TouchScreenDataModel(boolean isSelected, int position) {
        this.isSelected = isSelected;
        this.position = position;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
