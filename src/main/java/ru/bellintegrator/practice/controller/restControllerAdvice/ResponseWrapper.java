package ru.bellintegrator.practice.controller.restControllerAdvice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import ru.bellintegrator.practice.model.response.ApiErrorResponse;
import ru.bellintegrator.practice.model.wrapper.DataWrap;
import ru.bellintegrator.practice.model.wrapper.ErrorWrap;
import ru.bellintegrator.practice.model.response.Result;

@RestControllerAdvice
public class ResponseWrapper implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, java.lang.Class<? extends HttpMessageConverter<?>> converterType ) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ApiErrorResponse || body instanceof Exception){
            return new ErrorWrap(body);
        }
        else if (body instanceof Boolean){
            if((Boolean) body == true){
                return new Result(Result.RESULT_SUCCESS);
            }

            else {
                return new Result(Result.RESULT_NOT_SUCCESS);
            }
        }
        else {
            return new DataWrap(body);
        }

    }
}
