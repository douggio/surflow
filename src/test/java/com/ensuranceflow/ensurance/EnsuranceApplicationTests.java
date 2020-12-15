package com.ensuranceflow.ensurance;

import com.ensuranceflow.common.process.Process;
import com.ensuranceflow.common.process.ProcessRepository;
import com.ensuranceflow.common.process.ProcessService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EnsuranceApplicationTests {

	@Autowired
	private ProcessService processService;

	@Autowired
	private ProcessRepository processRepository;

	@BeforeAll
	@AfterAll
	void cleanUpDatabase() {
		processRepository.deleteAll();
	}

	@Test
	void newProcess_mustBePending() {
		Process newProcess = new Process("external_id", "some_class");
		processService.save(newProcess);

		List<Process> retrievedProcesses = processService.findPendingProcesses();

		assert (retrievedProcesses.size() == 1);
		assert (retrievedProcesses.get(0).getId() != null);
	}

}
