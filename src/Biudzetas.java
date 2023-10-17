import java.util.ArrayList;
import java.util.Objects;

public class Biudzetas {
    private final ArrayList<IslaiduIrasas> islaidos = new ArrayList<>();
    private final ArrayList<PajamuIrasas> pajamos = new ArrayList<>();

    public void pridetiPajamuIrasa(PajamuIrasas irasas) {
        pajamos.add(irasas);
    }

    public void istrintiPajamuIrasa (int indeksas) {
        if (indeksas >= 0 && indeksas - 1 < pajamos.size()) {
            pajamos.remove(indeksas - 1);
        } else {
            System.out.println("Pajamu irasas nerastas");
        }
    }

    public void pridetiIslaiduIrasa(IslaiduIrasas irasas) {
        islaidos.add(irasas);
    }

    public void istrintiIslaiduIrasa (int indeksas) {
        if (indeksas >= 0 && indeksas - 1 < islaidos.size()) {
            islaidos.remove(indeksas - 1);
        } else {
            System.out.println("Islaidu irasas nerastas");
        }
    }

    public ArrayList<IslaiduIrasas> getIslaidos() {
        return islaidos;
    }


    public ArrayList<PajamuIrasas> getPajamos() {
        return pajamos;
    }


    public double balansas() {
        double totalPajamos = 0.0;
        double totalIslaidos = 0.0;

        for (PajamuIrasas pajamuIrasas : pajamos) {
            totalPajamos += pajamuIrasas.getSuma();
        }
        for (IslaiduIrasas islaiduIrasas : islaidos) {
            totalIslaidos += islaiduIrasas.getSuma();
        }
        return totalPajamos - totalIslaidos;
    }
}
