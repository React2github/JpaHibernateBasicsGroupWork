package org.example.bank.model;
import org.example.bank.service.UserInputInterface;
import java.util.Scanner;

public class UserInputImplement implements UserInputInterface {

    Scanner scanner;

    public UserInputImplement() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String receiveStringInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    @Override
    public int receiveIntInput(String prompt) {
        System.out.println(prompt);
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;

    }


}
