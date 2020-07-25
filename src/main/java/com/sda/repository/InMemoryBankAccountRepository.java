package com.sda.repository;

import com.sda.model.BankAccount;
import com.sda.request.CreateBankAccountRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import lombok.NonNull;

public class InMemoryBankAccountRepository implements BankAccountRepository {

  private static InMemoryBankAccountRepository repository;

  public static InMemoryBankAccountRepository getInstance() {
    if (repository == null) {
      repository = new InMemoryBankAccountRepository();
    }
    return repository;
  }

  private List<BankAccount> bankAccounts;

  private InMemoryBankAccountRepository() {
    bankAccounts = new ArrayList<>();
  }

  @Override
  public boolean existsByPesel(@NonNull String pesel) {
    return bankAccounts.stream()
        .anyMatch(b -> b.getPesel().equalsIgnoreCase(pesel));
  }

  @Override
  public BankAccount create(CreateBankAccountRequest request) {
    Random random = new Random();
    Long accountNumber = random.nextLong();
    BankAccount bankAccount = new BankAccount(request.getPesel(), accountNumber.toString(), request.getInitValue());
    bankAccounts.add(bankAccount);
    return bankAccount;
  }


  @Override
  public List<BankAccount> findAll() {
    return Collections.unmodifiableList(bankAccounts);
  }

  @Override
  public void delete(String pesel) {
    bankAccounts.stream().filter(ba->ba.getPesel().equals(pesel))
            .findFirst()
            .ifPresent(ba-> bankAccounts.remove(ba));

  }
}
