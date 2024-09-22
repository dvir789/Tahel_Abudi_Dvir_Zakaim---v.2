package TahelAbudi_DvirZakaim.exceptions;

public class GeneralException extends Exception {
    private static final String PRE_ERROR = "Error: ";

    public GeneralException(String message) {
    super(PRE_ERROR + message);
    }
}
