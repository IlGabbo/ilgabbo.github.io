package com.gabbo.bancomat;

public class Atm {
  private final Account account;

  public Atm() {
    float defaultBalance = 100;  // €
    this.account = new Account(defaultBalance);
  }

  public synchronized ATMStatus withdraw(float value) {
    account.setBalance(account.getBalance() + value);
    return ATMStatus.SUCCESS;
  }

  public synchronized ATMStatus deposit(float value) {
    if (account.getBalance() < value) {
      return ATMStatus.AMOUNT_EXCEEDS_AVAILABILITY;
    }

    account.setBalance(account.getBalance() - value);
    return ATMStatus.SUCCESS;
  }
}
