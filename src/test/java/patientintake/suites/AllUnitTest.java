package patientintake.suites;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Patient Intake Suite Tests")
@SelectPackages("patientintake")
@IncludeClassNamePatterns(".*Should")
public class AllUnitTest {
}
