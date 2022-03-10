package bdbt_project.SpringApplication;

public class Usluga {
    private int id_uslugi;
    private String typ_uslugi;
    private int id_operatora;

    public Usluga(int id_uslugi, String typ_uslugi, int id_operatora) {
        this.id_uslugi = id_uslugi;
        this.typ_uslugi = typ_uslugi;
        this.id_operatora = id_operatora;
    }

    @Override
    public String toString() {
        return "Usluga{" +
                "id_uslugi=" + id_uslugi +
                ", typ_uslugi='" + typ_uslugi + '\'' +
                ", id_operatora=" + id_operatora +
                '}';
    }

    public int getId_uslugi() {
        return id_uslugi;
    }

    public void setId_uslugi(int id_uslugi) {
        this.id_uslugi = id_uslugi;
    }

    public String getTyp_uslugi() {
        return typ_uslugi;
    }

    public void setTyp_uslugi(String typ_uslugi) {
        this.typ_uslugi = typ_uslugi;
    }

    public int getId_operatora() {
        return id_operatora;
    }

    public void setId_operatora(int id_operatora) {
        this.id_operatora = id_operatora;
    }

    public Usluga(){

    }
}
