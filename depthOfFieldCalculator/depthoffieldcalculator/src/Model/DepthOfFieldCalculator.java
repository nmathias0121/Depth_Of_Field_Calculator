package Model;

import java.text.DecimalFormat;

public class DepthOfFieldCalculator {
    private static final double COC = 0.029;

    public DepthOfFieldCalculator() {
    }

    private String formatM(double distanceInM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }

    public double hyper_focal_distance(int focal_length, double aperture) {
        double hf_distance = (focal_length * focal_length) / (aperture * (COC));

        return Double.parseDouble(formatM(hf_distance / 1000));
    }

    public double near_focal_point(int focal_length, double aperture, double distance_to_subject) {
        double nf_point = (hyper_focal_distance(focal_length, aperture) * distance_to_subject) / (hyper_focal_distance(focal_length, aperture) + (distance_to_subject) - (focal_length / 1000));

        return Double.parseDouble(formatM(nf_point));
    }

    public double far_focal_point(int focal_length, double aperture, double distance_to_subject) {
        double ff_point = (hyper_focal_distance(focal_length, aperture) * distance_to_subject) / (hyper_focal_distance(focal_length, aperture) - (distance_to_subject) + (focal_length / 1000));

        return Double.parseDouble(formatM(ff_point));
    }

    public double depthOfField(int focal_length, double aperture, double distance_to_subject) {
        double depth_of_field = far_focal_point(focal_length, aperture, distance_to_subject) - near_focal_point(focal_length, aperture, distance_to_subject);

        return Double.parseDouble(formatM(depth_of_field));
    }
}
