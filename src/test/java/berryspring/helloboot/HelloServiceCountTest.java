package berryspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

@HelloBootTest
public class HelloServiceCountTest {
    @Autowired HelloService helloService;
    @Autowired HelloRepository helloRepository;

    @Test
    void seyHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.seyHello("Berry");
            Assertions.assertThat(helloRepository.countOf("Berry")).isEqualTo(count);
        });
    }


}
