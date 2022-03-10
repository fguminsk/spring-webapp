package bdbt_project.SpringApplication;

public class Operator {
    private int id_operatora;
    private String nazwa;
    private int id_adresu;
    private int id_danych;

    @Override
    public String toString() {
        return "Operator{" +
                "id_operatora=" + id_operatora +
                ", nazwa='" + nazwa + '\'' +
                ", id_adresu=" + id_adresu +
                ", id_danych=" + id_danych +
                '}';
    }

    public int getId_operatora() {
        return id_operatora;
    }

    public void setId_operatora(int id_operatora) {
        this.id_operatora = id_operatora;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa_operatora) {
        this.nazwa = nazwa_operatora;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public int getId_danych() {
        return id_danych;
    }

    public void setId_danych(int id_danych) {
        this.id_danych = id_danych;
    }

    public Operator(){

    }

    public Operator(int id_operatora, String nazwa, int id_adresu, int id_danych) {
        this.id_operatora = id_operatora;
        this.nazwa = nazwa;
        this.id_adresu = id_adresu;
        this.id_danych = id_danych;
    }
}
