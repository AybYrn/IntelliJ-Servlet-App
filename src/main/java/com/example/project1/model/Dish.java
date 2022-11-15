package com.example.project1.model;

public class Dish {
    private int dish_id;
    private String dish_name;
    private String provided_by;
    private String ingredient;
    private String instruction;
    private String photo;
    private int number_of_rate;
    private int avg_rate;

    public Dish(Integer dish_id, String dish_name, String provided_by, String ingredient, String instruction, String photo, int number_of_rate, int avg_rate) {
        this.dish_id = dish_id;
        this.dish_name = dish_name;
        this.provided_by = provided_by;
        this.ingredient = ingredient;
        this.instruction = instruction;
        this.photo = photo;
        this.number_of_rate = number_of_rate;
        this.avg_rate = avg_rate;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getProvided_by() {
        return provided_by;
    }

    public void setProvided_by(String provided_by) {
        this.provided_by = provided_by;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String[] getIngredientArray(){
        return ingredient.split(" - ");
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getInstruction() {
        return instruction;
    }

    public String[] getInstructionArray(){
        return instruction.split("\\\\n");
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNumber_of_rate() {
        return number_of_rate;
    }

    public void setNumber_of_rate(int number_of_rate) {
        this.number_of_rate = number_of_rate;
    }

    public int getAvg_rate() {
        return avg_rate;
    }

    public void setAvg_rate(int avg_rate) {
        this.avg_rate = avg_rate;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dish_id=" + dish_id +
                ", dish_name='" + dish_name + '\'' +
                ", provided_by='" + provided_by + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", instruction='" + instruction + '\'' +
                ", photo='" + photo + '\'' +
                ", number_of_rate=" + number_of_rate +
                ", avg_rate=" + avg_rate +
                '}';
    }
}
