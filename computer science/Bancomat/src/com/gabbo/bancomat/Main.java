package com.gabbo.bancomat;

import java.util.ArrayList;
import java.util.Random;

public class Main {
  public static void main (String[] args) {
    Atm atm = new Atm();
    ArrayList<User> users = new ArrayList<>();

    final int amountOfUsers = new Random().nextInt(10);
    for (int userId = 0; userId < amountOfUsers; userId++) {
      users.add(new User(atm, userId));
      users.get(userId).start();
    }
  }
}
