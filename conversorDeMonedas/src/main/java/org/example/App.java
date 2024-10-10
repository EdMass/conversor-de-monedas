package org.example;

public class App 
{
    public static void main( String[] args )  {

        ExchangeService exchangeService = new ExchangeService();
        Menu menu = new Menu(exchangeService);
        menu.display();
    }
}
