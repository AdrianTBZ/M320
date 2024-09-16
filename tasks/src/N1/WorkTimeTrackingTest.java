package N1;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WorkTimeTrackingTest {

	private WorkTimeTracking tracking;

	@Before
	public void setUp() {
		tracking = new WorkTimeTracking("", "", 0);
	}

	@Test
	public void addWorkTime() {

		String customer = "CustoFFmer1";
		String project = "Project X";
		double hours = 5.0;

		tracking.addWorkTime(customer, project, hours);

		List<WorkTimeTracking> workTimes = tracking.getWorkTimeList();
		assertEquals(1, workTimes.size());
	}

}
