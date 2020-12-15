package com.ensuranceflow.submitter;

import com.ensuranceflow.common.lib.SpecificProcess;

import java.util.UUID;

public class SpecificProcessExample implements SpecificProcess {

    @Override
    public String execute() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getClassName() {
        return this.getClass().getName();
    }
}