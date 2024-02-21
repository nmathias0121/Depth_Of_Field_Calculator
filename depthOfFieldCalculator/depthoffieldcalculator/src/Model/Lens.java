package Model;

public class Lens {
    private String make;
    private double max_aperture;
    private int focal_length;

    public Lens(String make, double max_aperture, int focal_length) {                   //constructor
        this.make = make;
        this.max_aperture = max_aperture;
        this.focal_length = focal_length;
    }

    public String getMake() {                           //return the make of the camera
        return make;
    }

    public void setMake(String make) {                  //set the make to the parameter
        this.make = make;
    }

    public double getMax_aperture() {                   //return the max aperture of the camera
        return max_aperture;
    }

    public void setMax_aperture(double max_aperture) {              //set the max aperture to the parameter
        this.max_aperture = max_aperture;
    }

    public int getFocal_length() {                      //return the focal length of the camera
        return focal_length;
    }

    public void setFocal_length(int focal_length) {             //set the focal length to the parameter
        this.focal_length = focal_length;
    }

    @Override
    public String toString() {
        return "Lens{" +
                "make='" + make + '\'' +
                ", max_aperture=" + max_aperture +
                ", focal_length=" + focal_length +
                '}';
    }


}
