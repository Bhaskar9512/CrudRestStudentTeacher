package com.prog.restbook.factory;

public interface AbstractFactory<T> {
    T create(String type);
}

