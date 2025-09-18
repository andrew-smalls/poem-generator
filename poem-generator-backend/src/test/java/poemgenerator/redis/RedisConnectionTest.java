package poemgenerator.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RedisConnectionTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void testRedisConnection() {
        // write a value
        redisTemplate.opsForValue().set("test:key", "hello redis");

        // read it back
        String value = redisTemplate.opsForValue().get("test:key");

        assertThat(value).isEqualTo("hello redis");
    }
}
