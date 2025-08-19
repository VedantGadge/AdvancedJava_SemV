
//common interface 
interface FurnitureWarehouse {
    void manufacture();
}

//concrete product classes
class Sofa implements FurnitureWarehouse{
    public void manufacture(){
        System.out.println("Making Sofa....");
    }
}

class Chair implements FurnitureWarehouse{
    public void manufacture(){
        System.out.println("Making Chair....");
    }
}

class Table implements FurnitureWarehouse{
    public void manufacture(){
        System.out.println("Making Table....");
    }
}

class Door implements FurnitureWarehouse{
    public void manufacture(){
        System.out.println("Making Door....");
    }
}

//Create Factory classes 
class FurnitureFactory{
    public FurnitureWarehouse getFurniture(String Furniture){
        if(Furniture == null){
            return null;
        }
        if(Furniture.equalsIgnoreCase("Table")){
            return new Table();
        } 
        if(Furniture.equalsIgnoreCase("Sofa")){
            return new Sofa();
        }
        if(Furniture.equalsIgnoreCase("Chair")){
            return new Chair();
        }
        if(Furniture.equalsIgnoreCase("Door")){
            return new Door();
        }
        return null;
    }
}


public class q1 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        FurnitureFactory factory = new FurnitureFactory();
        while (true) {
            System.out.println("\n--- Furniture Manufacturing Menu ---");
            System.out.println("Enter furniture name Table / Sofa / Chair / Door or 'exit' to quit:");
            System.out.print("Furniture name: ");
            String furnitureType = sc.nextLine().trim();
            if (furnitureType.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                sc.close();
                return;
            }
            FurnitureWarehouse furniture = factory.getFurniture(furnitureType);
            if (furniture != null) {
                furniture.manufacture();
            } else {
                System.out.println("Invalid furniture name. Try again.");
            }
        }
    }
}
