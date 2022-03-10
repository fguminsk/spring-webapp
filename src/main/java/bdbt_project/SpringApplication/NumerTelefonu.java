package bdbt_project.SpringApplication;

public class NumerTelefonu {
    private int id_uslugi;
    private String numer_telefonu;
    private int koszt_minuty_polaczenia;
    private int koszt_sms;
    private int koszt_roamingu;

    public int getId_uslugi() {
        return id_uslugi;
    }

    @Override
    public String toString() {
        return "NumerTelefonu{" +
                "id_uslugi=" + id_uslugi +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", koszt_minuty_polaczenia=" + koszt_minuty_polaczenia +
                ", koszt_sms=" + koszt_sms +
                ", koszt_roamingu=" + koszt_roamingu +
                '}';
    }

    public void setId_uslugi(int id_uslugi) {
        this.id_uslugi = id_uslugi;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public int getKoszt_minuty_polaczenia() {
        return koszt_minuty_polaczenia;
    }

    public void setKoszt_minuty_polaczenia(int koszt_minuty_polaczenia) {
        this.koszt_minuty_polaczenia = koszt_minuty_polaczenia;
    }

    public int getKoszt_sms() {
        return koszt_sms;
    }

    public void setKoszt_sms(int koszt_sms) {
        this.koszt_sms = koszt_sms;
    }

    public int getKoszt_roamingu() {
        return koszt_roamingu;
    }

    public void setKoszt_roamingu(int koszt_roamingu) {
        this.koszt_roamingu = koszt_roamingu;
    }

    public NumerTelefonu(int id_uslugi, String numer_telefonu, int koszt_minuty_polaczenia, int koszt_sms, int koszt_roamingu) {
        this.id_uslugi = id_uslugi;
        this.numer_telefonu = numer_telefonu;
        this.koszt_minuty_polaczenia = koszt_minuty_polaczenia;
        this.koszt_sms = koszt_sms;
        this.koszt_roamingu = koszt_roamingu;
    }

    public NumerTelefonu(){

    }
}
