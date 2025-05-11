package main.java;

import main.java.models.ExchangeRate;
import main.java.services.ExchangeRateServices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExchangeRateServices exchangeRateServices = new ExchangeRateServices();
        Scanner scn = new Scanner(System.in);
        ExchangeRate exchangeRate;
        String baseCode = "", targetCode="";
        int optionPanel = -1;
        double amount = 0.0000;

        final String messageInitial = """
                -------------------------------------
                ¡Bienvenido/a al Conversor de Moneda!
                -------------------------------------
                
                En este programa podrás realizar la conversión
                de tipo de cambio de monedas como:
                Dólar, Pesos Argentinos, Real Brasileño,
                entre otros.""";

        final String messagePanel = """
                
                
                ****************************************
                         Opciones de conversión
                ****************************************
                
                1 .- Dólar =>> Peso argentino
                2 .- Dólar =>> Real brasileño
                3 .- Dólar =>> Peso colombiano
                4 .- Dólar =>> Sol peruano
                5 .- Peso argentino  =>> Dólar
                6 .- Real brasileño  =>> Dólar
                7 .- Peso colombiano =>> Dólar
                8 .- Sol Peruano     =>> Dólar
                0 .- Salir
                
                ****************************************
                """;

        final String messageInputOption = "Ingrese una opción valida: ";
        final String messageInputAmount = "Ingrese el valor que desea convertir: ";
        String messageResponse = """
                El valor %.2f [%s] corresponde al valor final de =>> %.2f [%s]""";


        System.out.println(messageInitial);


        while(optionPanel != 0)
        {
            System.out.println(messagePanel);
            System.out.print(messageInputOption);
            optionPanel = scn.nextInt();

            if(optionPanel==0)
                break;

            System.out.print(messageInputAmount);
            amount = scn.nextDouble();

            switch (optionPanel){
                case 1:
                    baseCode = "USD"; targetCode = "ARS";
                    exchangeRate = exchangeRateServices
                            .PairConversion(baseCode,targetCode,amount);
                    System.out.printf((messageResponse) + "%n", amount, baseCode, exchangeRate.conversion_result(), targetCode);
                    break;
                case 2:
                    baseCode = "USD"; targetCode = "BRL";
                    exchangeRate = exchangeRateServices
                            .PairConversion(baseCode,targetCode,amount);
                    System.out.printf((messageResponse) + "%n", amount, baseCode, exchangeRate.conversion_result(), targetCode);
                    break;
                case 3:
                    baseCode = "USD"; targetCode = "COP";
                    exchangeRate = exchangeRateServices
                            .PairConversion(baseCode,targetCode,amount);
                    System.out.printf((messageResponse) + "%n", amount, baseCode, exchangeRate.conversion_result(), targetCode);
                    break;
                case 4:
                    baseCode = "USD"; targetCode = "PEN";
                    exchangeRate = exchangeRateServices
                            .PairConversion(baseCode,targetCode,amount);
                    System.out.printf((messageResponse) + "%n", amount, baseCode, exchangeRate.conversion_result(), targetCode);
                    break;
                case 5:
                    baseCode = "ARS"; targetCode = "USD";
                    exchangeRate = exchangeRateServices
                            .PairConversion(baseCode,targetCode,amount);
                    System.out.printf((messageResponse) + "%n", amount, baseCode, exchangeRate.conversion_result(), targetCode);
                    break;
                case 6:
                    baseCode = "BRL"; targetCode = "USD";
                    exchangeRate = exchangeRateServices
                            .PairConversion(baseCode,targetCode,amount);
                    System.out.printf((messageResponse) + "%n", amount, baseCode, exchangeRate.conversion_result(), targetCode);
                    break;
                case 7:
                    baseCode = "COP"; targetCode = "USD";
                    exchangeRate = exchangeRateServices
                            .PairConversion(baseCode,targetCode,amount);
                    System.out.printf((messageResponse) + "%n", amount, baseCode, exchangeRate.conversion_result(), targetCode);
                    break;
                case 8:
                    baseCode = "PEN"; targetCode = "USD";
                    exchangeRate = exchangeRateServices
                            .PairConversion(baseCode,targetCode,amount);
                    System.out.printf((messageResponse) + "%n", amount, baseCode, exchangeRate.conversion_result(), targetCode);
                    break;
            };
        }
    }
}
