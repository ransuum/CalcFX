package org.example.calcfx.service;

import org.example.calcfx.enums.Equal;
import org.example.calcfx.main.Menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelperService extends Menu {

    public HelperService(String function) {
        super(function);
    }

    @Override
    public String getAfterEquals() {
        StringBuilder s = new StringBuilder();

        int equals = 0;

        for (int i = 0; i < getFunction().length(); i++) {
            if (getFunction().charAt(i) == '=') equals = i;
        }

        for (int i = equals + 1; i < getFunction().length(); i++) {
            s.append(getFunction().charAt(i));
        }

        return s.toString();
    }

    @Override
    public String getBeforeEquals() {
        StringBuilder s = new StringBuilder();

        int i = 0;
        while (i < getFunction().length() && getFunction().charAt(i) != '=') {
            s.append(getFunction().charAt(i));
            i++;
        }

        return s.toString();
    }

    @Override
    public void putInList() {
        String before = getBeforeEquals();
        String after = getAfterEquals();

        findX(before, Equal.BEFORE);
        findDigits(before, Equal.BEFORE);

        findX(after, Equal.AFTER);
        findDigits(after, Equal.AFTER);

    }

    @Override
    public double answer() {
        int res = 0;

        for (Integer i : getAfterEqual()) res += i;

        for (Integer i : getBeforeEqual()) res -= i;

        int xRes = 0;

        for (Integer i : getxBeforeEqual()) {
            xRes += i;
        }

        for (Integer i : getxAfterEqual()) {
            xRes -= i;
        }

        double answer = (double) res / xRes;

        if (answer > 0 && (answer - (int) answer) > 0.7) return (int) answer + 1;
        else return (int) answer;

    }

    private void findDigits(String function, Equal equal) {
//        char[] characters = function.toCharArray();
//
//        for (int i = 0; i < characters.length; i++) {
//            if (Character.isDigit(characters[i]) ||
//                    (characters[i] == '-' && i + 1 < characters.length && Character.isDigit(characters[i + 1]))) {
//
//                StringBuilder stringBuilder = new StringBuilder();
//                stringBuilder.append(characters[i]);
//
//                while (i + 1 < characters.length && Character.isDigit(characters[i + 1])) {
//                    i++;
//                    stringBuilder.append(characters[i]);
//                }
//
//                int number = Integer.parseInt(stringBuilder.toString());
//
//                if (equal == Equal.BEFORE) {
//                    getBeforeEqual().add(number);
//                } else {
//                    getAfterEqual().add(number);
//                }
//            }
//        }
        Matcher matcher = Pattern.compile("(-?\\d+)(?!x)").matcher(function);
        while (matcher.find()) {
            String kef = matcher.group(1);
            int number = Integer.parseInt(kef);
            if (equal == Equal.BEFORE) {
                getBeforeEqual().add(number);
            } else {
                getAfterEqual().add(number);
            }
        }
    }

    private void findX(String function, Equal equal) {
//        char[] characters = function.toCharArray();
//
//        for (int i = 0; i < characters.length; i++) {
//            StringBuilder stringBuilder = new StringBuilder();
//
//            if (characters[i] == 'x'
//                    || (characters[i] == '-' && i + 1 < characters.length && characters[i + 1] == 'x')) {
//                if (characters[i] == 'x') stringBuilder.append("1");
//                else stringBuilder.append(characters[i]);
//
//                while (i + 1 < characters.length && characters[i + 1] == 'x') {
//                    i++;
//                    stringBuilder.append("1");
//                }
//
//                int number = Integer.parseInt(stringBuilder.toString());
//
//                if (!stringBuilder.isEmpty()) {
//                    if (equal == Equal.BEFORE) {
//                        getxBeforeEqual().add(number);
//                    } else {
//                        getxAfterEqual().add(number);
//                    }
//                }
//            }

            Matcher matcher = Pattern.compile("(-?\\d*)x").matcher(function);
        while (matcher.find()) {
            String kef = matcher.group(1);
            int number = kef.isEmpty() ? 1 : (kef.equals("-") ? -1 : Integer.parseInt(kef));
            if (equal == Equal.BEFORE) {
                getxBeforeEqual().add(number);
            } else {
                getxAfterEqual().add(number);
            }
        }
    }
}
