package DesignPatterns;

public class Singleton {
    public static void main(String[] args) {
        WaterJug person1 = WaterJug.getInstance();
        WaterJug person2 = WaterJug.getInstance();

        System.out.println("Are both persons same? " + (person1 == person2));
        System.out.println("Initial water Quantity: " + person1.getWaterQuantity());

        int waterFor1 = person1.getWater(1500);
        System.out.println("Remaining water quantity: " + person1.getWaterQuantity());

        int waterFor2 = person2.getWater(2000);
        System.out.println("Remaining water quantity: " + person2.getWaterQuantity());
    }
}

class WaterJug {
    private int waterQuantity = 5000;
    public static WaterJug object = null;
    private WaterJug() {}

    public int getWater(int quantity) {
        if (quantity > waterQuantity) {
            int available = waterQuantity;
            waterQuantity = 0;
            return waterQuantity;
        }
        waterQuantity = waterQuantity - quantity;
        return quantity;
    }

    public int getWaterQuantity() {
        return waterQuantity;
    }

    public static WaterJug getInstance() {
        if (object == null) {
            object = new WaterJug();
        }

        return object;
    }
}
