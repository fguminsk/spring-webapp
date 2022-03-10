package bdbt_project.SpringApplication;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class UslugaDAO {
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public UslugaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<Usluga> list() {
        String sql = "SELECT * FROM USLUGI";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Usluga.class));
    }

    /* Insert - wstawianie nowego wiersza do bazy */
    public void save(Usluga usluga) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("USLUGI").usingColumns("ID_USLUGI","TYP_USLUGI","ID_OPERATORA");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(usluga);
        insert.execute(param);
    }

    /* Read - odczytywanie danych z bazy */
    public Usluga get(int id_uslugi) {
        Object[] args = {id_uslugi};
        String sql = "SELECT * FROM USLUGI WHERE ID_USLUGI = " + args[0];
        return jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Usluga.class));
    }

    /* Update - aktualizacja danych */
    public void update(Usluga usluga) {
        String sql = "UPDATE USLUGI SET TYP_USLUGI=:typ_uslugi, ID_OPERATORA=:id_operatora WHERE ID_USLUGI=:id_uslugi";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(usluga);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete - wybrany rekord z danym id */
    public void delete(int id_uslugi) {
        String sql = "DELETE FROM USLUGI WHERE id_uslugi = ?";
        jdbcTemplate.update(sql, id_uslugi);
    }
}