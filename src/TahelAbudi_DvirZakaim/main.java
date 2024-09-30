//ID- Tahel Abudi 324171255, Dvir Zakaim- 207867821

package TahelAbudi_DvirZakaim;


import TahelAbudi_DvirZakaim.exceptions.AgeException;
import TahelAbudi_DvirZakaim.exceptions.GeneralException;
import TahelAbudi_DvirZakaim.exceptions.NameException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class main {
    private static Scanner s = new Scanner(System.in);
    private final static String[] MENU = {
            "Exit Program",
            "Show Zoo",
            "Add Penguin",
            "Add Predator",
            "Add Aquarium fish",
            "Show Penguins",
            "Show Predators",
            "Show Aquarium fish",
            "Feed animals",
            "Listen to animals"
    };

    public static void main(String[] args) {
        Manager manager = new Manager("Akrish's Zoo", "Jerusalem", "Shahal", "83");
        run(manager);
        s.close();
    }

    private static void run(Manager manager) {
        int userChoosen;
        do {
            userChoosen = showMenu();
            switch (userChoosen){
                case 0 -> exitProgram();
                case 1 -> showZoo(manager);
                case 2 -> addPenguin(manager);
                case 3 -> addLion(manager);
                case 4 -> addAquariumFish(manager);
                case 5 -> showPenguins(manager);
                case 6 -> showLions(manager);
                case 7 -> showAquariumFish(manager);
                case 8 -> feedAnimals(manager);
                case 9 -> listenAnimals(manager);
                default -> System.out.println("invalid value");
            }

        } while (userChoosen != 0);
    }

    private static void listenAnimals(Manager manager) {
    }

    private static int showMenu() {
        System.out.println("\nProgram Menu");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ") " + MENU[i]);
        }
        System.out.println("Enter your choice: ");
        int choice = s.nextInt();
        s.nextLine();
        return choice;
    }

    private static void exitProgram() {
        System.out.println("Thank you for visiting my Zoo, see you next time...");
    }

    private static void showZoo(Manager manager) {
        System.out.println(manager);
    }

    private static void addPenguin(Manager manager) {

        while (true){
            try {
                String name = readString("Enter penguin's name: ");
                isValidName(name);

                int age = readInt("Enter penguin's age: ");
                isValidAge(age);

                float height = readFloat("Enter penguin's height: ");
                manager.isValidPenguinHeight(height);

                manager.createPenguin(age, height, name, false);

                return;
            } catch (GeneralException e) {
                System.out.println(e.getMessage());;
            }
        }
    }

//    private static void addLion(Manager manager) {
//
//        String name = readString("Enter lion's name: ");
//        while (!manager.isValidLionName(name)) {
//            name = readString("wrong input,please enter a valid name (at least 2 characters): ");
//        }
//
//        int age = readInt("Enter lion's age: ");
//        while (!manager.isValidLionAge(age)) {
//            age = readInt("wrong input, enter correct age: ");
//        }
//
//        float weight = readFloat("Enter lion's weight: ");
//        while (!manager.isValidLionWeight(weight)) {
//            weight = readFloat("wrong input, enter correct weight: ");
//        }
//
//        String gender = readString("is lion male? (male/female): ");
//        while (!manager.isValidLionGender(gender)) {
//            gender = readString("wrong input, enter correct gender: ");
//        }
//
//        manager.createLion(name, age, weight, gender);
//    }

    private static void addLion(Manager manager) {

        while (true) {
            try {
                String name = readString("Enter lion's name: ");
                isValidName(name);

                int age = readInt("Enter lion's age: ");
                isValidAge(age);

                float weight = readFloat("Enter lion's weight: ");
                manager.isValidPredatorWeight(weight);

                String gender = readString("is lion male? (male/female): ");
                manager.isValidLionGender(gender);

                manager.createLion(name, age, weight, gender);

                return;
            } catch (GeneralException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addAquariumFish(Manager manager) {

        int age = readInt("Enter fish's age: ");
        while (!manager.isValidFishAge(age)) {
            age = readInt("wrong input, enter correct age: ");
        }

        float length = readFloat("Enter fish's length: ");
        while (!manager.isValidFishLength(length)) {
            length = readFloat("wrong input, enter correct length: ");
        }

        String userColor = readString("choose fish's color from the list: \n"
                + Arrays.toString(AquariumFish.colorsArr));

        String[] userColors = new String[AquariumFish.colorsArr.length];
        int numOfUserColors = 0;
        while (!manager.isValidFishColor(userColor)) {
            userColor = readString("wrong color, please enter valid color from this list above: ");
        }
        userColors[numOfUserColors++] = userColor;

        String answer = readString("do you want another color? (y/n): ");
        while (Objects.equals(answer, "y") && manager.canAddFishColor(numOfUserColors)) {
            userColor = readString("Enter another color from the list: ");
            while (!manager.isValidFishColor(userColor)) {
                userColor = readString("wrong color, please enter valid color from this list above: ");
            }
            userColors[numOfUserColors++] = userColor;
            answer = readString("do you want another color? (y/n): ");
        }

        String userPattern = readString("Enter fish's pattern: \n" + Arrays.toString(AquariumFish.patternArr));
        while (!manager.isValidFishPattern(userPattern)) {
            userPattern = readString("invalid pattern, please choose from the list above ");
        }

        userColors = Arrays.copyOf(userColors, numOfUserColors);
        manager.createFish(age, userColors, length, userPattern);
    }

    private static void showPenguins(Manager manager) { System.out.println(manager.getPenguinList()); }

    private static void showLions(Manager manager) { System.out.println(manager.getLionList()); }

    private static void showAquariumFish(Manager manager) { System.out.println(manager.getAquariumFishList()); }

    private static void feedAnimals(Manager manager) {System.out.println(manager.feedAllAnimals()); }

    private static String readString(String text) {
        System.out.println(text);
        return s.nextLine();
    }

    private static float readFloat(String text) {
        System.out.println(text);
        float number = s.nextFloat();
        s.nextLine();
        return number;
    }

    private static int readInt(String text) {
        System.out.println(text);
        int number = s.nextInt();
        s.nextLine();
        return number;
    }

    public static boolean isValidAge(int age) throws AgeException {
        if (age <= 0) {
            throw new AgeException();
        }
        return true;
    }

    public static boolean isValidName(String name) throws NameException {
        if (name == null || name.trim().length() < 2) {
            throw new NameException();
        }
        return true;
    }

}
