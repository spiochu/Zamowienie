package pl.sda.zamowienie;

import java.io.*;
import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Scanner;

public class Zamowienie implements Serializable {

    LinkedList<Pozycja> pozycje = new LinkedList<Pozycja>();
    int ileDodanych;
    int maksRozmiar =20;

    // Konstruktor bez parametrów
    public Zamowienie() {
//        this.maksRozmiar = 20;
    }
    // Konstruktor z parametrami
    public Zamowienie(int maksRozmiar) {
    }


    // Metoda dodaje pozycję do listy
    public void dodajPozycje(Pozycja p){
    if(pozycje.size()>=maksRozmiar){
        System.out.println("Nie można dodać pozycji ze względu na maksymalny rozmiar zamówienia");
    }
    if (pozycje.contains(p)) {
        int index = pozycje.indexOf(p);
        Pozycja poz = pozycje.get(index);
        String nazwa = poz.getNazwaTowaru();
        int ilosc = poz.getIleSztuk() + p.getIleSztuk();
        double cena = poz.getCena();
        Pozycja temp = new Pozycja(nazwa, ilosc, cena);
        pozycje.set(index, temp);

    }else {
        pozycje.add(p);
    }
    }

    // oblicza wartość całego zamówienia
    public double obliczWartosc(){
        double wartosc =0;
        for (Pozycja p:pozycje) {
            wartosc += p.obliczWartosc() ;

        }
        return wartosc;

    }
    public double obliczWartoscPoRabacie(){
        double wartosc =0;
        for (Pozycja p:pozycje) {
            wartosc += p.obliczWaroscPoRabacie();

        }
        return wartosc;
    }

    @Override
    public String toString(){
        String tekst = "Zamówienie:\n";
        for (Pozycja p: pozycje) {
            tekst += p.toString() ;
        }
        for (int i = 0; i < 67; i++) {
            tekst +="=";
        }
        tekst +="\n";
        tekst +=String.format("Wartość zamówienia : %44.2fzł\n",obliczWartosc());
        tekst +=String.format("Wartość zamówienia po rabacie: %34.2fzł",obliczWartoscPoRabacie());
        return tekst;
    }

    public void usunPozycje(int index){
        if (index<pozycje.size()){
            pozycje.remove(index);
        }else {
            System.out.println("Zbyt duży index nie można usunąć pozycji");
        }

    }

    // metoda edytuje pozycję
    public void edytujPozycję(int index){
        if(pozycje.size() > index){
            System.out.println(pozycje.get(index).toString());
            System.out.print("Podaj nową wartość dla pola nazwa towaru: ");
            Scanner wej = new Scanner(System.in);
            //nowa nazwa pozycji
            String nazwa = wej.next();
            System.out.println("");
            System.out.print("Podaj nową wartość dla pola ilość sztuk: ");
            //nowa ilość w pozycji
            int ilosc = wej.nextInt();
            System.out.println("");
            System.out.print("Podaj nową wartość dla pola cena: ");
            //nowa cena w pozycji
            double cena = Double.valueOf(wej.next());
            System.out.println("");
            //tworzenie nowej pozycji
            Pozycja nowa = new Pozycja(nazwa,ilosc,cena);
            //  Aktualizacja listy
            pozycje.set(index,nowa);
            // Wyswietlenie zaktualizowanej listy
            System.out.println("Zamówienie zostało zmienione:");
            System.out.println(toString());
        }else {
            System.out.println("Nie można eytować tego pola");
        }

    }

    public static void zapiszZamowienie(Zamowienie z, String nazwaPliku) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(nazwaPliku + ".bin"))) {
            output.writeObject(z);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static Zamowienie wczytajZamowienie(String nazwaPliku) {
            Zamowienie czytajZamowienie;
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(nazwaPliku + ".bin"))) {
                czytajZamowienie = (Zamowienie) input.readObject();
                return czytajZamowienie;

            } catch (IOException e) {
                e.printStackTrace();
                czytajZamowienie = new Zamowienie();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                czytajZamowienie = new Zamowienie();
            }
            return czytajZamowienie;
        }
        }
