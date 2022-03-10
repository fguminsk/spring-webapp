package bdbt_project.SpringApplication;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Transakcja {

    public int getId_uslugi() {
        return id_uslugi;
    }

    public void setId_uslugi(int id_uslugi) {
        this.id_uslugi = id_uslugi;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Transakcja(){

    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private int id_uslugi;
    private int id_klienta;
    private Date data;
    private int id_transakcji;

    public Transakcja(int id_uslugi, int id_klienta, Date data, int id_transakcji) {
        this.id_uslugi = id_uslugi;
        this.id_klienta = id_klienta;
        this.data = data;
        this.id_transakcji = id_transakcji;
    }

    @Override
    public String toString() {
        return "Transakcja{" +
                "id_uslugi=" + id_uslugi +
                ", id_klienta=" + id_klienta +
                ", data=" + data +
                ", id_transakcji=" + id_transakcji +
                '}';
    }

    public int getId_transakcji() {
        return id_transakcji;
    }

    public void setId_transakcji(int id_transakcji) {
        this.id_transakcji = id_transakcji;
    }
}
