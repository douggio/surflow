package com.ensuranceflow.submitter;

import com.ensuranceflow.common.lib.SpecificProcess;
import com.ensuranceflow.common.process.Process;
import com.ensuranceflow.common.process.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SubmitterQueueReader {

    @Autowired
    private ProcessService processService;

    private void readMessageFromQueue() {
        // TODO make this method all transactional
        // TODO use Factory to identify which process is coming from the queue
        SpecificProcess sp = new SpecificProcessExample();

        String specificId = sp.execute();
        String processClass = sp.getClassName();

        processService.save(new Process(specificId, processClass));
    }

}
