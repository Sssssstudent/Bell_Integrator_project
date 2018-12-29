package ru.bellintegrator.practice.model.response;

public class Response {
    public Boolean succeess;

    public Response(){}

    public Boolean getSucceess() {
        return succeess;
    }

    public Response setSucceess(Boolean succeess) {
        this.succeess = succeess;
        return this;
    }

    @Override
    public String toString(){return "{result:" + succeess + "}";}}
