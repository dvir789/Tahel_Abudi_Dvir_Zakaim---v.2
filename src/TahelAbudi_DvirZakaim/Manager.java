package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.*;
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

    private AquariumFish[] AquariumFishPack;
    private int AquariumFishCount;

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
        AquariumFishPack = new AquariumFish[1];
        addRandomFish(10);
    }

    private Map<String, String[]> getFishColors() {
        Map<String, String[]> colorsArray = new HashMap<>();

        colorsArray.put("Gold Fish", GoldFish.availableColors);
        colorsArray.put("Clown Fish", ClownFish.availableColors);
        colorsArray.put("Ornamental Fish", AquariumFish.colorsArr);

        return colorsArray;
    }

    private Map<String, String[]> getFishPattern() {
        Map<String, String[]> patternArray = new HashMap<>();

        patternArray.put("Gold Fish", GoldFish.validPattern);
        patternArray.put("Clown Fish", ClownFish.validPattern);
        patternArray.put("Ornamental Fish", AquariumFish.patternArr);

        return patternArray;
    }

    private void addRandomFish(int amount) {
        Random r = new Random();
        Map<String, String[]> colorsArray = getFishColors();
        Map<String, String[]> patternArray = getFishPattern();
        int age, typeSize = AquariumFish.Type.length;
        String[] fishColor;
        String fishPattern;
        String fishType;
        float length;
        int colorRandomNumber, patternRandomNumber, typeRandomNumber;

        for (int i = 0; i < amount; i++) {
            age = r.nextInt(15) + 1;
            length = r.nextFloat(10) + 1;
            typeRandomNumber = r.nextInt(typeSize);
            fishType = AquariumFish.Type[typeRandomNumber];

            colorRandomNumber = r.nextInt(colorsArray.get(fishType).length);
            fishColor = new String[]{colorsArray.get(fishType)[colorRandomNumber]};

            patternRandomNumber = r.nextInt(patternArray.get(fishType).length);
            fishPattern = patternArray.get(fishType)[patternRandomNumber];

            try {
                createFish(age, length, fishType, fishColor, fishPattern);
            } catch (GeneralException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createFish(int age, float length, String type, String[] colors, String pattern) throws GeneralException{
        AquariumFish fish = switch (type) {
            case "Gold Fish" -> new GoldFish(age, length, colors, pattern);
            case "Clown Fish" -> new ClownFish(age, length, colors, pattern);
            case "Ornamental Fish" -> new OrnamentalFish(age, length, colors, pattern);
            default -> null;
        };

        if (fish != null) {
            addFish(fish);
        }
    }

    private void addFish(AquariumFish fish) {
        if (AquariumFishCount >= AquariumFishPack.length) {
            AquariumFishPack = Arrays.copyOf(AquariumFishPack, AquariumFishPack.length * 2);
        }
        AquariumFishPack[AquariumFishCount++] = fish;
    }

    public String getAquariumFishList() {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> colorsCount;
        String[] uniqueColors = new String[AquariumFishCount * 10];
        int[] colorCount = new int[AquariumFishCount * 10];
        numOfUniqueColors = 0;

        for (int i = 0; i < AquariumFishCount - 1; i++) {
            sb.append(AquariumFishPack[i].toString());
            sb.append(",\n");
        }
        sb.append(AquariumFishPack[AquariumFishCount - 1].toString());
        sb.append("\nThere are ").append(AquariumFishCount).append(" fishes in the aquarium\n");

        for (int i = 0; i < AquariumFishCount; i++) {
            String[] fishColors = AquariumFishPack[i].getColors();
            for (String color : fishColors) {
                boolean isColorFound = false;
                for (int j = 0; j < numOfUniqueColors; j++) {
                    if (uniqueColors[j] != null && uniqueColors[j].equals(color)) {
                        colorCount[j]++;
                        isColorFound = true;
                        break;
                    }
                }
                if (!isColorFound){
                    uniqueColors[numOfUniqueColors] = color;
                    colorCount[numOfUniqueColors] = 1;
                    numOfUniqueColors++;
                }
            }
        }
        String mostFrequentColor = null;
        int maxCount = 0;
        for (int i = 0; i < numOfUniqueColors; i++) {
            if (colorCount[i] > maxCount) {
                maxCount = colorCount[i];
                mostFrequentColor = uniqueColors[i];
            }
        }
        if (mostFrequentColor != null) {
            sb.append("The most frequent color is: ").append(mostFrequentColor)
                    .append(" (appears ").append(maxCount).append(" times)\n");
        } else {
            sb.append("No colors found.\n");
        }
        return sb.toString();
    }

//    public String getAquariumFishList() {
//        StringBuilder sb = new StringBuilder();
//        String[] uniqueColors = new String[1];
//        numOfUniqueColors = 0;
//
//        for (int i = 0; i < AquariumFishCount - 1; i++) {
//            sb.append(AquariumFishPack[i].toString());
//            sb.append(",\n");
//        }
//        sb.append(AquariumFishPack[AquariumFishCount - 1].toString());
//        sb.append("\nThere are ").append(AquariumFishCount).append(" fishes in the aquarium\n");
//
//        for (int i = 0; i < AquariumFishCount; i++) {
//            String[] fishColors = AquariumFishPack[i].getColors();
//            for (String color : fishColors) {
//                uniqueColors = isUniqueColor(uniqueColors, color);
//            }
//        }
//
//        uniqueColors = Arrays.copyOf(uniqueColors, numOfUniqueColors);
//        sb.append(Arrays.toString(uniqueColors));
//
//        return sb.toString();
//    }

    private int getFishNum(String type) {
        int counter = 0;
        for (int i = 0; i < AquariumFishCount; i++) {
            if(Objects.equals(AquariumFishPack[i].getType(), type)) {
                counter++;
            }
        }
        return counter;
    }


    public String[] isUniqueColor(String[] uniqueColors, String color) {
        if (Arrays.toString(uniqueColors).toLowerCase().contains(color.toLowerCase())) {
            return uniqueColors;
        }

        while (numOfUniqueColors >= uniqueColors.length) {
            uniqueColors = Arrays.copyOf(uniqueColors, uniqueColors.length * 2);
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
        return AquariumFish.isValidAge(age);
    }

    public boolean isValidFishColor(String userColor) {
        return AquariumFish.isValidColor(userColor);
    }

    public boolean isValidFishLength(float length) {
        return AquariumFish.isValidLength(length);
    }

    public boolean isValidFishPattern(String userPattern) {
        return AquariumFish.isValidPattern(userPattern);
    }

    public boolean canAddFishColor(int numOfUserColors) {
        return numOfUserColors < AquariumFish.colorsArr.length;

    }

    public boolean isValidFishType(String userType) {
        return AquariumFish.isValidType(userType);
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