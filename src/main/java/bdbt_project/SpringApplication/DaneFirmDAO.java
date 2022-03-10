package bdbt_project.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class DaneFirmDAO {
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public DaneFirmDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<DaneFirm> list(){
        String sql = "SELECT * FROM DANE_FIRM";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(DaneFirm.class));
    }

    /* Insert - wstawianie nowego wiersza do bazy */
    public void save(DaneFirm daneFirm) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("DANE_FIRM").usingColumns("ID_DANYCH","KRS","NIP","REGON");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(daneFirm);
        insert.execute(param);
    }

    /* Read - odczytywanie danych z bazy */
    public DaneFirm get(int id_danych) {
        Object[] args = {id_danych};
        String sql = "SELECT * FROM DANE_FIRM WHERE ID_DANYCH = " + args[0];
        return jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(DaneFirm.class));
    }

    /* Update - aktualizacja danych */
    public void update(DaneFirm daneFirm) {
        String sql = "UPDATE DANE_FIRM SET KRS=:krs, NIP=:nip, REGON=:regon WHERE ID_DANYCH=:id_danych";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(daneFirm);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete - wybrany rekord z danym id */
    public void delete(int id_danych) {
        String sql = "DELETE FROM DANE_FIRM WHERE ID_DANYCH = ?";
        jdbcTemplate.update(sql, id_danych);
    }
}
