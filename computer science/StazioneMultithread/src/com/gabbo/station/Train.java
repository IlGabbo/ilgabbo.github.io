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
    Random rand = new Random();
    TrainCross traincross = new TrainCross(this);
    traincross.start();

    while (true) {
      randomWaiting = rand.nextInt(10);
      System.out.println("[LOG] Random $> " + randomWaiting);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException exc) {
        exc.printStackTrace();
      }

      if (randomWaiting == 0) {
        status = Status.arriving;

        /*
        * To interrupt number generation
        * */
        while (status != Status.waiting) {
          try {
            Thread.sleep(1000);
          } catch (InterruptedException exc) {
            /* N/A */
          }
        }
      }
    }
  }
}
