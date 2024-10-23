package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.AgeException;

import java.util.Random;

public abstract class Animal {

    protected int age;
    protected String animalType;
    protected int happiness;
    protected int lifeExpectancy;

    public Animal(int age, int lifeExpectancy) throws AgeException {
        setAge(age);
        this.happiness = 100;
        this.lifeExpectancy = lifeExpectancy;
    }

    public void setAge(int age) throws AgeException {
        Validation.validateAge(age, lifeExpectancy);
        this.age = age;
    }


    public void ageOneYear(Manager manager) {
        Random random = new Random();
        this.age++;
        this.happiness -= 15 + random.nextInt(16);

        if (this.age > lifeExpectancy || this.happiness <= 0) {
            manager.removeAnimal(this);
        }
    }

    public void feed() {
        this.happiness = 100;
    }

    public abstract float mealCalculate();

    public abstract String makeNoise();

}