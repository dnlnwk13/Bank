package com.sda;

import com.sda.model.BankAccount;
import com.sda.repository.InMemoryBankAccountRepository;
import com.sda.request.CreateBankAccountRequest;
import com.sda.service.BankAccountService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

  private static final String ONE = "1";

  private static final String TWO = "2";

  private static final String THREE = "3";

  public static void main(String[] args) {
    BankAccountService service = new BankAccountService(InMemoryBankAccountRepository.getInstance());
    printMainMenu();
    Scanner scanner = new Scanner(System.in);
    String userChoice = scanner.next();
    while (userChoice.equals(ONE) || userChoice.equals(TWO)) {
      if (userChoice.equals(ONE)) {
        createBankAccount(service, scanner);
      }

      else {
        printAllBankAccounts(service);
      }
      printMainMenu();
      userChoice = scanner.next();
    }
  }

  private static void createBankAccount(BankAccountService service, Scanner scanner) {
    System.out.print("Pesel : ");
    String pesel = scanner.next();
    System.out.println();
    CreateBankAccountRequest request = new CreateBankAccountRequest(pesel, BigDecimal.ZERO);
    Optional<BankAccount> bankAccount = service.createBankAccount(request);
    if (bankAccount.isEmpty()) {
      System.out.println("Account with given pesel already exists!");
    } else {
      System.out.println("Done!");
    }
  }

  private static void printAllBankAccounts(BankAccountService service) {
    List<BankAccount> bankAccounts = service.findAll();
    bankAccounts.forEach(ba -> {
      System.out.print("Pesel : " + ba.getPesel());
      System.out.print(" Account number : " + ba.getAccountNumber());
      System.out.print(" Account balance : " + ba.getValue());
      System.out.println();
    });
  }

  private static void printMainMenu() {
    System.out.println("What you would like to do ? ");
    System.out.println("1.Create bank account - press 1");
    System.out.println("2.Show all acounts - press 2");
    System.out.println("3. For exit - any other sign !");

  }


}
