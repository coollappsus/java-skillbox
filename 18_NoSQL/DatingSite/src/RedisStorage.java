import redis.clients.jedis.Jedis;
import redis.clients.jedis.resps.ScanResult;
import redis.clients.jedis.resps.Tuple;

import java.util.Date;
import java.util.List;

public class RedisStorage {

    private Jedis client;
    List<Tuple> result;

    public RedisStorage(Jedis client) {
        this.client = client;
    }

    public void start() {
        init();
        print();
    }

    private void init() {
        removeKey();
        for (int i = 1; i <= 20; i++) {
            client.zadd("Users", new Date().getTime(), String.valueOf(i));
        }
        ScanResult<Tuple> users = client.zscan("Users", "0");
        result = users.getResult();
    }

    private void print() {
        for (Tuple user : result) {
            System.out.println("Пользователь " + user.getElement());
            try {
                Thread.sleep(500);
                if (Math.random() < 0.10) {
                    bill();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            exception.getMessage();
        }
        print();
    }

    private void bill() throws InterruptedException {
        int i = (int) (0 + result.size() * Math.random());
        String element = result.get(i).getElement();
        System.out.println(">Пользователь " + element + " оплатил платную услугу");
        System.out.println("Пользователь " + element);
        Thread.sleep(500);
    }

    private void removeKey() {
        client.del("Users");
    }
}
