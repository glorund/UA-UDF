package com.epam.hive.udf;

import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import eu.bitwalker.useragentutils.UserAgent;

public class UserAgentParser extends UDF {

    public Map<String,String> evaluate(Text input) {
        UserAgent userAgent = UserAgent.parseUserAgentString(input.toString());
        Map<String,String> results =  new HashMap<>();
        results.put("device",userAgent.getOperatingSystem().getDeviceType().getName());
        results.put("OS",userAgent.getOperatingSystem().getName());
        results.put("Browser",userAgent.getBrowser().getName());
        results.put("UA",userAgent.getBrowser().getBrowserType().getName());
        return results;
    }
}
