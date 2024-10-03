package TahelAbudi_DvirZakaim.exceptions;

import TahelAbudi_DvirZakaim.AquariumFish;

import java.util.Arrays;

public class ColorException extends GeneralException {
    private static final String MESSAGE = "wrong input, enter correct color: ";

    public ColorException() {
    super(MESSAGE);
    }
}
