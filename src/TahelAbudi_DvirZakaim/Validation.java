package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.AgeException;
import TahelAbudi_DvirZakaim.exceptions.NameException;

public class Validation {

    public static void validateAge(int age) throws AgeException {
        if (age <= 0) {
            throw new AgeException();
        }
    }

    public static void validateName(String name) throws NameException {
        if (name == null || name.trim().length() < 2) {
            throw new NameException();
        }
    }
}
