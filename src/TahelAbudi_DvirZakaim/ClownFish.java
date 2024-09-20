package TahelAbudi_DvirZakaim;

import java.util.Arrays;

public class ClownFish extends AquariumFish {

    private final String[] availableColors = {"BLACK", "WHITE", "ORANGE"};

    public ClownFish(float length, int age, String[] colors, String pattern) throws Exception {
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


// pattern --> stripes
// colors --> black/orange/white
}
