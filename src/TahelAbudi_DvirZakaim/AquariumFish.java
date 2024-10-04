package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Arrays;

public abstract class AquariumFish extends Animal{

    public static final String[] colorsArr = {"BLACK", "WHITE", "GREEN", "ORANGE", "BLUE", "YELLOW", "BROWN", "GOLD", "RED", "CYAN"};
    public static final String[] patternArr = {"DOTS", "STRIPES", "SPOTS", "PLAIN"};
    public static final String[] Type = {"Clown Fish", "Gold Fish", "Ornamental Fish"};

    protected float length;
    protected String[] colors;
    protected String pattern;

    public AquariumFish(int age, float length, String[] colors, String pattern) throws GeneralException {
        super(age);
        setLength(length);
        setColors(colors);
        setPattern(pattern);
    }

    public void setLength(float length) throws LengthException {
        validateLength(length);
        this.length = length;
    }

    public static void validateLength(float length) throws LengthException {
        if (length <= 0) {
            throw new LengthException();
        }
    }

    public void setColors(String[] colors) throws ColorException {
        validateColors(colors);
        this.colors = colors;
    }

    private void validateColors(String[] colors) throws ColorException {
        for (String color : colors) {
            validateColor(color);
        }
    }

    public static void validateColor(String color) throws ColorException {
        if (!Arrays.asList(colorsArr).contains(color)) {
            throw new ColorException();
        }
    }

    public void setPattern(String pattern) throws PatternException {
        validatePattern(pattern);
        this.pattern = pattern;
    }

    public static void validatePattern(String fishPattern) throws PatternException {
        fishPattern = fishPattern.toLowerCase();
        if(!Arrays.toString(patternArr).toLowerCase().contains(fishPattern)) {
            throw new PatternException();
        }
    }

    public static void validateType(String fishType) throws TypeException {
        fishType = fishType.toLowerCase();
        if (!Arrays.toString(AquariumFish.Type).toLowerCase().contains(fishType)) {
            throw new TypeException();
        }
    }

    public String[] getColors() {
        return colors;
    }

    public abstract String makeNoise();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(animalType).append(" at age: ").append(age).append(" with length: ")
                .append(length).append(" with colors: ").append(Arrays.toString(colors)).append(" with pattern: ").append(pattern);
        return sb.toString();
    }
}


