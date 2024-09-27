package TahelAbudi_DvirZakaim;


import TahelAbudi_DvirZakaim.exceptions.AgeException;
import TahelAbudi_DvirZakaim.exceptions.GeneralException;
import TahelAbudi_DvirZakaim.exceptions.NameException;

public class Penguins extends Animal {

    private int age;
    private float height;
    private String name;
    public static final int leaderHeight = 200;

    //constructor
    public Penguins(int age, float height, String name, boolean leader) throws GeneralException {
        setAge(age);
        setHeight(height, leader);
        setName(name);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) throws NameException {
        this.name = name;
    }

    public boolean setHeight(float height, boolean leader) {
        if (!isValidPenguinHeight(height, leader)) {
            return false;
        }

        this.height = height;
        return true;
    }

    public static boolean isValidPenguinHeight(float height, boolean leader) {
        return !(height <= 0 || (!leader && height >= leaderHeight));
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