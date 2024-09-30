package TahelAbudi_DvirZakaim;


import TahelAbudi_DvirZakaim.exceptions.AgeException;
import TahelAbudi_DvirZakaim.exceptions.GeneralException;
import TahelAbudi_DvirZakaim.exceptions.NameException;
import TahelAbudi_DvirZakaim.exceptions.PenguinHeightException;

public class Penguins extends Animal {

    private int age;
    private float height;
    private String name;
    public final static int leaderHeight = 200;

    //constructor
    public Penguins(int age, float height, String name, boolean leader) throws GeneralException {
        setAge(age);
        setHeight(height);
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

    public void setHeight(float height) throws PenguinHeightException {
        if (!isValidPenguinHeight(height)) {
            throw  new PenguinHeightException();
        }
        this.height = height;
    }

    public boolean isValidPenguinHeight(float height) throws PenguinHeightException {
        if (height <= 0 || height >= leaderHeight) {
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

}