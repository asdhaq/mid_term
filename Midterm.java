package com.mycompany.midterm;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ASDHAQ
 */


public class Midterm {
    

    private static final ArrayList<BloodSugar> bloodSugarRecords = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> create();
                case 2 -> index();
                case 3 -> {
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    view(userId);
                }
                case 4 -> delete();
                case 5 -> exit();
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Create a record");
        System.out.println("2. Show blood sugar data for all users");
        System.out.println("3. Show blood sugar data for a selected user");
        System.out.println("4. Delete all records");
        System.out.println("5. Exit application");
        System.out.print("Enter your choice: ");
    }

    private static void index() {
        System.out.println("Blood Sugar Data for All Users:");
        for (BloodSugar record : bloodSugarRecords) {
            record.display();
        }
    }

    private static void view(int id) {
        for (BloodSugar record : bloodSugarRecords) {
            if (record.getId() == id) {
                record.display();
                return;
            }
        }
        System.out.println("User not found with ID: " + id);
    }

    private static void create() {
        System.out.print("Enter user ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter user's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter year of birth: ");
        int yob = scanner.nextInt();

        System.out.print("Enter blood sugar level: ");
        int sugarLevel = scanner.nextInt();

        BloodSugar newRecord = new BloodSugar(id, name, yob, sugarLevel);
        newRecord.calculate();
        bloodSugarRecords.add(newRecord);

        System.out.println("Record created successfully.");
    }

    private static void delete() {
        bloodSugarRecords.clear();
        System.out.println("All records deleted.");
    }

    private static void exit() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }
}

class BloodSugar {
    private int id;
    private String name;
    private int yob;
    private int sugarLevel;
    private String category;

    public BloodSugar(int id, String name, int yob, int sugarLevel) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.sugarLevel = sugarLevel;
    }

    public void calculate() {
        if (sugarLevel >= 80 && sugarLevel <= 130) {
            category = "Normal";
        } else if (sugarLevel <= 180) {
            category = "Elevated";
        } else {
            category = "High";
        }
    }
    

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yob);
        System.out.println("Sugar Level: " + sugarLevel);
        System.out.println("Category: " + category);
        System.out.println("-------------------------");
    }

    // Implement getters and setters for all properties
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public int getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(int sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
