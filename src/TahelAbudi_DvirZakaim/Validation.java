package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.AgeException;
import TahelAbudi_DvirZakaim.exceptions.NameException;

public class Validation {

    public static void validateAge(int age, int lifeExpectancy) throws AgeException {
        if (age <= 0 || age > lifeExpectancy) {
            System.out.println(age);
            throw new AgeException();
        }
    }

    public static void validateName(String name) throws NameException {
        if (!name.matches("^[a-zA-Z\s]+$")) {
            throw new NameException();
        }

        if (name.trim().length() < 2) {
            throw new NameException();
        }
    }
}
