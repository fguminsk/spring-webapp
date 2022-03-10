package bdbt_project.SpringApplication;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class AntenaDAO {
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public AntenaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<Antena> list() {
        String sql = "SELECT * FROM ANTENY";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Antena.class));
    }

    /* Insert - wstawianie nowego wiersza do bazy */
    public void save(Antena antena) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("ANTENY").usingColumns("ZYSK_ENERGETYCZNY","POCHYLENIE_ANTENY","OBSLUGIWANY_STANDARD","ID_STACJI_BAZOWEJ");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(antena);
        insert.execute(param);
    }

    /* Read - odczytywanie danych z bazy */
    public Antena get(int id_anteny) {
        Object[] args = {id_anteny};
        String sql = "SELECT * FROM ANTENY WHERE ID_ANTENY = " + args[0];
        return jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Antena.class));
    }

    /* Update - aktualizacja danych */
    public void update(Antena antena) {
        String sql = "UPDATE ANTENY SET ZYSK_ENERGETYCZNY=:zysk_energetyczny, POCHYLENIE_ANTENY=:pochylenie_anteny, OBSLUGIWANY_STANDARD=:obslugiwany_standard, ID_STACJI_BAZOWEJ=:id_stacji_bazowej WHERE ID_ANTENY=:id_anteny";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(antena);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete - wybrany rekord z danym id */
    public void delete(int id_anteny) {
        String sql = "DELETE FROM ANTENY WHERE ID_ANTENY = ?";
        jdbcTemplate.update(sql, id_anteny);
    }
}