package TahelAbudi_DvirZakaim.exceptions;

public class PredatorWeightException extends GeneralException {
    private static final String MESSAGE = "wrong input, enter correct weight: ";

    public PredatorWeightException() {
        super(MESSAGE);
    }
}
