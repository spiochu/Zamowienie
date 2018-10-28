package pl.sda.zamowienie;

import java.io.Serializable;

public class Pozycja implements Serializable{

    private String nazwaTowaru;
    private int ileSztuk;
    private double cena;

    // konstruktor z parametrami
    public Pozycja(String nazwaTowaru,int ileSztuk,double cena){
        this.nazwaTowaru = nazwaTowaru;
        this.ileSztuk = ileSztuk;
        this.cena = cena;

    }



    // Oblicza watrość zamówionej pozycji
    public double obliczWartosc(){
    return ileSztuk*cena;
    }

    //Nadpisanie metody toString i wyświetlenie pojedyńczej pozycji
    @Override
    public String toString(){
        String tekst = String.format("%-20s %10.2fzł %4dszt %10.2fzł %10.2fzł\n",nazwaTowaru,cena,ileSztuk,obliczWartosc(),obliczWaroscPoRabacie());
        return tekst;
    }
    //nadpisanie metody equals do porównywania nazw pozycji
    @Override
    public boolean equals(Object p){
        boolean isEqual = false;
        if (this.nazwaTowaru == ((Pozycja) p).getNazwaTowaru()){
            isEqual= true;
        }
        return isEqual;
    }



    //utworzony geter dla pola NazwaTowaru
    public String getNazwaTowaru() {
        return nazwaTowaru;
    }
    //utworzony geter dla pola ileSztuk
    public int getIleSztuk() {
        return ileSztuk;
    }
    //utworzony geter dla pola cena
    public double getCena() {
        return cena;
    }

    //Metoda oblicza wartość danej pozycji uwzględniając rabat obliczany według ilości sztuk
    public double obliczWaroscPoRabacie(){
        double wartosc = obliczWartosc();
        if (this.ileSztuk > 5){
            wartosc *= 0.95;
        }else if (this.ileSztuk >10){
            wartosc *= 0.9;
        }else if (this.ileSztuk >20){
            wartosc *= 0.85;
        }

        return wartosc;
    }


}
