public class Rocket {
    public static void main(String[] args) {
        //github repo
        //https://github.com/WildingGerald/prog2-ss21-exercise1

        rocketFuelCalculator rocket = new rocketFuelCalculator();
        try{
            rocket.importData("src/main/resources/data");
            rocket.calculateFuel();
            System.out.println(rocket.totalFuel);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
