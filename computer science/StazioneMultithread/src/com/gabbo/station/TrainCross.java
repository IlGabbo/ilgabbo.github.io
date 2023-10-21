package com.gabbo.station;
import com.gabbo.station.EnumState.Status;

public class TrainCross extends Thread {
  private Train train;

  public TrainCross(Train train) {
    this.train = train;
  }

  @Override
  public void run() {
    while (true) {
      while (train.getStatus() != Status.arriving) {
        try {
          Thread.sleep(1500);
        } catch (InterruptedException exception) {
          exception.printStackTrace();
        }
      }

      try {
        /*
         * Print status
         * */
        System.out.println("Train is arriving");
        System.out.println("The barrier is down");
        System.out.println("Light red");
        System.out.println();
        Thread.sleep(1000);

        /*
        * Set crossing status to crossing
        * */
        train.setCrossing(Status.crossing);
        System.out.println("Train is crossing");
        System.out.println("The barrier is down");
        System.out.println("Light red");
        System.out.println();

        /*
        * Set crossing status to waiting
        * */
        train.setCrossing(Status.waiting);
        System.out.println("Crossing is waiting for a train");
        System.out.println("Barrier up");
        System.out.println("Light green");
        System.out.println();
      } catch (InterruptedException exception) {
        System.out.println("Nothing to do");
      }
    }
  }
}
