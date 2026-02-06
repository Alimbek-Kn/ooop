package assignment;

import java.util.Scanner;

public class MenuManager implements Menu {

    private Scanner scanner = new Scanner(System.in);
    private StaffDAO dao = new StaffDAO();

    @Override
    public void displayMenu() {
        System.out.println("\n HOSPITAL MANAGEMENT MENU ");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Nurse");
        System.out.println("3. View All Staff");
        System.out.println("4. Delete Staff");
        System.out.println("5. Update Staff Experience");
        System.out.println("6. Search Staff by Name");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choose option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addDoctor();
                    case 2 -> addNurse();
                    case 3 -> dao.getAllStaff().forEach(System.out::println);
                    case 4 -> deleteStaff();
                    case 5 -> updateExperience();
                    case 6 -> searchByName();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Input error!");
                scanner.nextLine();
            }
        }
    }

    private void addDoctor() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Experience: ");
            int exp = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Specialization: ");
            String spec = scanner.nextLine();

            dao.addStaff(new Doctor(id, name, exp, spec));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addNurse() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Experience: ");
            int exp = scanner.nextInt();
            scanner.nextLine();

            dao.addStaff(new Nurse(id, name, exp, false));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteStaff() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        dao.deleteStaff(id);
    }

    private void updateExperience() {
        System.out.print("Enter staff ID: ");
        int id = scanner.nextInt();

        System.out.print("New experience: ");
        int exp = scanner.nextInt();

        dao.updateExperience(id, exp);
    }

    private void searchByName() {
        System.out.print("Enter name to search: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        dao.searchByName(name);
    }
}
