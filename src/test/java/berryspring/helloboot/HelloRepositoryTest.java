package berryspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HelloBootTest
public class HelloRepositoryTest {
    @Autowired HelloRepository helloRepository;
    @Autowired JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void findHelloFailed() {
        Assertions.assertThat(helloRepository.findHello("Berry")).isNull();
    }

    @Test
    void incraseCount() {
        Assertions.assertThat(helloRepository.countOf("Berry")).isEqualTo(0);

        helloRepository.increaseCount("Berry");
        Assertions.assertThat(helloRepository.countOf("Berry")).isEqualTo(1);

        helloRepository.increaseCount("Berry");
        Assertions.assertThat(helloRepository.countOf("Berry")).isEqualTo(2);
    }
}
