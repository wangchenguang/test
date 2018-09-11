package com.wangchg;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2018/9/11
 */
public class XmlToJavaBean {
    private Configuration cfg;

    public XmlToJavaBean(String classPath4Template) {
        cfg = new Configuration(Configuration.VERSION_2_3_28);
        try {
            cfg.setDirectoryForTemplateLoading(new File(XmlToJavaBean.class.getResource(classPath4Template).getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public Template getTemplate(String name) throws IOException {
        return cfg.getTemplate(name);
    }

    public List<Map<String, Object>> generateParams(String path) {
        Map<String, Object> root = new HashMap<>(1);
        List<Map<String, Object>> params = new ArrayList<>();
        root.put("user", "Big Joe");
        Map<String, Object> latest = new HashMap<>(2);
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");
        params.add(root);
        return params;
    }

    public void outputConsole(Template template, Map<String, Object> root) throws IOException, TemplateException {
        Writer out = new OutputStreamWriter(System.out);
        template.process(root, out);
    }

    public static void main(String[] args) throws IOException, TemplateException {
        String path = "";
        XmlToJavaBean xmlToJavaBean = new XmlToJavaBean("/tml");
        Template template = xmlToJavaBean.getTemplate("test.html");
        List<Map<String, Object>> params = xmlToJavaBean.generateParams(path);
        for (Map<String, Object> param : params) {
            xmlToJavaBean.outputConsole(template, param);
        }
    }

}
