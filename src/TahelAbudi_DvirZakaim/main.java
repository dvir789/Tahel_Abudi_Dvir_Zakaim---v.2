//ID- Tahel Abudi 324171255, Dvir Zakaim- 207867821

package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.GeneralException;

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
            switch (userChoosen) {
                case 0 -> exitProgram();
                case 1 -> showZoo(manager);
                case 2 -> addPenguin(manager);
                case 3 -> addPredator(manager);
                case 4 -> addAquariumFish(manager);
                case 5 -> showPenguins(manager);
                case 6 -> showPredators(manager);
                case 7 -> showAquariumFish(manager);
                case 8 -> feedAnimals(manager);
                case 9 -> listenAnimals(manager);
                default -> System.out.println("invalid value");
            }

        } while (userChoosen != 0);
    }

    private static int showMenu() {
        System.out.println("\nProgram Menu");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ") " + MENU[i]);
        }
        return readInt("Enter your choice: ");
    }

    private static void exitProgram() {
        System.out.println("Thank you for visiting my Zoo, see you next time...");
    }

    private static void showZoo(Manager manager) {
        System.out.println(manager);
    }

    private static void addPenguin(Manager manager) {
        while (true) {
            try {
                String name = readString("Enter penguin's name: ");
                Validation.validateName(name);

                int age = readInt("Enter penguin's age: ");
                Validation.validateAge(age);

                float height = readFloat("Enter penguin's height: ");
                manager.validatePenguinHeight(height, false);

                manager.createPenguin(age, height, name, false);

                return;
            } catch (GeneralException e) {
                System.out.println(e.getMessage());;
            }
        }
    }
    // add predator menu
    private static void addPredator(Manager manager) {
        int userChoice;
        do {
            userChoice = readInt("enter 1 for lion, 2 for tiger, 3 to return to the menu: ");
            switch (userChoice) {
                case 1 -> addLion(manager);
                case 2 -> addTiger(manager);
                case 3 -> { }
                default -> System.out.println("invalid value: ");
            }
        } while (userChoice > 3 || userChoice < 1);
    }

    private static void addLion(Manager manager) {
        while (true) {
            try {
                String name = readString("Enter lion's name: ");
                Validation.validateName(name);

                int age = readInt("Enter lion's age: ");
                Validation.validateAge(age);

                float weight = readFloat("Enter lion's weight: ");
                manager.validatePredatorWeight(weight);

                String gender = readString("is lion male? (male/female): ");
                manager.validateLionGender(gender);

                manager.createLion(name, age, weight, gender);

                return;
            } catch (GeneralException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addTiger(Manager manager) {
        while (true) {
            try {
                String name = readString("Enter tiger's name: ");
                Validation.validateName(name);

                int age = readInt("Enter tiger's age: ");
                Validation.validateAge(age);

                float weight = readFloat("Enter tiger's weight: ");
                manager.validatePredatorWeight(weight);

                String gender = readString("is tiger male? (male/female): ");
                manager.validateLionGender(gender);

                manager.createTiger(name, age, weight, gender);

                return;
            } catch (GeneralException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addAquariumFish(Manager manager) {
        while (true){
            try {
                String type = readString("Choose the fish's type (Gold Fish/ Clown Fish/ Ornamental Fish): ");
                manager.validateFishType(type);

                int age = readInt("Enter fish's age: ");
                Validation.validateAge(age);

                float length = readFloat("Enter fish's length: ");
                manager.validateFishLength(length);
                //creating a color string that contains the colors by the fish's type
                String[] fishColors = manager.getFishAvailableColors(type);
                //creating a color string for the fish that chosen by the user
                String userColor = readString("choose fish's color from the list: \n"
                        + Arrays.toString(fishColors)).toUpperCase().trim();
                //validate if the color the user enters is a valid color
                String[] userColors = new String[fishColors.length];
                int numOfUserColors = 0;
                manager.validateFishColor(type, userColor);
                userColors[numOfUserColors++] = userColor.toUpperCase().trim();

                String answer = readString("do you want another color? (y/n): ");
                while (Objects.equals(answer, "y")) {
                    if ( numOfUserColors >= userColors.length) {
                        System.out.println("Exceeded color amount");
                        break;
                    }
                    userColor = readString("Enter another color from the list: ").toUpperCase().trim();
                    manager.validateFishColor(type, userColor);
                    userColors[numOfUserColors++] = userColor;
                    answer = readString("do you want another color? (y/n): ");
                }

                String[] fishPattern = manager.getFishPattern(type);
                String userPattern = readString("Enter fish's pattern: \n" + Arrays
                        .toString(fishPattern)).toUpperCase().trim();
                manager.validateFishPattern(userPattern);

                userColors = Arrays.copyOf(userColors, numOfUserColors);
                manager.createFish(age, length, type, userColors, userPattern);
                return;
            }
            catch (GeneralException e) {
                System.out.println(e.getMessage());;
            }
        }
    }

    private static void showPenguins(Manager manager) { System.out.println(manager.getPenguinList()); }

    private static void showPredators(Manager manager) {
        System.out.println(manager.getLionList() + "\n" + manager.getTigerList());
    }

    private static void showAquariumFish(Manager manager) { System.out.println(manager.getAquariumFishList()); }

    private static void feedAnimals(Manager manager) {System.out.println(manager.feedAllAnimals()); }

    private static void listenAnimals(Manager manager) {
        System.out.println(manager.makeNoise());
    }

    //---------- UTILITY ----------

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

}
