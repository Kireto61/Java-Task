package com.example.romancalculator;

import javafx.scene.control.Alert;

import java.util.regex.Pattern;

public class Logic {

    private static final String PATTERN = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    private static final Pattern COMPILE = Pattern.compile(PATTERN);


    public String intToRoman(int num) {
        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD",
                "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL",
                "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV",
                "V", "VI", "VII", "VIII", "IX"};

        // Converting to roman
        String thousands = m[num / 1000];
        String hundereds = c[(num % 1000) / 100];
        String tens = x[(num % 100) / 10];
        String ones = i[num % 10];

        return thousands + hundereds + tens + ones;
    }

    int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    public String calculate(String txt) {
        String[] tokens = txt.split(" ");
        String one = tokens[0];
        String two = tokens[2];
        if (one.length() >= 8 || two.length() >= 8 || !COMPILE.matcher(one).find() || !COMPILE.matcher(two).find()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Number cannot be more than 8 symbols");
            alert.show();
            return null;
        }
        int oneNum = romanToDecimal(one);
        int twoNum = romanToDecimal(two);
        int result;
        if (tokens[1].equals("+")) {
            result = oneNum + twoNum;
        } else {
            result = oneNum - twoNum;
        }
        String res = intToRoman(result);
        if (result < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Number cannot be less than 0");
            alert.show();
            return null;
        }
        return res;
    }

    int romanToDecimal(String str) {
        if (!COMPILE.matcher(str).find()) {
            throw new IllegalArgumentException("ERR");
        }
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            int s1 = value(str.charAt(i));
            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));
                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
            }
        }
        return res;
    }
}
