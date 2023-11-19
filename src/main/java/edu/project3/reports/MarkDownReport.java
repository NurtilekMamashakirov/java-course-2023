package edu.project3.reports;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MarkDownReport extends AbstractReport {
    private static final Logger LOGGER = LogManager.getLogger();

    public MarkDownReport(
        Map<String, String> commonInfo,
        Map<String, Long> resources,
        Map<Integer, Long> codes,
        Map<String, Long> httpRequestMethods,
        Map<String, Long> httpUserAgent
    ) {
        super(commonInfo, resources, codes, httpRequestMethods, httpUserAgent);
    }

    @Override
    @SuppressWarnings("MultipleStringLiterals")
    public void getReport() {
        StringBuilder sb = new StringBuilder();

        sb.append("# Анализ Nginx-логов\n");
        sb.append("### Общая информация\n\n");
        sb.append("|Метрика|Значение|\n").append("|:-:|:-:|\n");
        for (String key : commonInfo.keySet()) {
            sb.append("|").append(key).append("|").append(commonInfo.get(key)).append("|\n");
        }

        sb.append("\n### Запрашиваемые ресурсы\n\n");
        sb.append("|Ресурс|Количество|\n").append("|:-:|:-:|\n");
        for (String key : resources.keySet()) {
            sb.append("|").append(key).append("|").append(resources.get(key)).append("|\n");
        }

        sb.append("\n### Коды ответа\n\n");
        sb.append("|Код|Имя|Количество|\n").append("|:-:|:-:|:-:|\n");
        for (Integer key : codes.keySet()) {
            sb.append("|").append(key).append("|").append(codeToDescription.get(key)).append("|").append(codes.get(key))
                .append("|\n");
        }

        sb.append("\n### Методы HTTP-запросов\n\n");
        sb.append("|Метод|Количество|\n").append("|:-:|:-:|\n");
        for (String key : httpRequestMethods.keySet()) {
            sb.append("|").append(key).append("|").append(httpRequestMethods.get(key)).append("|\n");
        }

        sb.append("\n### HTTP User agents\n\n");
        sb.append("|User agent|Количество|\n").append("|:-:|:-:|\n");
        for (String key : httpUserAgent.keySet()) {
            sb.append("|").append(key).append("|").append(httpUserAgent.get(key)).append("|\n");
        }

        Path path = Path.of("src/main/java/edu/project3/results/log_report.md");
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException ex) {
                LOGGER.error("Не удалось создать MarkDown-отчет!", ex);
                throw new RuntimeException(ex);
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(sb.toString());
        } catch (IOException ex) {
            LOGGER.error("Не удалось записать данные в MarkDown-отчет!", ex);
            throw new RuntimeException(ex);
        }
    }
}
