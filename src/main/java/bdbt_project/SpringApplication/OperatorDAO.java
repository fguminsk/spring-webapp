package bdbt_project.SpringApplication;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class OperatorDAO {
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public OperatorDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<Operator> list(){
        String sql = "SELECT * FROM OPERATORZY";
        List<Operator> operatorList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Operator.class));

        return operatorList;
    }

    /* Insert - wstawianie nowego wiersza do bazy */
    public void save(Operator adres) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("OPERATORZY").usingColumns("NAZWA","ID_ADRESU","ID_DANYCH");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        insert.execute(param);
    }

    /* Read - odczytywanie danych z bazy */
    public Operator get(int id_operatora) {
        Object[] args = {id_operatora};
        String sql = "SELECT * FROM OPERATORZY WHERE ID_OPERATORA = " + args[0];
        Operator operator = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Operator.class));
        return operator;
    }

    /* Update - aktualizacja danych */
    public void update(Operator operator) {
        String sql = "UPDATE OPERATORZY SET nazwa=:nazwa, id_adresu=:id_adresu, id_danych=:id_danych WHERE id_operatora=:id_operatora";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(operator);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete - wybrany rekord z danym id */
    public void delete(int id_operatora) {
        String sql = "DELETE FROM OPERATORZY WHERE id_operatora = ?";
        jdbcTemplate.update(sql, id_operatora);
    }
}