package com.ensuranceflow.submitter;

import com.ensuranceflow.common.lib.SpecificProcess;
import com.ensuranceflow.common.process.Process;
import com.ensuranceflow.common.process.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class SubmitterMessageReceiver {

    @Autowired
    private ProcessService processService;
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

    private void readMessageFromQueue() {
        // TODO make this method all transactional
        // TODO use Factory to identify which process is coming from the queue
        SpecificProcess sp = new SpecificProcessExample();

        String specificId = sp.execute();
        String processClass = sp.getClassName();

        processService.save(new Process(specificId, processClass));
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
