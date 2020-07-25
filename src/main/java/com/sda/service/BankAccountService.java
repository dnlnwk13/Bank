package com.sda.service;

import com.sda.model.BankAccount;
import com.sda.repository.BankAccountRepository;
import com.sda.request.CreateBankAccountRequest;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BankAccountService {

  private BankAccountRepository repository;

  public Optional<BankAccount> createBankAccount(CreateBankAccountRequest request) {
    boolean exists = repository.existsByPesel(request.getPesel());
    if (exists) {
      return Optional.empty();
    }
    return Optional.of(repository.create(request));
  }

  public List<BankAccount> findAll() {
    return repository.findAll();
  }

}
