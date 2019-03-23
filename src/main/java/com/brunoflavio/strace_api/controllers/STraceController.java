package com.brunoflavio.strace_api.controllers;

import com.brunoflavio.strace_api.dto.STraceData;
import com.brunoflavio.strace_api.services.STraceService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;

import javax.inject.Inject;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Controller("/strace")
public class STraceController {

    private final STraceService sTraceService;

    @Inject
    STraceController(STraceService sTraceService) {
        this.sTraceService = sTraceService;
    }

    @Get
    public String index() {
        return "use /strace/PID/NUMBER_OF_LINES";
    }

    @Get(uri = "/{pid}/{numberOfLines}", produces = MediaType.APPLICATION_JSON)
    public Collection<STraceData> index(int pid, int numberOfLines) throws IOException {

        return this.sTraceService.monitorProcess(pid, numberOfLines);

    }




}
