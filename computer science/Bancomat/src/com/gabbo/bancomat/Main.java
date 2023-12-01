package com.gabbo.bancomat;

import java.util.ArrayList;
import java.util.Random;

public class Main {
  public static void main (String[] args) {
    Atm atm = new Atm();
    ArrayList<User> users = new ArrayList<>();

    final int amountOfUsers = new Random().nextInt(10);
    for (int id = 0; id < amountOfUsers; id++) {
      users.add(new User(atm, id));
      users.get(id).start();
    }
  }
}
