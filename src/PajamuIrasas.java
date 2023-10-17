import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class PajamuIrasas {
    private double suma;
    private LocalDate data;
    private String papildomaInfo;
    private PajamuKategorija kategorija;

    public PajamuIrasas(double suma, LocalDate data, String papildomaInfo, PajamuKategorija kategorija) {
        this.suma = suma;
        this.data = data;
        this.papildomaInfo = papildomaInfo;
        this.kategorija = kategorija;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }

    public PajamuKategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(PajamuKategorija kategorija) {
        this.kategorija = kategorija;
    }


}
