public class rocketFuelCalculator {


    public int calculateFuel(int mass)throws Exception{
        int requiredFuel;
        if (mass > 9)
        {
            double h =mass / 3d;
            double b =Math.floor(h);
            requiredFuel = (int)b - 2;
        }else{
            throw new Exception("Mass negative or too low to calculate fuel for.");
        }
       return requiredFuel;
    }
}
