package cc.guoxingnan.wmgank.util;


public class StringUtils {


    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }


    public static String addZeroForTime(int time) {
        String newTime = "";
        if (time >= 0 && time < 10) {
            newTime = "0" + time;
        } else {
            newTime = String.valueOf(time);
        }
        return newTime;
    }

}
