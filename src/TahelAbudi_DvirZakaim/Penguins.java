package TahelAbudi_DvirZakaim;


public class Penguins extends Animal {

    private int age;
    private float height;
    private String name;
    public static final int leaderHeight = 200;

    //constructor
    public Penguins(int age, float height, String name, boolean leader) {
        setAge(age);
        setHeight(height, leader);
        setName(name);
    }

    public boolean setAge(int age) {
        if (!isValidPenguinAge(age)) {
            return false;
        }

        this.age = age;
        return true;
    }

    public static boolean isValidPenguinAge(int age) {
        return age > 0;
    }

    public boolean setName(String name) {
        if (!isValidName(name)) {
            return false;
        }

        this.name = name;
        return true;
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

    public static boolean isValidName(String name) {
        return (name != null && name.trim().length() >= 2);
    }

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