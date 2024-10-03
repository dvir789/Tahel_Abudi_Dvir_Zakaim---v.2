package TahelAbudi_DvirZakaim.exceptions;

public class PatternException extends GeneralException {
    private static final String MESSAGE = "wrong input, enter correct pattern: ";

    public PatternException() {
    super(MESSAGE);
    }
}
