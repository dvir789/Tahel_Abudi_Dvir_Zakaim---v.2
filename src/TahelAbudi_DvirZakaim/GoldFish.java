package TahelAbudi_DvirZakaim;

import java.util.Arrays;

public class GoldFish extends AquariumFish {

    private final String[] availableColors = {"BLACK", "YELLOW", "GOLD", "ORANGE"};

    public GoldFish(float length, int age, String[] colors, String pattern) throws Exception {
        super(length, age, colors, pattern);
        validateColor();
    }

    private boolean isColorValid(String[] colors) {
        for (String color : colors) {
            if (!Arrays.toString(availableColors).contains(color)) {
                return false;
            }
        }
        return true;
    }

    private void validateColor() throws Exception {
        if (!isColorValid(colors)) {
            throw new Exception("Color not valid");
        }
    }

// pattern --> plain
// colors --> black/gold/orange/yellow
}
