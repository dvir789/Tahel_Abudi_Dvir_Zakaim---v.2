package TahelAbudi_DvirZakaim;

import java.util.Arrays;

public class OrnamentalFishes extends AquariumFish {

    private int age;
    private float length;
    public String[] colors;
    public int numOfColors;
    public String pattern;
    public final String type = "Ornamental fish";
    public final static int Meal = 3;


    public OrnamentalFishes(int age, float length, String[] colors, String pattern) {
        super(age, length, colors, pattern);
        super.type = type;
    }


    //constructor
    public boolean setAge(int age) {
        if (age <= 0) {
            return false;
        }

        this.age = age;
        return true;
    }

    public static boolean isValidAge(int age) {
        return age > 0;
    }

    public boolean setLength(float length) {
        if (!isValidLength(length)) {
            return false;
        }

        this.length = length;
        return true;
    }

    public static boolean isValidLength(float length) {
        return length > 0;
    }

    public boolean setPattern(String pattern) {
        if (!isValidPattern(pattern)) {
            return false;
        }

        this.pattern = pattern.toUpperCase();
        return true;
    }

    public void addColor(String userColor) {
        if (!isValidColor(userColor)) {
            return;
        }

        if (numOfColors >= colors.length) {
            colors = Arrays.copyOf(colors, colors.length * 2);
        }
        colors[numOfColors++] = userColor.toUpperCase();
    }

    public String[] getColors() {
        return Arrays.copyOf(colors, numOfColors);
    }

    public static boolean isValidColor(String fishColor) {
        fishColor = fishColor.toLowerCase();
        return Arrays.toString(colorsArr).toLowerCase().contains(fishColor);
    }

    public static boolean isValidPattern(String fishPattern) {
        fishPattern = fishPattern.toLowerCase();
        return (Arrays.toString(OrnamentalFishes.patternArr).toLowerCase().contains(fishPattern));
    }

    @Override
    public float MealCalculator() {
        return age < Meal ? Meal : (Meal + length);
    }

    @Override
    public String makeNoise() {
        return "blob";
    }

    @Override
    public float mealCalculate() {
        return age < Meal ? Meal : (Meal + length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fish at age: ").append(age).append(", length: ").append(length).append(", colors: ")
                .append(Arrays.toString(getColors())).append(", pattern: ").append(pattern);
        return sb.toString();
    }

}
