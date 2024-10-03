package TahelAbudi_DvirZakaim;

public abstract class Predator extends Animal {

    protected String name;
    protected int age;
    protected float weight;
    protected String gender;
    protected String type;

    public Predator(String name, int age, float weight, String gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(": ").append(name).append(" at age: ").append(age).append(" with weight: ")
                .append(weight).append(" gender: ").append(gender);
        return sb.toString();
    }
}
