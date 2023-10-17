public enum IslaiduKategorija {
    TRANSPORTAS(1),
    MAISTAS(2),
    MOKESCIAI(3);

    private int numeris;
    IslaiduKategorija(int i) {
        numeris = i;
    }

    public static IslaiduKategorija kategorijaPagalNumeri(int i) {
        for (IslaiduKategorija ik : values()) {
            if (ik.getNumeris() == i) {
                return ik;
            }
        }
        return null;
    }
    public int getNumeris() {
        return numeris;
    }
}
