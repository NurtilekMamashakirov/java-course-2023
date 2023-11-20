package edu.hw6.task6;

import java.util.HashMap;
import java.util.Map;

public class PortsNames {

    private Map<Integer, String> dictionary;

    @SuppressWarnings("MagicNumber")
    public PortsNames() {
        this.dictionary = new HashMap<>();
        dictionary.put(135, "EPMAP");
        dictionary.put(137, "Служба имен NetBIOS");
        dictionary.put(138, "Служба датаграмм NetBIOS");
        dictionary.put(139, "Служба сеансов NetBIOS");
        dictionary.put(445, "Microsoft-DS Active Directory");
        dictionary.put(843, "Adobe Flash");
        dictionary.put(1900, "Simple Service Discovery Protocol (SSDP)");
        dictionary.put(3702, "Динамическое обнаружение веб-служб");
        dictionary.put(5353, "Многоадресный DNS");
        dictionary.put(5355, "Link-Local Multicast Name Resolution (LLMNR)");
    }

    public Map<Integer, String> getDictionary() {
        return dictionary;
    }

}
