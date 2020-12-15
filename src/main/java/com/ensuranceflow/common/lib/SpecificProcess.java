package com.ensuranceflow.common.lib;

import java.util.UUID;

public interface SpecificProcess {
    // This method should execute the specific implementation and return the UUID of the related entry
    String execute();

    // This method should return the full class name that implements this interface
    String getClassName();
}
