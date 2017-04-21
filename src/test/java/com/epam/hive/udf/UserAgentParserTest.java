package com.epam.hive.udf;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.apache.hadoop.io.Text;
import org.junit.Test;

public class UserAgentParserTest {
    @Test
    public void evaluateText() {
        UserAgentParser target = new UserAgentParser();
        Map<String,String> actual = target.evaluate(new Text("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1"));
        assertEquals("{OS=Windows 7, UA=Browser, device=Computer, Browser=Chrome 21}", actual.toString());
    }
}
