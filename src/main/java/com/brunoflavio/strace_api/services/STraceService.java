package com.brunoflavio.strace_api.services;

import com.brunoflavio.strace_api.dto.STraceData;

import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A very crude service to monitor strace output.
 */
@Singleton
public class STraceService {

    /**
     * Attempts to launch strace to monitor the given process and it's forks.
     * @param pid the process id to monitor
     * @param numberOfLines the number of lines to capture
     * @return a list of strace output lines
     * @throws IOException
     */
    public Collection<STraceData> monitorProcess(int pid, int numberOfLines) throws IOException {

        ProcessBuilder straceProcessBuilder = new ProcessBuilder(
                "strace",
                "-f",
                "-tt",
                "-p",
                Integer.toString(pid));
        straceProcessBuilder.redirectErrorStream();

        Process straceProcess = straceProcessBuilder.start();

        try (InputStream inputStream = straceProcess.getErrorStream()) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            ArrayList<STraceData> output = new ArrayList<>();

            String line;
            while (((line = reader.readLine()) != null) && output.size() <= numberOfLines) {
                output.add(new STraceData(line));
            }
            return output;
        }
        finally {
            straceProcess.destroy();
        }
    }
}