import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Jedis client = new Jedis("localhost", 6379);
        RedisStorage log = new RedisStorage(client);
        log.start();
    }
}
