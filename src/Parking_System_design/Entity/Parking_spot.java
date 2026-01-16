package Parking_System_design.Entity;

public class Parking_spot {
   private final String spotId;
   private boolean isFree=true;

   public Parking_spot (String spotId) {
      this.spotId = spotId;
   }
   public boolean isSpotFree() {
       return isFree;
   }
   public void occupySpot() {
       isFree = false;
   }
   public void releaseSpot() {
       isFree = true;
   }

    public String getSpotId() {
        return spotId;
    }
}
