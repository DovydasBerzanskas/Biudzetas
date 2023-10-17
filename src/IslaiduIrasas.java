import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class IslaiduIrasas {
    private double suma;
    private LocalDate data;
    private String papildomaInfo;
    private IslaiduKategorija kategorija;

    public IslaiduIrasas(double suma, LocalDate data, String papildomaInfo, IslaiduKategorija kategorija) {
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

    public IslaiduKategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(IslaiduKategorija kategorija) {
        this.kategorija = kategorija;
    }

}
