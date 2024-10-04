package TahelAbudi_DvirZakaim.exceptions;

import TahelAbudi_DvirZakaim.AquariumFish;

import java.util.Arrays;

public class ColorException extends GeneralException {
    private static final String MESSAGE = "wrong color input, create new fish: ";

    public ColorException() {
    super(MESSAGE);
    }

}
