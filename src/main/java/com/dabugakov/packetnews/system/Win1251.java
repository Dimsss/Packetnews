package com.dabugakov.packetnews.system;

import java.util.HashMap;

/**
 * Created by DABugakov on 17.11.2015.
 */
public class Win1251 {
    private static HashMap<Character, String> map = new HashMap<Character, String>();

    static  {
        map.put('А', "C0");
        map.put('В', "C2");
        map.put('Г', "C3");
        map.put('Д', "C4");
        map.put('Б', "C1");
        map.put('Е', "C5");
        map.put('Ж', "C6");
        map.put('З', "C7");
        map.put('И', "C8");
        map.put('Й', "C9");
        map.put('К', "CA");
        map.put('Л', "CB");
        map.put('М', "CC");
        map.put('Н', "CD");
        map.put('О', "CE");
        map.put('П', "CF");
        map.put('Р', "D0");
        map.put('С', "D1");
        map.put('Т', "D2");
        map.put('У', "D3");
        map.put('Ф', "D4");
        map.put('Х', "D5");
        map.put('Ц', "D6");
        map.put('Ч', "D7");
        map.put('Ш', "D8");
        map.put('Щ', "D9");
        map.put('Ъ', "DA");
        map.put('Ы', "DB");
        map.put('Ь', "DC");
        map.put('Э', "DD");
        map.put('Ю', "DE");
        map.put('Я', "DF");
        map.put('а', "E0");
        map.put('б', "E1");
        map.put('в', "E2");
        map.put('г', "E3");
        map.put('д', "E4");
        map.put('е', "E5");
        map.put('ж', "E6");
        map.put('з', "E7");
        map.put('и', "E8");
        map.put('й', "E9");
        map.put('к', "EA");
        map.put('л', "EB");
        map.put('м', "EC");
        map.put('н', "ED");
        map.put('о', "EE");
        map.put('п', "EF");
        map.put('р', "F0");
        map.put('с', "F1");
        map.put('т', "F2");
        map.put('у', "F3");
        map.put('ф', "F4");
        map.put('х', "F5");
        map.put('ц', "F6");
        map.put('ч', "F7");
        map.put('ш', "F8");
        map.put('щ', "F9");
        map.put('ъ', "FA");
        map.put('ы', "FB");
        map.put('ь', "FC");
        map.put('э', "FD");
        map.put('ю', "FE");
        map.put('я', "FF");
    }

    public static String convertStringToWin1251(String sentence) {
        String result = "";
        for (Character character : sentence.toCharArray()) {
            result += '%' + map.get(character);
        }
        return result;
    }


}
