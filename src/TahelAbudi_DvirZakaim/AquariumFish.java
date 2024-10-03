package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Arrays;

public abstract class AquariumFish extends Animal{

    public static final String[] colorsArr = {"BLACK", "WHITE", "GREEN", "ORANGE", "BLUE", "YELLOW", "BROWN", "GOLD", "RED", "CYAN"};
    public static final String[] patternArr = {"DOTS", "STRIPES", "SPOTS", "PLAIN"};
    public static final String[] Type = {"Clown Fish", "Gold Fish", "Ornamental Fish"};


    protected int age;
    //    protected int numOfColors;
    protected float length;
    protected String type;
    protected String[] colors;
    public int numOfColors;
    protected String pattern;


    public AquariumFish(int age, float length, String[] colors, String pattern) throws GeneralException {
        setAge(age);
        setLength(length);
        setColors(colors);
        setPattern(pattern);
    }

    public void setAge(int age) throws AgeException {
        if (!isValidAge(age)) {
            throw new AgeException();
        }
        this.age = age;
    }

    public static boolean isValidAge(int age) {
        return age > 0;
    }

    public void setLength(float length) throws LengthException {
        if (!isValidLength(length)) {
            throw new LengthException();
        }
        this.length = length;
    }

    public static boolean isValidLength(float length) {
        return length > 0;
    }

    public void setColors(String[] colors) throws ColorException {
        if (!areColorsValid(colors)) {
            throw new ColorException();
        }
        this.colors = colors;
    }

    private boolean areColorsValid(String[] colors) {
        for (String color : colors) {
            if (!Arrays.toString(colorsArr).contains(color)) {
                return false;
            }
        }
        return true;
    }

    public static void validateColor(String color) throws ColorException {
        if (!Arrays.toString(colorsArr).contains(color)) {
            throw new ColorException();
        }
    }

    public void setPattern(String pattern) throws PatternException {
        if (!isValidPattern(pattern)) {
            throw new PatternException();
        }
        this.pattern = pattern.toUpperCase();
    }

    public static boolean isValidPattern(String fishPattern) {
        fishPattern = fishPattern.toLowerCase();
        return (Arrays.toString(OrnamentalFish.patternArr).toLowerCase().contains(fishPattern));
    }

    public static boolean isValidType(String fishType){
        fishType = fishType.toLowerCase();
        return (Arrays.toString(AquariumFish.Type).toLowerCase().contains(fishType));
    }

    public String[] getColors() {
        return colors;
    }

    public String getType() {
        return type;
    }

    public abstract String makeNoise();

//    public abstract boolean areColorsValid();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(" at age: ").append(age).append(" with length: ")
                .append(length).append(" with colors: ").append(Arrays.toString(colors)).append(" with pattern: ").append(pattern);
        return sb.toString();
    }
}


