import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] menu = {
            "Carbonara",
            "Fries",
            "Burger",
            "Ala King Fillet",
            "Muffin"
        };

        double[] price = {120, 69, 75, 99, 40};

        int totalItems = 0;
        double totalAmount = 0;
        double totalDiscount = 0;

        System.out.println("===== DEBUG YOUR GUT CANTEEN =====");

        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %-16s - Php %.2f%n",
                    i + 1, menu[i], price[i]);
        }

        System.out.println("=================================");

        String choice = "Y";

        while (choice.equalsIgnoreCase("Y")) {

            System.out.print("\nEnter item number: ");
            int itemNumber = scanner.nextInt();

            if (itemNumber < 1 || itemNumber > menu.length) {
                System.out.println(
                        "Invalid item number! Please choose from 1 to "
                        + menu.length + ".");

                while (true) {
                    System.out.print(
                            "\nDo you want to order again? (Y/N): ");
                    choice = scanner.next();

                    if (choice.equalsIgnoreCase("Y")
                            || choice.equalsIgnoreCase("N")) {
                        break;
                    }

                    System.out.println(
                            "Invalid input! Please enter Y or N.");
                }

                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            if (quantity < 1 || quantity > 10) {
                System.out.println(
                        "Invalid quantity! Please enter a quantity from 1 to 10.");

                while (true) {
                    System.out.print(
                            "\nDo you want to order again? (Y/N): ");
                    choice = scanner.next();

                    if (choice.equalsIgnoreCase("Y")
                            || choice.equalsIgnoreCase("N")) {
                        break;
                    }

                    System.out.println(
                            "Invalid input! Please enter Y or N.");
                }

                continue;
            }

            String studentAnswer;

            while (true) {
                System.out.print("Are you a student? (Y/N): ");
                studentAnswer = scanner.next();

                if (studentAnswer.equalsIgnoreCase("Y")
                        || studentAnswer.equalsIgnoreCase("N")) {
                    break;
                }

                System.out.println(
                        "Invalid input! Please enter Y or N.");
            }

            boolean isStudent =
                    studentAnswer.equalsIgnoreCase("Y");

            double subtotal = price[itemNumber - 1] * quantity;
            double discountRate = 0;

            if (isStudent && subtotal >= 500) {
                discountRate = 0.15;
            } else if (isStudent) {
                discountRate = 0.10;
            } else if (subtotal >= 500) {
                discountRate = 0.05;
            }

            double discount = subtotal * discountRate;
            double amountDue = subtotal - discount;

            System.out.printf("\nItem: %s%n",
                    menu[itemNumber - 1]);
            System.out.printf("Subtotal: Php %.2f%n", subtotal);
            System.out.printf("Discount: Php %.2f%n", discount);
            System.out.printf("Amount to Pay: Php %.2f%n",
                    amountDue);

            totalItems += quantity;
            totalAmount += subtotal;
            totalDiscount += discount;

            while (true) {
                System.out.print(
                        "\nDo you want to order again? (Y/N): ");
                choice = scanner.next();

                if (choice.equalsIgnoreCase("Y")
                        || choice.equalsIgnoreCase("N")) {
                    break;
                }

                System.out.println(
                        "Invalid input! Please enter Y or N.");
            }
        }

        double finalAmount = totalAmount - totalDiscount;

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total Quantity: " + totalItems);
        System.out.printf("Total Amount Before Deductions2: Php %.2f%n", totalAmount);
        System.out.printf("Total Deduction: Php %.2f%n",
                totalDiscount);
        System.out.printf("Final Amount to Pay: Php %.2f%n",
                finalAmount);
        System.out.println("=========================");
        System.out.println(
                "Thank you for choosing Debug Your Gut Canteen!");

        scanner.close();
    }
}

