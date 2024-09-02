package org.example.calcfx.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Menu {
    private List<Object> afterEqual = new ArrayList<Object>();
    private List<Object> beforeEqual = new ArrayList<Object>();
    private LinkedList<Double> result = new LinkedList<>();
    private String function;

    public Menu(String function) {
        this.function = function;
    }

    public abstract String getAfterEquals();
    public abstract String getBeforeEquals();
    public abstract void putInList();

    public List<Object> getAfterEqual() {
        return afterEqual;
    }

    public void setAfterEqual(List<Object> afterEqual) {
        this.afterEqual = afterEqual;
    }

    public List<Object> getBeforeEqual() {
        return beforeEqual;
    }

    public void setBeforeEqual(List<Object> beforeEqual) {
        this.beforeEqual = beforeEqual;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public LinkedList<Double> getResult() {
        return result;
    }

    public void setResult(LinkedList<Double> result) {
        this.result = result;
    }
}
