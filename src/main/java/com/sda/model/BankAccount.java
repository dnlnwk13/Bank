package com.sda.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BankAccount {

  private final String pesel;
  private final String accountNumber;
  private BigDecimal value;


  public void add(BigDecimal amount)
  {
    value = value.add(amount);
  }
}
