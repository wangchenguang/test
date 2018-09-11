package com.wangchg;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    private static final String POLICY_NO = "201-1-594-18-0000352867-00";
    private static final String PLAN_CODE = "PT02";

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\wangc\\Desktop\\catalina.2018-08-30.out";
        App app = new App();
        app.mapFile(fileName, new SearchHandler(PLAN_CODE));
    }

    static class SearchHandler implements Handler {
        private String text;

        private SearchHandler(String text) {
            this.text = text;
        }

        @Override
        public void handler(String val) {
            List<String> list = new ArrayList<>();
            if (val.contains(this.text)) {
                list.add(val);
            }
            for (String string : list) {
                System.out.println(string);
            }
        }
    }

    private void mapFile(String fileName, Handler handler) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "GB2312"));
        String tempString;
        while ((tempString = reader.readLine()) != null) {
            handler.handler(tempString);
        }
        reader.close();
    }

    interface Handler {
        void handler(String val);
    }
}
