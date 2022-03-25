import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class TestRocketFuelCalculator {

    rocketFuelCalculator testRocket;
    @BeforeEach
    void setUp(){
        testRocket = new rocketFuelCalculator();
    }

    @Test
    public void testImportData_filepathWrong(){
        try{
            testRocket.importData("wrongPath");
            fail();
        }catch (IOException e){

        }
    }

    @Test
    public void testImportData_pass(){
        try{
            testRocket.importData("/home/adre/IdeaProjects/prog2-ss21-exercise1/src/test/resources/data");
            Assertions.assertTrue(testRocket.modulesMass.contains(91617));
        }catch (FileNotFoundException e){
            fail();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {12 , 14, 1969, 100756})
    public void testCalculateFuel_pass(int in) {
        List expected = Arrays.asList(2, 2, 654, 33583);
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
