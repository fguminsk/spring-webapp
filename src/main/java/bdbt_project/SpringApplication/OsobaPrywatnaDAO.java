package bdbt_project.SpringApplication;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class OsobaPrywatnaDAO {
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public OsobaPrywatnaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<OsobaPrywatna> list(){
        String sql = "SELECT * FROM OSOBY_PRYWATNE";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OsobaPrywatna.class));
    }

    /* Insert - wstawianie nowego wiersza do bazy */
    public void save(OsobaPrywatna osobaPrywatna) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("OSOBY_PRYWATNE").usingColumns("ID_KLIENTA","IMIE","NAZWISKO","PESEL");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(osobaPrywatna);
        insert.execute(param);
    }

    /* Read - odczytywanie danych z bazy */
    public OsobaPrywatna get(int id_klienta) {
        Object[] args = {id_klienta};
        String sql = "SELECT * FROM OSOBY_PRYWATNE WHERE ID_KLIENTA = " + args[0];
        return jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(OsobaPrywatna.class));
    }

    /* Update - aktualizacja danych */
    public void update(OsobaPrywatna osobaPrywatna) {
        String sql = "UPDATE OSOBY_PRYWATNE SET IMIE=:imie, NAZWISKO=:nazwisko, PESEL=:pesel WHERE ID_KLIENTA=:id_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(osobaPrywatna);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete - wybrany rekord z danym id */
    public void delete(int id_klienta) {
        String sql = "DELETE FROM OSOBY_PRYWATNE WHERE id_klienta = ?";
        jdbcTemplate.update(sql, id_klienta);
    }
}