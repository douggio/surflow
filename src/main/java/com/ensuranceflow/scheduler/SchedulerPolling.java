package com.ensuranceflow.scheduler;

import com.ensuranceflow.common.process.Process;
import com.ensuranceflow.common.process.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerPolling {

    @Autowired
    private ProcessService processService;

    // TODO Make this run periodically
    private void findExecutableProcess() {
        List<Process> processes = processService.findPendingProcesses();



    }

}
