package com.ensuranceflow.common.process;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "process")
public class Process {
    public Integer getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getProcessClass() {
        return processClass;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public Date getCompleteBy() {
        return completeBy;
    }

    public ProcessState getProcessState() {
        return processState;
    }

    public int getFailureCount() {
        return failureCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String externalId;
    private String processClass;
    private String lockedBy;
    private Date completeBy;
    private ProcessState processState;
    private int failureCount;

    // Constructor

    public Process() {
    }

    public Process(String externalId, String processClass, String lockedBy, Date completeBy, ProcessState processState, int failureCount) {
        this.externalId = externalId;
        this.processClass = processClass;
        this.lockedBy = lockedBy;
        this.completeBy = completeBy;
        this.processState = processState;
        this.failureCount = failureCount;
    }

    // Instantiate a new pending process
    public Process(String externalId, String processClass) {
        this.externalId = externalId;
        this.processClass = processClass;
        this.lockedBy = null;
        this.completeBy = null;
        this.processState = ProcessState.PENDING;
        this.failureCount = 0;
    }
}
