package com.sda.repository;

import com.sda.model.BankAccount;
import com.sda.request.CreateBankAccountRequest;
import java.util.List;
import lombok.NonNull;

public interface BankAccountRepository {

  boolean existsByPesel(@NonNull String pesel);

  BankAccount create(CreateBankAccountRequest request);


  List<BankAccount> findAll();

  void delete(String pesel);

}
