package bdbt_project.SpringApplication;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class TransakcjaDAO {
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public TransakcjaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<Transakcja> list() {
        String sql = "SELECT * FROM TRANSAKCJE";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Transakcja.class));
    }

    /* Insert - wstawianie nowego wiersza do bazy */
    public void save(Transakcja transakcja) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("TRANSAKCJE").usingColumns("ID_USLUGI","ID_KLIENTA","DATA");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(transakcja);
        insert.execute(param);
    }

    /* Read - odczytywanie danych z bazy */
    public List<Transakcja> getForClient(int id_klienta) {
        Object[] args = {id_klienta};
        String sql = "SELECT * FROM TRANSAKCJE WHERE ID_KLIENTA = " + args[0];
        return jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Transakcja.class));
    }

    /* Read - odczytywanie danych z bazy */
    public Transakcja get(int id_transakcji) {
        Object[] args = {id_transakcji};
        String sql = "SELECT * FROM TRANSAKCJE WHERE ID_TRANSAKCJI = " + args[0];
        return jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Transakcja.class));
    }

    /* Update - aktualizacja danych */
    public void update(Transakcja transakcja) {
        String sql = "UPDATE TRANSAKCJE SET ID_USLUGI=:id_uslugi, DATA=:data, ID_KLIENTA=:id_klienta WHERE ID_TRANSAKCJI=:id_transakcji";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(transakcja);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete - wybrany rekord z danym id */
    public void delete(int id_transakcji) {
        String sql = "DELETE FROM TRANSAKCJE WHERE ID_TRANSAKCJI = ?";
        jdbcTemplate.update(sql, id_transakcji);
    }
}