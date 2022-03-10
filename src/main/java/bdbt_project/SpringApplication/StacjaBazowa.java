package bdbt_project.SpringApplication;

public class StacjaBazowa {
    private int id_stacji_bazowej;
    private String typ_stacji;
    private String komorka;
    private int id_operatora;
    private int id_adresu;

    public StacjaBazowa(int id_stacji_bazowej, String typ_stacji, String komorka, int id_operatora, int id_adresu) {
        this.id_stacji_bazowej = id_stacji_bazowej;
        this.typ_stacji = typ_stacji;
        this.komorka = komorka;
        this.id_operatora = id_operatora;
        this.id_adresu = id_adresu;
    }

    public StacjaBazowa(){

    }

    @Override
    public String toString() {
        return "ID = " + id_stacji_bazowej +
                ", typ stacji = " + typ_stacji +
                ", komórka = " + komorka +
                ", id adresu stacji = " + id_adresu;
    }

    public int getId_stacji_bazowej() {
        return id_stacji_bazowej;
    }

    public void setId_stacji_bazowej(int id_stacji_bazowej) {
        this.id_stacji_bazowej = id_stacji_bazowej;
    }

    public String getTyp_stacji() {
        return typ_stacji;
    }

    public void setTyp_stacji(String typ_stacji) {
        this.typ_stacji = typ_stacji;
    }

    public String getKomorka() {
        return komorka;
    }

    public void setKomorka(String komorka) {
        this.komorka = komorka;
    }

    public int getId_operatora() {
        return id_operatora;
    }

    public void setId_operatora(int id_operatora) {
        this.id_operatora = id_operatora;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }
}
