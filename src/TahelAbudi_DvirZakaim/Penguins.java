package TahelAbudi_DvirZakaim;


import TahelAbudi_DvirZakaim.exceptions.AgeException;
import TahelAbudi_DvirZakaim.exceptions.GeneralException;
import TahelAbudi_DvirZakaim.exceptions.NameException;
import TahelAbudi_DvirZakaim.exceptions.PenguinHeightException;

import java.util.Objects;

public class Penguins extends Animal{

    private int age;
    private float height;
    private String name;
    public final static float leaderHeight = 200;

    //constructor
    public Penguins(int age, float height, String name, boolean leader) throws GeneralException {
        setAge(age);
        setHeight(height, leader);
        setName(name);
    }

    public void setAge(int age) throws AgeException {
        if (!main.isValidAge(age)) {
            throw new AgeException();
        }
        this.age = age;
    }

    public void setName(String name) throws NameException {
        if (!main.isValidName(name)) {
            throw new NameException();
        }
        this.name = name;
    }

    public void setHeight(float height, boolean isLeader) throws PenguinHeightException {
        if (!isValidPenguinHeight(height, isLeader)) {
            throw  new PenguinHeightException();
        }
        this.height = height;
    }

    // if leader - check for height higher then 0, else check for validation
    public static boolean isValidPenguinHeight(float height, boolean isLeader) throws PenguinHeightException {
        if (height <= 0 || (height >= leaderHeight) && !isLeader) {
            throw new PenguinHeightException();
        }
        return true;
    }

    public float getHeight() { return this.height; }

    @Override
    public String makeNoise() {
        return "squack";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Penguin: ").append(name).append(" at age: ").append(age).append(" with height: ").append(height);
        return sb.toString();
    }

    @Override
    public float mealCalculate() {
        return 1;
    }
}