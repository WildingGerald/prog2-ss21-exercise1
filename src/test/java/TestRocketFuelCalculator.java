import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class TestRocketFuelCalculator {

    rocketFuelCalculator testRocket;
    @BeforeEach
    void setUp(){
        testRocket = new rocketFuelCalculator();
    }

    @ParameterizedTest
    @ValueSource(ints = {12 , 14, 1969, 100756})
    public void testCalculateFuel_works(int in) {
        List expected = Arrays.asList(new int[]{4, 4, 654, 33583});
        try {
            Assertions.assertTrue(expected.contains(testRocket.calculateFuel(in)));
        }catch (Exception e){
            fail();
        }
    }
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 5})
    public void testCalculateFuel_massNegativeTooLow(int in){
        try{
            testRocket.calculateFuel(in);
            fail();
        }catch (Exception e){
            Assertions.assertTrue(e.getMessage().equalsIgnoreCase("Mass negative or too low to calculate fuel for."));
        }
    }
}
