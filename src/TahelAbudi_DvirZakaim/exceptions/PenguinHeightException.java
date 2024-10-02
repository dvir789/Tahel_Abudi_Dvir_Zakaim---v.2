package TahelAbudi_DvirZakaim.exceptions;

public class PenguinHeightException extends GeneralException {
    private static final String MESSAGE = "wrong input, enter correct height: ";

    public PenguinHeightException() {
        super(MESSAGE);
    }
}
