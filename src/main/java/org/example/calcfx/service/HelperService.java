package org.example.calcfx.service;

public class HelperService extends Menu{

    public HelperService(String function) {
        super(function);
    }

    @Override
    public String getAfterEquals() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < getFunction().length(); i++) {
            if (getFunction().charAt(i) == '=') break;
            s.append(getFunction().charAt(i));
        }


        return s.toString();
    }

    @Override
    public String getBeforeEquals() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < getFunction().length(); i++) {
            for (int j = i + 1; j < getFunction().length(); j++) {
                if (getFunction().charAt(i) == '='){
                    s.append(getFunction().charAt(j));
                }
            }
        }

        return s.toString();
    }

    @Override
    public void putInList() {
        String before = getBeforeEquals();
        for (int i = 0; i < before.length(); i++) {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(before.charAt(i));

            for (int j = i + 1; j < before.length(); j++) {

                if ((before.charAt(i) == '-' || before.charAt(i) == '+')
                        && Character.isDigit(before.charAt(j))) {
                    stringBuilder.append(before.charAt(j));
                } else stringBuilder.deleteCharAt(0);
            }

            getBeforeEqual().add(stringBuilder);
        }
    }
}
