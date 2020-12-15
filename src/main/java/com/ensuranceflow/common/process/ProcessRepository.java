package com.ensuranceflow.common.process;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProcessRepository extends CrudRepository<Process, Integer> {
    List<Process> findByProcessState(ProcessState processState);
}
