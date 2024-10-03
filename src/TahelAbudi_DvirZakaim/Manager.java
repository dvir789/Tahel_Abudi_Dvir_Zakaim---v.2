package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Manager {

    private final String name;
    private final String city;
    private final String street;
    private final String number;

    private Animal[] animalsPack;
    private int animalsCount;

    private OrnamentalFishes[] ornamentalFishesPack;
    private int aquariumFishCount;

    private int numOfUniqueColors;

    //constructor
    public Manager(String name, String city, String street, String number) {
        this.name = name;
        this.city = city;
        this.street = street;
        this. number = number;

        setAnimalsPack();
        setLion();
        setTiger();
        setPenguin();
        setAquariumFish();
    }

//     ========== Animals ==========

    public void setAnimalsPack() {
        animalsPack = new Animal[1];
        animalsCount = 0;
    }

    public void addAnimal (Animal animal) {
        if (animalsCount >= animalsPack.length) {
            animalsPack = Arrays.copyOf(animalsPack, animalsPack.length * 2);
        }
        animalsPack[animalsCount++] = animal;
    }

    public String getAnimalsList() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < animalsCount - 1; i++) {
            sb.append(animalsPack[i].toString());
            sb.append(",\n");
        }
        sb.append(animalsPack[animalsCount - 1].toString());

        return sb.toString();
    }

    // ========== PENGUIN ==========

    private void setPenguin() {

        createPenguin(15, Penguins.leaderHeight, "Rossi", true); // leader
        createPenguin(12, 180, "Moss", false);
        createPenguin(11, 175, "Simon", false);
    }

    public void createPenguin(int age, float height, String name, boolean leader) {
        try {
            Animal penguin = new Penguins(age, height, name, leader);
            addAnimal(penguin);
        } catch (GeneralException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getPenguinList() {
        StringBuilder sb = new StringBuilder();

        Penguins[] penguins = new Penguins[animalsCount];
        int place;
        int numOfPenguins = 0;

        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i].getClass().getSimpleName().equals("Penguins")) {
                Penguins penguin = (Penguins) animalsPack[i];

                for (place = 0; place < numOfPenguins; place++) {
                    if (penguin.getHeight() > penguins[place].getHeight()) {
                        break;
                    }
                }
                if (numOfPenguins - place >= 0) {
                    System.arraycopy(penguins, place, penguins, place + 1, numOfPenguins - place);
                }
                penguins[place] = penguin;
                numOfPenguins++;
            }
        }
        System.out.println(numOfPenguins);
        for (int i = 0; i < numOfPenguins - 1; i++) {
            sb.append(penguins[i].toString());
            sb.append(",\n");
        }

        sb.append(penguins[numOfPenguins - 1].toString());

        return sb.toString();
    }

    // ========== LION ==========

    private void setLion() {

        createLion("Mufasa", 26, 50, "male");
        createLion("Simba", 15, 30, "male");
        createLion("Nala", 15, 25, "female");
        createLion("Sarabi", 26, 40, "female");
    }

    public void createLion(String name, int age, float weight, String gender) {
        Animal lion = new Lion(name, age, weight, gender);
        addAnimal(lion);
    }

    public String getLionList() {
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i].getClass().getSimpleName().equals("Lion")) {
                sb1.append(animalsPack[i].toString()).append("\n");
            }
        }

        return sb1.toString();
    }

    // ========== TIGER ==========

    private void setTiger() {

        createTiger("Mufasa", 26, 50, "male");
        createTiger("Simba", 15, 30, "male");
        createTiger("Nala", 15, 25, "female");
        createTiger("Sarabi", 26, 40, "female");
    }

    public void createTiger(String name, int age, float weight, String gender) {
        Animal tiger = new Tiger(name, age, weight, gender);
        addAnimal(tiger);
    }

    public String getTigerList() {
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i].getClass().getSimpleName().equals("Tiger")) {
                sb1.append(animalsPack[i].toString()).append("\n");
            }
        }

        return sb1.toString();
    }

    // ========== AQUARIUM FISH ==========

    private void setAquariumFish() {
        ornamentalFishesPack = new OrnamentalFishes[1];
        addRandomFish(10);
    }

    private void addRandomFish(int amount) {
        Random r = new Random();
        int age, patternSize = OrnamentalFishes.patternArr.length, colorSize = OrnamentalFishes.colorsArr.length;
        String[] fishColor;
        String fishPattern;
        float length;
        int colorRandomNumber, patternRandomNumber;

        for (int i = 0; i < amount; i++) {
            age = r.nextInt(15) + 1;
            length = r.nextFloat(10) + 1;
            colorRandomNumber = r.nextInt(colorSize);
            fishColor = new String[]{OrnamentalFishes.colorsArr[colorRandomNumber]};
            patternRandomNumber = r.nextInt(patternSize);
            fishPattern = OrnamentalFishes.patternArr[patternRandomNumber];
            createFish(age, fishColor, length, fishPattern);
        }
    }

    public void createFish(int age, String[] userColors, float length, String userPattern) {
        OrnamentalFishes fish = new OrnamentalFishes(age, length, userColors, userPattern);
        addFish(fish);
    }

    private void addFish(OrnamentalFishes fish) {
        if (aquariumFishCount >= ornamentalFishesPack.length) {
            ornamentalFishesPack = Arrays.copyOf(ornamentalFishesPack, ornamentalFishesPack.length * 2);
        }
        ornamentalFishesPack[aquariumFishCount++] = fish;
    }

    public String getAquariumFishList() {
        StringBuilder sb = new StringBuilder();
        String[] uniqueColors = new String[1];
        numOfUniqueColors = 0;

        for (int i = 0; i < aquariumFishCount - 1; i++) {
            sb.append(ornamentalFishesPack[i].toString());
            sb.append(",\n");
        }
        sb.append(ornamentalFishesPack[aquariumFishCount - 1].toString());
        sb.append("\nThere are ").append(aquariumFishCount).append(" fishes in the aquarium\n");

        for (int i = 0; i < aquariumFishCount; i++) {
            String[] fishColors = ornamentalFishesPack[i].getColors();
            for (String color : fishColors) {
                uniqueColors = isUniqueColor(uniqueColors, color);
            }
        }

        uniqueColors = Arrays.copyOf(uniqueColors, numOfUniqueColors);
        sb.append(Arrays.toString(uniqueColors));

        return sb.toString();
    }

    public String[] isUniqueColor(String[] uniqueColors, String color) {
        if (Arrays.toString(uniqueColors).toLowerCase().contains(color.toLowerCase())) {
            return uniqueColors;
        }

        if (numOfUniqueColors >= uniqueColors.length) {
            uniqueColors = Arrays.copyOf(uniqueColors, uniqueColors.length * 2);     // AKRISH LOOK HERE

        }

        uniqueColors[numOfUniqueColors++] = color;
        return uniqueColors;
    }

    private Map<String, Float> getAnimalFeed() {
        Map<String, Float> zooFeed = new HashMap<>();

        for (int i = 0; i < animalsCount; i++) {
            String animalType = animalsPack[i].getClass().getSimpleName();
            float mealCalculator = animalsPack[i].mealCalculate();
            if (zooFeed.containsKey(animalType)) {
                zooFeed.compute(animalType, (k, feed) -> (feed == null) ? mealCalculator : feed + mealCalculator);
            } else {
                zooFeed.put(animalType, mealCalculator);
            }
        }
        return zooFeed;
    }

    public String feedAllAnimals() {
        Map<String, Float> zooFeed = getAnimalFeed();

        StringBuilder sb = new StringBuilder();

        sb.append("The lions ate: ").append(zooFeed.get("Lion")).append(" kg of meat\n");
        sb.append("The Tigers ate: ").append(zooFeed.get("Tiger")).append(" kg of meat\n");
        sb.append("The penguins ate: ").append(zooFeed.get("Penguins")).append(" fishes");
//        sb.append("The fishes ate: ").append(fishMeals).append(" meals\n");
        return sb.toString();
    }

    private Map<String, Integer> getAnimalCount() {
        Map<String, Integer> zooCount = new HashMap<>();

        for (int i = 0; i < animalsCount; i++) {
            String animalType = animalsPack[i].getClass().getSimpleName();
            if (zooCount.containsKey(animalType)) {
                zooCount.compute(animalType, (k, count) -> (count == null) ? 1 : count + 1);
            } else {
                zooCount.put(animalType, 1);
            }
        }
        return zooCount;
    }

    @Override
    public String toString() {
        Map<String, Integer> zooCount = getAnimalCount();

        StringBuilder sb = new StringBuilder();
        sb.append("The Zoo name is: ").append(name).append("\n");
        sb.append("The zoo address is: ").append(city).append(", ").append(number).append(", ").append(street).append("\n");
        sb.append("Lions: ").append(zooCount.get("Lion")).append("\n");
        sb.append("Tigers: ").append(zooCount.get("Tiger")).append("\n");
        sb.append("Penguins: ").append(zooCount.get("Penguins")).append("\n");
        sb.append("AquariumFish: ").append(zooCount.get("AquariumFish")).append("\n");
        return sb.toString();
    }

    //---------- FISH INPUT VALIDATION ----------

    public boolean isValidFishAge(int age) {
        return OrnamentalFishes.isValidAge(age);
    }

    public boolean isValidFishColor(String userColor) {
        return OrnamentalFishes.isValidColor(userColor);
    }

    public boolean isValidFishLength(float length) {
        return OrnamentalFishes.isValidLength(length);
    }

    public boolean isValidFishPattern(String userPattern) {
        return OrnamentalFishes.isValidPattern(userPattern);
    }

    public boolean canAddFishColor(int numOfUserColors) {
        return numOfUserColors < OrnamentalFishes.colorsArr.length;
    }

    //---------- LION INPUT VALIDATION ----------

    public void isValidPredatorWeight(float weight) throws PredatorWeightException {
        Lion.isValidLionWeight(weight);
    }

    public void isValidLionGender(String gender) throws LionGenderException {
        Lion.isValidGender(gender);
    }

    //---------- penguin input validation ----------

    public void isValidPenguinHeight(float height, boolean isLeader) throws PenguinHeightException {
        Penguins.isValidPenguinHeight(height, isLeader);
    }

}