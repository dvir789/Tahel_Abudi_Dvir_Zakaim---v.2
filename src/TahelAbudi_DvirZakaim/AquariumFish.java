package TahelAbudi_DvirZakaim;

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


    public AquariumFish(int age, float length, String[] colors, String pattern) {
        this.age = age;
        this.length = length;
        this.colors = colors;
        this.pattern = pattern;
    }


    public abstract float MealCalculator();

    @Override
    public abstract String makeNoise();

    public static boolean isValidType(String fishType){
        fishType = fishType.toLowerCase();
        return (Arrays.toString(AquariumFish.Type).toLowerCase().contains(fishType));
    }

    public String[] getColors() {
        return Arrays.copyOf(colors, numOfColors);
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(": ").append(type).append(" at age: ").append(age).append(" with length: ")
                .append(length).append(" with colors: ").append(Arrays.toString(colors)).append(" with pattern: ").append(pattern);
        return sb.toString();
    }
}


