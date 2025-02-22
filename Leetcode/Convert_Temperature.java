public class Convert_Temperature {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius+273.15,celsius*1.80 + 32.00};
    }
}
