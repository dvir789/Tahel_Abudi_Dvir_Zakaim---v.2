package TahelAbudi_DvirZakaim;

import java.util.Objects;

public class Lion {

    private String name;
    private int age;
    private float weight;
    private String gender;

    //constructor
    public Lion(String name, int age, float weight, String gender) {
        setName(name);
        setAge(age);
        setWeight(weight);
        setGender(gender);
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

    public float mealCalculateLion() {
        double factor = (Objects.equals(gender, "male") ? 0.02 : 0.03);
        double meal = Math.floor(factor * age * weight);

        return meal > 25 ? 25 : (float) meal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lion: ").append(name).append(" at age: ").append(age).append(" with weight: ")
                .append(weight).append(" gender: ").append(gender);
        return sb.toString();
    }
}
