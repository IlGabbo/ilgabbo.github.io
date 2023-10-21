package com.gabbo.station;
import com.gabbo.station.EnumState.Status;

import java.util.Random;

public class Train extends Thread {
  private volatile Status status;

  /*
  * Setting crossingState 'waiting' as default
  * */
  public Train() {
    status = Status.waiting;
  }

  /*
  * Getting the train status
  * */
  public Status getStatus() {
    return this.status;
  }

  /*
  * Setting the train status
  * */
  public void setCrossing(Status status) {
    this.status = status;
  }

  @Override
  public void run() {
    int randomWaiting = 0;
    TrainCross train = new TrainCross(this);
    train.start();
    Random rand = new Random();

    while (true) {
      randomWaiting = rand.nextInt(10);
      System.out.println("[LOG] Random Wait " + randomWaiting);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException exc) {
        exc.printStackTrace();
      }

      if (randomWaiting == 0) {
        status = Status.arriving;

        while (status != Status.waiting) {
          try {
            Thread.sleep(1000);
          } catch (InterruptedException exc) {
            /*
            * Ignoring
            * */
          }
        }

        try {
          Thread.sleep(5000);
          System.out.println("[LOG] Train is crossed");
        } catch (InterruptedException exc) {
          /*
          * Ignoring
          * */
        }
      }
    }
  }
}
