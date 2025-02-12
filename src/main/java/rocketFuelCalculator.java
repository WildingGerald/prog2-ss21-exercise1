import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class rocketFuelCalculator {
    ArrayList<Integer> modulesMass;
    int totalFuel;

    rocketFuelCalculator(){
        modulesMass = new ArrayList<>();
        totalFuel = 0;
    }
    public ArrayList<Integer> getModulesMass(){
        return  modulesMass;
    }

    public void importData(String path)throws FileNotFoundException {
        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                modulesMass.add(Integer.valueOf(myReader.nextLine()));
            }
            myReader.close();
        }catch (FileNotFoundException e){
            throw new FileNotFoundException();
        }
    }

    public void calculateFuel() throws Exception{
        for (int module :
                modulesMass) {
            totalFuel += calculateFuelForModule(module);
        }
    }

    public int calculateFuelForModule(int mass)throws Exception{
        int requiredFuel;
        if (mass > 9)
        {
            double h =mass / 3d;
            double b =Math.floor(h);
            requiredFuel = (int)b - 2;
        }else{
            throw new Exception("Mass negative or too low to calculate fuel for.");
        }
       return requiredFuel + calculateFuelForFuel(requiredFuel);
    }

    public int calculateFuelForFuel(int fuel) {
        double h = fuel / 3d;
        double b = Math.floor(h);
        int requiredFuel = (int) b - 2;
        if (requiredFuel < 0) {
            return 0;
        }else {
            return requiredFuel + calculateFuelForFuel(requiredFuel);
        }
    }
}
