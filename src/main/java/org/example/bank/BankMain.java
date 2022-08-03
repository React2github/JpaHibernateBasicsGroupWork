package org.example.bank;

import org.example.bank.model.BankAccount;
import org.example.bank.model.UserInputImplement;
import org.example.bank.service.UserInputInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BankMain {
    public static void main(String[] args) {
        UserInputInterface userInputInterface = new UserInputImplement();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        BankAccount bankAccount1 = entityManager
//                createNativeQuery("SELECT * FROM BANKACCOUNT WHERE ACCOUNTNAME=:accountname", BankAccount.class);
        System.out.println(bankAccount1.getAccountName());
        System.out.println(bankAccount1.getAccountBalance());


        String depositResponse = userInputInterface.receiveStringInput("Do you want to make a deposit? (y/n)");
        if (depositResponse.equalsIgnoreCase("y")) {
            System.out.println("Account Name: " + bankAccount1.getAccountName());
            System.out.println("Account Balance: " + bankAccount1.getAccountBalance());
            System.out.println("________________");
            int userDeposit = userInputInterface.receiveIntInput("How much do you want to deposit? (number)");
            Double userDepositDouble = (double) userDeposit;
            System.out.println("Starting Balance: " + bankAccount1.getAccountBalance());
            System.out.println("Deposit Amount: " + userDepositDouble);
            Double newAccountBalance = bankAccount1.getAccountBalance() + userDepositDouble;
            System.out.println("New Balance: " + newAccountBalance);

            bankAccount1.setAccountBalance(newAccountBalance);
            transaction.begin();
            entityManager.persist(bankAccount1);
            transaction.commit();
        }

        String withdrawalResponse = userInputInterface.receiveStringInput("Do you want to make a withdrawal? (y/n)");
        if (withdrawalResponse.equalsIgnoreCase("y")) {
            System.out.println("Account Name: " + bankAccount1.getAccountName());
            System.out.println("Account Balance: " + bankAccount1.getAccountBalance());
            System.out.println("________________");
            int userWithdrawal = userInputInterface.receiveIntInput("How much do you want to withdrawal? (number)");
            Double userWithdrawalDouble = (double) userWithdrawal;
            System.out.println("Starting Balance: " + bankAccount1.getAccountBalance());
            System.out.println("Deposit Amount: " + userWithdrawalDouble);
            Double newAccountBalance = bankAccount1.getAccountBalance() - userWithdrawalDouble;
            // Alter math to not let user go below certain number
            System.out.println("New Balance: " + newAccountBalance);


            bankAccount1.setAccountBalance(newAccountBalance);
            transaction.begin();
            entityManager.persist(bankAccount1);
            transaction.commit();
        }

        // New Bank account
        String createAccountResponse = userInputInterface.receiveStringInput("Do you want to create a new account? (y/n)");
        if (createAccountResponse.equalsIgnoreCase("y")) {
            String newAccountName = userInputInterface.receiveStringInput("What is your account name?");
            String newAccountAddress = userInputInterface.receiveStringInput("What is your account address?");
            int newAccountInitialDeposit = userInputInterface.receiveIntInput("How much do you want to initially deposit?");
            Double newAccountInitialDepositAsDouble = (double) newAccountInitialDeposit;

            BankAccount newBankAccount = new BankAccount();
            newBankAccount.setAccountName(newAccountName);
            newBankAccount.setAccountAddress(newAccountAddress);
            newBankAccount.setAccountBalance(newAccountInitialDepositAsDouble);


            transaction.begin();
            entityManager.persist(newBankAccount);
            transaction.commit();
        }
    }
}