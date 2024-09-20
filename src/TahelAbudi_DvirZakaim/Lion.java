package TahelAbudi_DvirZakaim;

import java.util.Objects;

public class Lion extends Predator{

    private static final String type = "Lion";

    //constructor
    public Lion(String name, int age, float weight, String gender) {
        super(name, age, weight, gender);
        super.type = type;
    }

    public boolean setName(String name) {
        if (!isValidName(name)) {
            return false;
        }

        this.name = name;
        return true;
    }

    public static boolean isValidName(String name) {
        return (name != null && name.trim().length() >= 2);
    }

    public boolean setAge(int age) {
        if (!isValidLionAge(age)) {
            return false;
        }

        this.age = age;
        return true;
    }

    public static boolean isValidLionAge(int age) {
        return age > 0;
    }

    public boolean setWeight(float weight) {
        if (!isValidLionWeight(weight)) {
            return false;
        }

        this.weight = weight;
        return true;
    }

    public static boolean isValidLionWeight(float weight) {
        return weight > 0;
    }

    public boolean setGender(String gender) {
        if (!isValidGender(gender)) {
            return false;
        }

        this.gender = gender;
        return true;
    }

    public static boolean isValidGender(String gender) {
        return Objects.equals(gender, "male") || Objects.equals(gender, "female");
    }

    @Override
    public float mealCalculate() {
        double factor = (Objects.equals(gender, "male") ? 0.02 : 0.03);
        double meal = Math.floor(factor * age * weight);

        return meal > 25 ? 25 : (float) meal;
    }

    @Override
    public String makeNoise() {
        return "ROAR";
    }

}
