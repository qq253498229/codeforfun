package cn.codeforfun;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;

public class TestJava {
  @Test
  public void test1(){
    String a = "aaa😁";
    System.out.println(a);
    String s = StringEscapeUtils.escapeJava(a);
    System.out.println(s);
    System.out.println();
    System.out.println("\\u54C8\\u54C8\\u54C8");
    System.out.println(StringEscapeUtils.unescapeJava("\\u54C8\\u54C8\\u54C8"));
  }
}
