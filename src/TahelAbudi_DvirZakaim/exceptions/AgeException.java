package TahelAbudi_DvirZakaim.exceptions;

public class AgeException extends GeneralException {
    private static final String MESSAGE = "wrong input, enter correct age: ";

    public AgeException() {
    super(MESSAGE);
    }
}
