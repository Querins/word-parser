package cisco.java.challenge.test;

import cisco.java.challenge.Main;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParseTests {

    private String convertPath(String name) {
        try {
            return getClass().getClassLoader().getResource(name).getFile().replaceFirst("/", "");
        } catch (Exception e) {
            throw new RuntimeException("Can't process resource", e.getCause());
        }
    }

    @Test
    public void parseSimpleWordsTest() throws IOException {

        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        expected.put("bb", 1);

        Assert.assertTrue(Main.parseWords(convertPath("1.txt")).equals(expected));
    }

    @Test
    public void parseWordsTestSimple() throws IOException {

        Map<String, Integer> expected = new HashMap<>();
        expected.put("qw", 1);
        expected.put("ac", 1);
        expected.put("ss", 3);

        Assert.assertTrue(Main.parseWords(convertPath("2.txt")).equals(expected));
    }

}
