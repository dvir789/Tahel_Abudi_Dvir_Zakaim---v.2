package TahelAbudi_DvirZakaim.exceptions;

public class LionGenderException extends GeneralException {
    private static final String MESSAGE = "wrong input, enter correct gender: ";

    public LionGenderException() {
    super(MESSAGE);
    }
}
