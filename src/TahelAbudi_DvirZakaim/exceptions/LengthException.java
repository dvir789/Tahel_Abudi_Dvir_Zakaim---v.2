package TahelAbudi_DvirZakaim.exceptions;

public class LengthException extends GeneralException {
    private static final String MESSAGE = "wrong input, enter correct length: ";

    public LengthException() {
    super(MESSAGE);
    }
}
