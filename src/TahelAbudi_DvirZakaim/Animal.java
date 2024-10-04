package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.AgeException;

public abstract class Animal {

    protected int age;
    protected String animalType;

    public Animal(int age) throws AgeException {
        setAge(age);
    }

    public void setAge(int age) throws AgeException {
        Validation.validateAge(age);
        this.age = age;
    }

    public abstract float mealCalculate();

    public abstract String makeNoise();

}