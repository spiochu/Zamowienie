package pl.sda.zamowienie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //inicjalizacja potrzebnych zmiennych
        Zamowienie z = new Zamowienie(20);
        Scanner wej = new Scanner(System.in);
        //wyswietlenie mini menu
        System.out.println("1. wczytaj zamówienie\n" +
                "2. Utwórz nowe zamówienie");
        //Pobranie wyboru od urzytkownika
        int menu = wej.nextInt();

        if (menu == 1) {
            //wyczytanie zamówienia z pliku "zamownieie.bin" oraz jego wyswietlenie
            z = Zamowienie.wczytajZamowienie("zamowienie");
            System.out.println(z);

        } else {
            //stworzenie nowego zamówienie i zapianie go
            z = dodajPozycje();
            System.out.println(z);
            // dodanie możliwości edycji wybranej pozycji pred zapisem
            System.out.println("Czy chcesz edytować krórąś pozycję??(T(1)/N(0))");
            if (wej.nextInt() == 1) {
                System.out.println("podaj nr pozycji");
                z.edytujPozycję(wej.nextInt()-1);

            }
            //zapisywanie całego zamówienia
            Zamowienie.zapiszZamowienie(z, "zamowienie");
        }


    }


    // dodaje kolejne pozycje do zamówienia
    public static Zamowienie dodajPozycje() {
        Zamowienie tempZamowienie = new Zamowienie();
        Scanner wej = new Scanner(System.in);
        int wybor = 0;
        do {
            //mini menu
            System.out.println("1. Dodaj chleby\n" +
                    "2. Dodaj cukier\n" +
                    "0. Zakończ dodawanie\n");
            wybor = wej.nextInt();
            switch (wybor) {
                case 1:
                    //dodaje zdefiniowaną prze urzytkownika liczbę chlebów do zamówienia
                    System.out.println("podaj ilosc chlebów do dodania: ");
                    int temp =  wej.nextInt();
                    tempZamowienie.dodajPozycje(dodajChleb(temp));
                    break;
                case 2:
                    //dodaje zdefiniowaną prze urzytkownika liczbę cukru do zamówienia
                    System.out.println("podaj ilosc cukru do dodania: ");
                    tempZamowienie.dodajPozycje(dodajCukier(wej.nextInt()));
                    break;

                default:
                    break;
            }
            System.out.println("Pozycja dodana!!");

        }
        while (wybor != 0) ;
        return tempZamowienie;
    }

    // tworzy pozycję o zadanej ilości chlebów
    public static Pozycja dodajChleb(int ilosc) {
        Pozycja p1 = new Pozycja("Chleb", ilosc, 3.5);
        return p1;
    }

    //tworzy pozycję o zadanej ilości cukru
    public static Pozycja dodajCukier(int ilosc) {
        Pozycja p1 = new Pozycja("Cukier", ilosc, 4);
        return p1;
    }
}
