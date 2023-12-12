package ReportsListeners;



import com.ToolsQa.Qa.Base.DriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterBase extends DriverManager {

	
	static ExtentReports extend;

	public static ExtentReports extentReporterGenerator() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("DsAlog Test Results");

		extend = new ExtentReports();
		extend.attachReporter(reporter);
		extend.setSystemInfo("Tester", "Sundari");
		return extend;
	}

}
