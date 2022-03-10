package bdbt_project.SpringApplication;

public class Adres {
    private int id_adresu;
    private String miasto;
    private String ulica;
    private String nr_lokalu;

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(String nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }


    @Override
    public String toString() {
        return id_adresu +
                ". " + miasto +
                ", ul." + ulica + '/' +
                nr_lokalu;
    }

    public Adres(){

    }

    public Adres(int id_adresu, String miasto, String ulica, String nr_lokalu) {
        super();
        this.id_adresu = id_adresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_lokalu = nr_lokalu;
    }
}
