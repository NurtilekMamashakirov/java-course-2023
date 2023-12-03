package edu.hw8.task1;

import java.util.HashMap;
import java.util.Map;

public class InsultDictionary {

    private Map<String, String> insults = new HashMap<>();

    public InsultDictionary() {
        insults.put("личности", "Не переходи на личности там, где их нет");
        insults.put(
            "оскорбления",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"
        );
        insults.put(
            "глупый",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма."
        );
        insults.put("интеллект", "Чем ниже интеллект, тем громче оскорбления");
    }

    public String getInsult(String theme) {
        return insults.get(theme);
    }

    public void addInsult(String theme, String insult) {
        insults.put(theme, insult);
    }

}
