package com.gabbo.station;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Train train = new Train();
    train.start();

    System.out.println("Press 'p' to exit");
    Thread main = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          String inp = kb.next();

          if (inp.charAt(0) == 'p') {
            /*
            * Interrupts the train thread and exits
            * */
            train.interrupt();
            System.exit(0);
          }
        }
      }
    });

    main.start();
  }
}
