package com.prog.restbook.factory;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactoryProvider {

    private final TeacherFactory bookFactory;
    private final StudentFactory authorFactory;

    @Autowired
    public FactoryProvider(TeacherFactory bookFactory, StudentFactory authorFactory) {
        this.bookFactory = bookFactory;
        this.authorFactory = authorFactory;
    }

    public AbstractFactory<?> getFactory(String choice) {
        if ("Book".equalsIgnoreCase(choice)) {
            return bookFactory;
        } else if ("Author".equalsIgnoreCase(choice)) {
            return authorFactory;
        }
        throw new IllegalArgumentException("Unknown factory type: " + choice);
    }
}