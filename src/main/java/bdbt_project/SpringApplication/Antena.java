package bdbt_project.SpringApplication;

public class Antena {
    private int id_anteny;
    private String zysk_energetyczny;
    private String pochylenie_anteny;
    private String obslugiwany_standard;
    private int id_stacji_bazowej;

    @Override
    public String toString() {
        return "Antena{" +
                "id_anteny=" + id_anteny +
                ", zysk_energetyczny='" + zysk_energetyczny + '\'' +
                ", pochylenie_anteny='" + pochylenie_anteny + '\'' +
                ", obslugiwany_standard='" + obslugiwany_standard + '\'' +
                ", id_stacji_bazowej=" + id_stacji_bazowej +
                '}';
    }

    public Antena(int id_anteny, String zysk_energetyczny, String pochylenie_anteny, String obslugiwany_standard, int id_stacji_bazowej) {
        this.id_anteny = id_anteny;
        this.zysk_energetyczny = zysk_energetyczny;
        this.pochylenie_anteny = pochylenie_anteny;
        this.obslugiwany_standard = obslugiwany_standard;
        this.id_stacji_bazowej = id_stacji_bazowej;
    }

    public int getId_anteny() {
        return id_anteny;
    }

    public void setId_anteny(int id_anteny) {
        this.id_anteny = id_anteny;
    }

    public String getZysk_energetyczny() {
        return zysk_energetyczny;
    }

    public void setZysk_energetyczny(String zysk_energetyczny) {
        this.zysk_energetyczny = zysk_energetyczny;
    }

    public String getPochylenie_anteny() {
        return pochylenie_anteny;
    }

    public void setPochylenie_anteny(String pochylenie_anteny) {
        this.pochylenie_anteny = pochylenie_anteny;
    }

    public String getObslugiwany_standard() {
        return obslugiwany_standard;
    }

    public void setObslugiwany_standard(String obslugiwany_standard) {
        this.obslugiwany_standard = obslugiwany_standard;
    }

    public int getId_stacji_bazowej() {
        return id_stacji_bazowej;
    }

    public void setId_stacji_bazowej(int id_stacji_bazowej) {
        this.id_stacji_bazowej = id_stacji_bazowej;
    }

    public Antena(){

    }
}
