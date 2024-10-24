package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Arrays;

public abstract class AquariumFish extends Animal{

    protected final String[] validColors;
    public static final String[] Type = {"Clown Fish", "Gold Fish", "Ornamental Fish"};

    protected float length;
    protected String[] colors;
    protected String pattern;

    public AquariumFish(int age, float length, String[] validColors, int lifeExpectancy) throws GeneralException {
        super(age, lifeExpectancy);
        this.validColors = validColors;
        setLength(length);
    }

    private void setLength(float length) throws LengthException {
        validateLength(length);
        this.length = length;
    }

    public static void validateLength(float length) throws LengthException {
        if (length <= 0) {
            throw new LengthException();
        }
    }

    public String[] getColors() {
        return colors;
    }

    public static void validateType(String fishType) throws TypeException {
        fishType = fishType.toLowerCase();
        if (!Arrays.toString(AquariumFish.Type).toLowerCase().contains(fishType)) {
            throw new TypeException();
        }
    }

    public abstract String makeNoise();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(animalType).append(" at age: ").append(age).append(" with length: ")
                .append(length).append(" with colors: ").append(Arrays.toString(colors))
                .append(" with pattern: ").append(pattern);

        return sb.toString();
    }
}


