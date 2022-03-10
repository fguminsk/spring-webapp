package bdbt_project.SpringApplication;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Klient {
    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public Date getData_rozpoczecia_umowy() {
        return data_rozpoczecia_umowy;
    }

    public void setData_rozpoczecia_umowy(Date data_rozp_umowy) {
        this.data_rozpoczecia_umowy = data_rozp_umowy;
    }

    public Date getData_zakonczenia_umowy() {
        return data_zakonczenia_umowy;
    }

    public void setData_zakonczenia_umowy(Date data_zakon_umowy) {
        this.data_zakonczenia_umowy = data_zakon_umowy;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getTyp(){return typ;}

    public void setTyp(String typ){this.typ = typ;}



    @Override
    public String toString() {
        return "Klient{" +
                "id_klienta=" + id_klienta +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", data_rozpoczecia_umowy='" + data_rozpoczecia_umowy + '\'' +
                ", data_zakonczenia_umowy='" + data_zakonczenia_umowy + '\'' +
                ", id_adresu=" + id_adresu +
                '}';
    }

    public Klient(int id_klienta, String nr_telefonu, Date data_rozpoczecia_umowy, Date data_zakonczenia_umowy, int id_adresu, String typ) {
        this.id_klienta = id_klienta;
        this.nr_telefonu = nr_telefonu;
        this.data_rozpoczecia_umowy = data_rozpoczecia_umowy;
        this.data_zakonczenia_umowy = data_zakonczenia_umowy;
        this.id_adresu = id_adresu;
        this.typ = typ;
    }

    public Klient(){

    }

//    @Temporal(TemporalType.DATE)
    @DateTimeFormat (pattern="yyyy-MM-dd")
    private int id_klienta;
    private String nr_telefonu;
    private Date data_rozpoczecia_umowy;
    private Date data_zakonczenia_umowy;
    private int id_adresu;
    private String typ;
}
