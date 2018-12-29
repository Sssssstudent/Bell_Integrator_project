package ru.bellintegrator.practice.model.response;

public class Result {
    public static final String RESULT_SUCCESS = "success";
    public static final String RESULT_NOT_SUCCESS = "no success";

    private String result;

    public Result(){

    }

    public Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
