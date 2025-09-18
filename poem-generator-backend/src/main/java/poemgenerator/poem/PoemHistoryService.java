package poemgenerator.poem;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoemHistoryService {
    private final StringRedisTemplate redisTemplate;

    private static final String KEY = "poems:recent";

    public PoemHistoryService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addPoem(String poemContent) {
        redisTemplate.opsForList().leftPush(KEY, poemContent);
        redisTemplate.opsForList().trim(KEY, 0, 9); // keep last 10 poems
    }

    public List<String> getRecentPoems() {
        return redisTemplate.opsForList().range(KEY, 0, -1);
    }
}
