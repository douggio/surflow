package com.ensuranceflow.ensurance;

import com.ensuranceflow.common.process.Process;
import com.ensuranceflow.common.process.ProcessRepository;
import com.ensuranceflow.common.process.ProcessService;
import com.ensuranceflow.fakeapp.MessageSender;
import org.junit.jupiter.api.*;
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

	@Autowired
	private MessageSender messageSender;

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

	@Test
	void sendMessage() {
		Assertions.assertDoesNotThrow(() -> messageSender.sendMessage("hello darkness my old friend"));
	}

}
