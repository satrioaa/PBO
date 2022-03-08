public class VolumeTabung {
    public static void main(String[] args) {
        double diameter = 5;
        double jariJari = diameter / 2;
        double tinggi = 10;
        double phi = 3.14;
        double volume = phi * jariJari * jariJari * tinggi;
        System.out.println("Volume tabung dengan diameter " + diameter + " dan tinggi " + tinggi + " adalah " + volume);
    }

}