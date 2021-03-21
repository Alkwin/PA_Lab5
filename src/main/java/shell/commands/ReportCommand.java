package shell.commands;

import catalog.Catalog;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCommand extends Command {
    public ReportCommand() {
        commandName = "report";
    }

    public void executeReportCommand(Catalog catalog) throws IOException, TemplateException {
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File("media/templates/"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> root = new HashMap<>();

        var list = catalog.getItems().toString();

        root.put("items", list);

        Template temp = cfg.getTemplate("test.ftlh.html");

        Writer out = new OutputStreamWriter(System.out);

        temp.process(root, out);
    }
}
