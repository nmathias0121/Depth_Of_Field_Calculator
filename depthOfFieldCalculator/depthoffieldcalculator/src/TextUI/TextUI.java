package TextUI;

import Model.Lens;
import Model.LensManager;
import Model.DepthOfFieldCalculator;

import java.text.DecimalFormat;
import java.util.Scanner;


public class TextUI {
    private static final double COC = 0.029;    // "Circle of Confusion" for a "Full Frame" camera
    private LensManager manager;
    private Scanner input = new Scanner(System.in);// Read from keyboard


    public TextUI(LensManager manager) {
        // Accept and store a reference to the lens manager (the model)
        // (this design is called "dependency injection")
        this.manager = manager;

        // Populate lenses (Make, max aperture (smallest supported F number), focal length [mm]):
        manager.add(new Lens("Canon", 1.8, 50));
        manager.add(new Lens("Tamron", 2.8, 90));
        manager.add(new Lens("Sigma", 2.8, 200));
        manager.add(new Lens("Nikon", 4, 200));
    }

    public void show() {
        System.out.println("Lenses to pick from:\n");
        System.out.println("0. Canon 50mm F1.8\n");
        System.out.println("1. Tamron 90mm F2.8\n");
        System.out.println("2. Sigma 200mm F2.8\n");
        System.out.println("3. Nikon 200mm F4.0\n");
        System.out.println("(-1 to exit)\n");
        System.out.println(": ");

        int value = input.nextInt();
        double aperture = 0;
        double distance;
        int focal_length = 0;
        DepthOfFieldCalculator tmp = new DepthOfFieldCalculator();

        switch (value) {
            case -1:
                return;
            case 0:
                System.out.println("Aperture [the F number]: ");
                aperture = input.nextDouble();
                if (aperture < 1.8) {
                    System.out.println("ERROR: This aperture is not possible with this lens\n");
                    return;
                }
                focal_length = 50;
                break;
            case 1:
                System.out.println("Aperture [the F number]: ");
                aperture = input.nextDouble();
                if (aperture < 2.8) {
                    System.out.println("ERROR: This aperture is not possible with this lens\n");
                    return;
                }
                focal_length = 90;
                break;
            case 2:
                System.out.println("Aperture [the F number]: ");
                aperture = input.nextDouble();
                if (aperture < 2.8) {
                    System.out.println("ERROR: This aperture is not possible with this lens\n");
                    return;
                }
                focal_length = 200;
                break;
            case 3:
                System.out.println("Aperture [the F number]: ");
                aperture = input.nextDouble();
                if (aperture < 4.0) {
                    System.out.println("ERROR: This aperture is not possible with this lens\n");
                    return;
                }
                focal_length = 200;
                break;
            default:
                System.out.println("Error: Invalid lens index.\n");
                return;
        }

        System.out.println("Distance to subject [m]: ");
        distance = input.nextDouble();
        System.out.println(" In focus: " + formatM(tmp.near_focal_point(focal_length, aperture, distance)) + " to " + formatM(tmp.far_focal_point(focal_length, aperture, distance)) + " [DoF = " + formatM(tmp.depthOfField(focal_length, aperture, distance)) + "]\n" +
                " Hyperfocal point: " + formatM(tmp.hyper_focal_distance(focal_length, aperture)));
    }

    private String formatM(double distanceInM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }
}