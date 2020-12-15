package com.ensuranceflow.common.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {

    @Autowired
    private ProcessRepository processRepository;

    public Process save(Process process) {
        return processRepository.save(process);
    }

    public List<Process> findPendingProcesses() {
        return processRepository.findByProcessState(ProcessState.PENDING);
    }
}
