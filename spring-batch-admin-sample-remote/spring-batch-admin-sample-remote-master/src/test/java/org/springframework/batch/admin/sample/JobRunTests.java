package org.springframework.batch.admin.sample;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;

@ContextConfiguration(locations ={"classpath:job-repository.xml","classpath:/META-INF/spring/batch/jobs/applicationContext-master.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode=ClassMode.AFTER_CLASS)
public class JobRunTests {

	@Autowired
	private JobLauncher jobLauncher;

	private JobParameters jobParameters = new JobParametersBuilder().addString("fail", "false").toJobParameters();

	@Autowired
	@Qualifier("footballJob")
	private Job footballJob;

	private SimpleJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	@Test
	public void testSimpleProperties() throws Exception {
		assertNotNull(jobLauncher);
	}
	
	@Test
	public void testPlayerJob() throws Exception {
		int before = SimpleJdbcTestUtils.countRowsInTable(jdbcTemplate, "BATCH_STEP_EXECUTION");
		JobExecution jobExecution = jobLauncher.run(footballJob, jobParameters);
		assertNotNull(jobExecution);
		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
		int after = SimpleJdbcTestUtils.countRowsInTable(jdbcTemplate, "BATCH_STEP_EXECUTION");
		assertEquals(before + 1, after);
	}

}
