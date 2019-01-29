package com.brunoflavio.strace_api.dto;

/**
 * The simplest possible DTO (and model) to convey the output of the strace application.
 * With more elaborate parsing we could get nice properties, such as the timestamp, function, etc..
 */
public class STraceData {

    /**
     * Represents a line of output from strace.
     */
    String data;

    public STraceData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }
}
