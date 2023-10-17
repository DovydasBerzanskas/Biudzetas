public enum PajamuKategorija {
    ATLYGINIMAS(1),
    STIPENDIJA(2);

    private int numeris;
    PajamuKategorija(int i) {
        numeris = i;
    }

    public static PajamuKategorija kategorijaPagalNumeri(int i) {
        for (PajamuKategorija pk : values()) {
            if (pk.getNumeris() == i) {
                return pk;
            }
        }
        return null;
    }

    public int getNumeris() {
        return numeris;
    }
}
