package week4;

public class Motherboard {

    static class USB {
        private static final int usb2 = 1;
        private static final int usb3 = 2;

        int getTotalPorts() {
            return usb2 + usb3;
        }
    }
}

class usb2 {

    public static int getTotalPorts() {
        return 1;
    }
}

class usb3 {

    public static int getTotalPorts() {
        return 2;
    }
}

class AksiMotherboard {
    public static void main(String[] args) {
        Motherboard.USB usb = new Motherboard.USB();
        System.out.println("" + usb2.getTotalPorts());
        System.out.println("" + usb3.getTotalPorts());
        System.out.println("Total USB ports = " + usb.getTotalPorts());
    }
}