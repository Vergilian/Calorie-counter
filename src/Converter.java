public class Converter {
    public double convertingSteps (double steps){
        steps = steps * 0.0007;
        return Math.round(steps *100.0)/100.0;

    }
    public double convertingCcallories (double steps){
        steps = steps * 0.04;
        return Math.round(steps *100.0)/100.0;

    }
}