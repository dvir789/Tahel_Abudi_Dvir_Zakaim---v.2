package TahelAbudi_DvirZakaim.exceptions;

public class NameException extends GeneralException {
    private static final String MESSAGE = "wrong input,please enter valid name (at least 2 characters): ";

    public NameException() {
    super(MESSAGE);
    }
}
