package com.sda.request;

import java.math.BigDecimal;
import lombok.NonNull;
import lombok.Value;

@Value
public class CreateBankAccountRequest {

  @NonNull
  private String pesel;

  @NonNull
  private BigDecimal initValue;

}
