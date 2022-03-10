package bdbt_project.SpringApplication;

public class DaneFirm {
    private int id_danych;
    private String krs;
    private String nip;
    private String regon;

    @Override
    public String toString() {
        return "DaneFirm{" +
                "id_danych=" + id_danych +
                ", krs=" + krs +
                ", nip=" + nip +
                ", regon=" + regon +
                '}';
    }

    public int getId_danych() {
        return id_danych;
    }

    public void setId_danych(int id_danych) {
        this.id_danych = id_danych;
    }

    public String getKrs() {
        return krs;
    }

    public void setKrs(String krs) {
        this.krs = krs;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public DaneFirm(int id_danych, String krs, String nip, String regon) {
        this.id_danych = id_danych;
        this.krs = krs;
        this.nip = nip;
        this.regon = regon;
    }
    public DaneFirm(){

    }
}
