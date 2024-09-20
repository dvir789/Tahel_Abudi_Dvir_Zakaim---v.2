package TahelAbudi_DvirZakaim;

import java.util.Arrays;

public class AquariumFish {

    public static final String[] colorsArr = {"BLACK", "WHITE", "GREEN", "ORANGE", "BLUE", "YELLOW", "BROWN", "GOLD", "RED", "CYAN"};
    public static final String[] patternArr = {"DOTS", "STRIPES", "SPOTS", "PLAIN"};

    private int age;
    private float length;
    public String[] colors;
    public int numOfColors;
    public String pattern;

    //constructor
    public AquariumFish(float length, int age, String[] colors, String pattern) {
        setLength(length);
        setAge(age);
        this.colors = new String[1];
        for (String color : colors) {
            addColor(color);
        }
        setPattern(pattern);
    }

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
        return (Arrays.toString(AquariumFish.patternArr).toLowerCase().contains(fishPattern));
    }

    public float mealCalculateFish() {
        return age < 3 ? 3 : (3 + length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fish at age: ").append(age).append(", length: ").append(length).append(", colors: ")
                .append(Arrays.toString(getColors())).append(", pattern: ").append(pattern);
        return sb.toString();
    }
}
