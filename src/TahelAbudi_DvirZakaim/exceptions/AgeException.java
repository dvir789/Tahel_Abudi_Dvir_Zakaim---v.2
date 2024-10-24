package TahelAbudi_DvirZakaim.exceptions;

public class AgeException extends GeneralException {
    private static final String MESSAGE = "Wrong input, invalid age";

    public AgeException() {
        super(MESSAGE);
    }
}
