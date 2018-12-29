package ru.bellintegrator.practice.model.wrapper;

public class DataWrap<T> {
    private T data;

    public DataWrap(){

    }

    public DataWrap(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
