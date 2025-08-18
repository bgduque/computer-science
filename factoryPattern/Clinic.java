package factoryPattern;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Clinic {
    public static void main(String[] args){
        Pet pet = null;

        try {
            int choice;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("[1] Dog");
                System.out.println("[2] Cat");
                System.out.println("[3] Exit");
                System.out.print("\nChoose your pet number: ");
                choice = sc.nextInt();

                if (choice == 3) {
                    System.out.println("Thank you for visiting the clinic!");
                    break;
                }
                
                PetRecord pFile = new PetRecord();

                switch (choice) {
                    case 1:
                        pet = new Dog();
                        pFile.setPetId("D01");
                        pFile.setPetName("Bantay");
                        pFile.setPet(pet);
                        ((Dog) pet).setBreed("German Shepperd");
                        break;
                    case 2:
                        pet = new Cat();
                        pFile.setPetId("C01");
                        pFile.setPetName("Muning");
                        pFile.setPet(pet);
                        ((Cat) pet).setNoOfLives(9);
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                        break;
                }

                System.out.println("Pet id is " + pFile.getPetId());
                System.out.println("Pet name is " + pFile.getPetName());
                System.out.println("Pet kind: " + pFile.getPet().getClass().getSimpleName());
                System.out.println("Communication sound: " + pFile.getPet().makeSound());
                System.out.println("Play mode: " + pFile.getPet().play());

                if (pet instanceof Dog) {
                    System.out.println("Breed: " + ((Dog) pet).getBreed());
                } else if (pet instanceof Cat) {
                    System.out.println("No. of lives: " + ((Cat) pet).getNoOfLives());
                    
                }
            } while (choice != 3);
                sc.close();
            
        } catch (InputMismatchException iM) { 
            System.out.println("Invalid input. Please try again.");
        }
    }
}