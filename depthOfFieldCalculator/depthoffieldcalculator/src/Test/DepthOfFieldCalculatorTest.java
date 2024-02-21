package Test;

import Model.DepthOfFieldCalculator;
import Model.DepthOfFieldCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthOfFieldCalculatorTest {
    @Test
    void testHyperFocalDistance() {
        DepthOfFieldCalculator tmp = new DepthOfFieldCalculator();
        assertEquals(47.89, tmp.hyper_focal_distance(50, 1.8), 0.002);
    }

    @Test
    void testNearFocalPoint() {
        DepthOfFieldCalculator tmp = new DepthOfFieldCalculator();
        assertEquals(1.96, tmp.near_focal_point(90, 2.8, 2), 0.002);
    }

    @Test
    void testFarFocalPoint() {
        DepthOfFieldCalculator tmp = new DepthOfFieldCalculator();
        assertEquals(1.10, tmp.far_focal_point(50, 8, 1), 0.002);
    }

    @Test
    void testDepthOfField() {
        DepthOfFieldCalculator tmp = new DepthOfFieldCalculator();
        assertEquals(0.18, tmp.depthOfField(50, 8, 1), 0.002);
    }
}