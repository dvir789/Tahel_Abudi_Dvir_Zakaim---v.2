package TahelAbudi_DvirZakaim;

import java.util.Arrays;

public abstract class AquariumFish extends Animal{

    public static final String[] colorsArr = {"BLACK", "WHITE", "GREEN", "ORANGE", "BLUE", "YELLOW", "BROWN", "GOLD", "RED", "CYAN"};
    public static final String[] patternArr = {"DOTS", "STRIPES", "SPOTS", "PLAIN"};


    protected int age;
//    protected int numOfColors;
    protected float length;
    protected String type;
    protected String[] colors;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(": ").append(type).append(" at age: ").append(age).append(" with length: ")
                .append(length).append(" with colors: ").append(Arrays.toString(colors)).append(" with pattern: ").append(pattern);
        return sb.toString();
    }

}
