package thinking.in.spring.bean.definition;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class test {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String encode = URLEncoder.encode("CC&DCC", StandardCharsets.UTF_8.toString());
        System.out.println(encode);
    }
}
