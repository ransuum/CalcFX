package org.example.calcfx.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Menu {
    private List<Integer> afterEqual = new ArrayList<>();
    private List<Integer> beforeEqual = new ArrayList<>();
    private LinkedList<Double> result = new LinkedList<>();
    private List<Integer> xBeforeEqual = new ArrayList<>();
    private List<Integer> xAfterEqual = new ArrayList<>();
    private String function;

    public Menu(String function) {
        this.function = function;
    }

    public abstract String getAfterEquals();

    public abstract String getBeforeEquals();

    public abstract void putInList();
    public abstract double answer();

    public List<Integer> getAfterEqual() {
        return afterEqual;
    }

    public void setAfterEqual(List<Integer> afterEqual) {
        this.afterEqual = afterEqual;
    }

    public List<Integer> getBeforeEqual() {
        return beforeEqual;
    }

    public void setBeforeEqual(List<Integer> beforeEqual) {
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

    public List<Integer> getxBeforeEqual() {
        return xBeforeEqual;
    }

    public void setxBeforeEqual(List<Integer> xBeforeEqual) {
        this.xBeforeEqual = xBeforeEqual;
    }

    public List<Integer> getxAfterEqual() {
        return xAfterEqual;
    }

    public void setxAfterEqual(List<Integer> xAfterEqual) {
        this.xAfterEqual = xAfterEqual;
    }
}
