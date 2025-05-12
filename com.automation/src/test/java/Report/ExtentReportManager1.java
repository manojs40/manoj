package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager1 {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/ExtentReport.html");
			sparkReporter.config().setDocumentTitle("Automation Test Report");
			sparkReporter.config().setReportName("AutomationExercise Test Report");
            
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		}
		return extent;
	}
}
