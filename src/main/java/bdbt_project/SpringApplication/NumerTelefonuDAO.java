package bdbt_project.SpringApplication;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class NumerTelefonuDAO {
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public NumerTelefonuDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<NumerTelefonu> list() {
        String sql = "SELECT * FROM NUMERY_TELEFONOW";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(NumerTelefonu.class));
    }

    /* Insert - wstawianie nowego wiersza do bazy */
    public void save(NumerTelefonu numerTelefonu) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("NUMERY_TELEFONOW").usingColumns("ID_USLUGI","NUMER_TELEFONU","KOSZT_MINUTY_POLACZENIA","KOSZT_SMS","KOSZT_ROAMINGU");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(numerTelefonu);
        insert.execute(param);
    }

    /* Read - odczytywanie danych z bazy */
    public NumerTelefonu get(int id_uslugi) {
        Object[] args = {id_uslugi};
        String sql = "SELECT * FROM NUMERY_TELEFONOW WHERE ID_USLUGI = " + args[0];
        return jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(NumerTelefonu.class));
    }

    /* Update - aktualizacja danych */
    public void update(NumerTelefonu numerTelefonu) {
        String sql = "UPDATE NUMERY_TELEFONOW SET NUMER_TELEFONU=:numer_telefonu, KOSZT_MINUTY_POLACZENIA=:koszt_minuty_polaczenia, KOSZT_SMS=:koszt_sms, KOSZT_ROAMINGU=:koszt_roamingu WHERE ID_USLUGI=:id_uslugi";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(numerTelefonu);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete - wybrany rekord z danym id */
    public void delete(int id_uslugi) {
        String sql = "DELETE FROM NUMERY_TELEFONOW WHERE ID_USLUGI = ?";
        jdbcTemplate.update(sql, id_uslugi);
    }
}