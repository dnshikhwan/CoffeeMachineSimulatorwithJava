import java.util.Scanner;

class ManufacturingController {
    // here you may declare a field
    private static int numberOfProduct = 0;

    public static String requestProduct(String product) {
        numberOfProduct++;
        return numberOfProduct + ". Requested " + product;
    }

    public static int getNumberOfProducts() {
        return numberOfProduct;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String product = scanner.nextLine();
            System.out.println(ManufacturingController.requestProduct(product));
            System.out.println(ManufacturingController.getNumberOfProducts());
        }
    }
}