package bdbt_project.SpringApplication;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class KlientDAO {
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public KlientDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<Klient> list(){
        String sql = "SELECT * FROM KLIENCI";
        List<Klient> klientList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));

        return klientList;
    }

    /* Insert - wstawianie nowego wiersza do bazy */
    public void save(Klient klient) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("KLIENCI").usingColumns("NR_TELEFONU","DATA_ROZPOCZECIA_UMOWY","DATA_ZAKONCZENIA_UMOWY","ID_ADRESU", "TYP");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        insert.execute(param);
    }

    /* Read - odczytywanie danych z bazy */
    public Klient get(int id_klienta) {
        Object[] args = {id_klienta};
        String sql = "SELECT * FROM KLIENCI WHERE ID_KLIENTA = " + args[0];
        Klient klient = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }

    /* Update - aktualizacja danych */
    public void update(Klient klient) {
        String sql = "UPDATE KLIENCI SET NR_TELEFONU=:nr_telefonu, DATA_ROZPOCZECIA_UMOWY=:data_rozpoczecia_umowy, DATA_ZAKONCZENIA_UMOWY=:data_zakonczenia_umowy, ID_ADRESU=:id_adresu WHERE ID_KLIENTA=:id_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete - wybrany rekord z danym id */
    public void delete(int id_klienta) {
        String sql = "DELETE FROM KLIENCI WHERE id_klienta = ?";
        jdbcTemplate.update(sql, id_klienta);
    }
}