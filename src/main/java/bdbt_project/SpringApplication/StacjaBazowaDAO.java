package bdbt_project.SpringApplication;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class StacjaBazowaDAO {
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public StacjaBazowaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<StacjaBazowa> list() {
        String sql = "SELECT * FROM STACJE_BAZOWE";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(StacjaBazowa.class));
    }

    /* Insert - wstawianie nowego wiersza do bazy */
    public void save(StacjaBazowa stacjaBazowa) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("STACJE_BAZOWE").usingColumns("TYP_STACJI","KOMORKA","ID_OPERATORA","ID_ADRESU");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(stacjaBazowa);
        insert.execute(param);
    }

    /* Read - odczytywanie danych z bazy */
    public StacjaBazowa get(int id_stacji_bazowej) {
        Object[] args = {id_stacji_bazowej};
        String sql = "SELECT * FROM STACJE_BAZOWE WHERE ID_STACJI_BAZOWEJ = " + args[0];
        return jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(StacjaBazowa.class));
    }

    /* Update - aktualizacja danych */
    public void update(StacjaBazowa stacjaBazowa) {
        String sql = "UPDATE STACJE_BAZOWE SET TYP_STACJI=:typ_stacji, KOMORKA=:komorka, ID_OPERATORA=:id_operatora, ID_ADRESU=:id_adresu WHERE ID_STACJI_BAZOWEJ=:id_stacji_bazowej";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(stacjaBazowa);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete - wybrany rekord z danym id */
    public void delete(int id_stacji_bazowej) {
        String sql = "DELETE FROM STACJE_BAZOWE WHERE ID_STACJI_BAZOWEJ = ?";
        jdbcTemplate.update(sql, id_stacji_bazowej);
    }
}