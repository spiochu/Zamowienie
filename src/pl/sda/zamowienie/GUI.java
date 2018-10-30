package pl.sda.zamowienie;

import java.awt.*;
import java.io.PrintStream;

public class GUI {

    // deklaracja zmiennych

    private TerminalColors tc;

    private String tekst;

    //konstruktor
    public GUI() {
    }

    //wyświetla menu główne
    public void mainMenu(){

    }

    //wyświetla edycję pozycji w zamówieniu
    public void editItemInOrder(){

    }

    //wyświetla listę pozycji w zamówieniu
    public void orderList(){

    }

    //czyści ekran konsoli
    public static void clearScreen() {
        for (int i = 0; i < 60; i++) {
            System.out.println();
        }

    }
}
