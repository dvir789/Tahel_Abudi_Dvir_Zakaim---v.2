package TahelAbudi_DvirZakaim.exceptions;

public class TypeException extends GeneralException {
    private static final String MESSAGE = "wrong input, enter correct type: ";

    public TypeException() {
    super(MESSAGE);
    }
}
