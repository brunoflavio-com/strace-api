package com.brunoflavio.strace_api;

import io.micronaut.runtime.Micronaut;

/**
 * The strace-api application.
 * <p>
 * This is a very simple application, it outputs a number of strace lines for a given process.
 * In a WebApi.
 * <p>
 * It was built in order to experiment with the sidecar microservices pattern,
 * as explained in the book “Designing Distributed Systems by Brendan Burns (O’Reilly). Copyright 2018 Brendan Burns, 978-1-491-98364-5.”
 *
 */
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}