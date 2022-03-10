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
public class AdresDAO {
    /* Import org.springframework.jd....Template */
    private JdbcTemplate jdbcTemplate;

    public AdresDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List  (zawiera info z bazy danych) */
    public List<Adres> list() {
        String sql = "SELECT * FROM ADRESY";
        List<Adres> adresList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));

        return adresList;
    }

    /* Insert - wstawianie nowego wiersza do bazy */
    public void save(Adres adres) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("ADRESY").usingColumns("MIASTO", "ULICA", "NR_LOKALU");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        insert.execute(param);
    }

    /* Read - odczytywanie danych z bazy */
    public Adres get(int id_adresu) {
        Object[] args = {id_adresu};
        String sql = "SELECT * FROM ADRESY WHERE ID_ADRESU = " + args[0];
        Adres adres = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }

    /* Update - aktualizacja danych */
    public void update(Adres adres) {
        String sql = "UPDATE ADRESY SET miasto=:miasto, ulica=:ulica, nr_lokalu=:nr_lokalu WHERE id_adresu=:id_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete - wybrany rekord z danym id */
    public void delete(int id_adresu) {
        String sql = "DELETE FROM ADRESY WHERE id_adresu = ?";
        jdbcTemplate.update(sql, id_adresu);
    }
}
