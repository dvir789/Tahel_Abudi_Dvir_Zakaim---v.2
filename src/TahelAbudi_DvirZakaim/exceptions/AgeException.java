package TahelAbudi_DvirZakaim.exceptions;

public class AgeException extends GeneralException {
    private static final String MESSAGE = "Age is invalid, please enter an age higher then 0: ";

    public AgeException() {
    super(MESSAGE);
    }
}
