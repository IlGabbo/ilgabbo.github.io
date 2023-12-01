package com.gabbo.bancomat;

public class Account {
  private float balance;

  public Account(float balance) {
    this.balance = balance;
  }

  public void setBalance(float val) {
    this.balance = val;
  }
  public float getBalance() {
    return this.balance;
  }
}
