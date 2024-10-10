package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private final ExchangeService exchangeService;

    public Menu(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("===== Sean bienvenidos al Conversor de Moneda =====");
            System.out.println("1. Dólar =>> Peso colombiano");
            System.out.println("2. Peso colombiano =>> Dólar");
            System.out.println("3. Dólar =>> Peso argentino");
            System.out.println("4. Peso argentino =>> Dólar");
            System.out.println("5. Dólar =>> Real brasileño");
            System.out.println("6. Real brasileño =>> Dólar");
            System.out.println("7. Salir");
            System.out.print("Elija una opción válida: ");
            String option = scanner.nextLine();

            if (option.equals("7")) {
                System.out.println("Saliendo...");
                exit = true;
            } else {
                try {
                    System.out.print("Ingrese el valor que deseas convertir: ");
                    String  amountStr = scanner.nextLine();

                    // Validar si el valor ingresado es un double
                    double amount = validateAmount(amountStr);

                    String result = exchangeService.getCurrencyChange(option, amount);
                    System.out.println("Resultado de la conversion: \n" + result);
                } catch (IOException | InterruptedException e) {
                    System.out.println("Error durante la conversion: " + e.getMessage());
                    Thread.currentThread().interrupt();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
            System.out.println("*********************************************");
        }
        scanner.close();
    }

    private double validateAmount(String amountStr) {

        try {
            return Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido. Por favor ingrese un monto valido.");
        }
        return 0;
    }
}

