package TahelAbudi_DvirZakaim;


import TahelAbudi_DvirZakaim.exceptions.GeneralException;
import TahelAbudi_DvirZakaim.exceptions.NameException;
import TahelAbudi_DvirZakaim.exceptions.PenguinHeightException;

import java.util.Random;

public class Penguins extends Animal{

    private float height;
    private String name;
    public final static float leaderHeight = 200;
    public final float Meal = 1;
    public static final int lifeExpectancy = 6;
    protected int happiness;


    //constructor
    public Penguins(int age, float height, String name, boolean leader) throws GeneralException {
        super(age, lifeExpectancy);
        setHeight(height, leader);
        setName(name);
    }

    public void setName(String name) throws NameException {
        Validation.validateName(name);
        this.name = name;
    }

    public void setHeight(float height, boolean isLeader) throws PenguinHeightException {
        validateHeight(height, isLeader);
        this.height = height;
    }

    // if leader - check for height higher then 0, else check for validation
    public static void validateHeight(float height, boolean isLeader) throws PenguinHeightException {
        if (height <= 0 || (height >= leaderHeight) && !isLeader) {
            throw new PenguinHeightException();
        }
    }

    public float getHeight() { return this.height; }

    @Override
    public String makeNoise() {
        return "squack";
    }

    @Override
    public float mealCalculate() {
        return Meal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Penguin: ").append(name).append(" at age: ").append(age).append(" with height: ").append(height);
        return sb.toString();
    }

}