package ru.bellintegrator.practice.model.wrapper;

public class ErrorWrap<T> {
        private  T error;

        public ErrorWrap(){

        }

        public ErrorWrap(T error) {
            this.error = error;
        }

        public T getError() {
            return error;
        }
}
