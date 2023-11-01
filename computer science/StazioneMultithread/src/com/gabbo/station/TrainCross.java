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
        System.out.println("Train is arriving\n" +
                "Barrier down\n" +
                "Red light\n");
        Thread.sleep(1000);

        /*
        * Set crossing status to crossing
        * */
        train.setCrossing(Status.crossing);
        System.out.println("Train is crossing\n" +
                "Barrier down\n" +
                "Red light\n");

        Thread.sleep(5000);
        /*
        * Set crossing status to waiting
        * */
        train.setCrossing(Status.waiting);
        System.out.println("Train has crossed\n" +
                "Barrier up\n" +
                "Green light\n");
      } catch (InterruptedException exception) {
        System.out.println("Nothing to do");
      }
    }
  }
}
