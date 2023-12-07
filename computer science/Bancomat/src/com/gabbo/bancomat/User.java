package com.gabbo.bancomat;

import java.util.Random;

public class User extends Thread {
  private Atm atm;
  private int id;

  public User(Atm atm, int id) {
    this.atm = atm;
    this.id = id;
  }

  @Override
  public void run() {
    while (true) {
      try {
        int r = new Random().nextInt(4)*1000;
        Thread.sleep(r);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      int action = new Random().nextInt(2);
      int amount = new Random().nextInt(1000);
      if (action == 0) {
        atm.deposit(amount);
        System.out.println("User with id " + id + " deposited €" + amount);
      }
      if (action == 1) {
        ATMStatus status = atm.withdraw(amount);
        if (status == ATMStatus.AMOUNT_EXCEEDS_AVAILABILITY) {
          System.out.println("User with id " + id + ", Amount Exceeds Availability");
        } else {
          System.out.println("User with id " + id + ": Success, withdrawn €" + amount);
        }
      }
    }
  }
}
