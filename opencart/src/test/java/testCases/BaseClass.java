package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	static WebDriver driver;
	public Logger logger;
	Properties p;
	
	@BeforeClass(groups= {"regression","sanity","master"})
	@Parameters({"browser"})
	public void setup(String br) throws IOException {
		
		FileReader fis =new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(fis);
			
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver();break;
		case "edge": driver = new EdgeDriver();break;
		default: System.out.println("No Such browserfound");return;
		}
		System.out.println(br);
		logger=LogManager.getLogger(this.getClass());
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
		
		
	}

	@AfterClass(groups= {"regression","sanity","master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomeNumeric()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	public String randomeAlphaNumeric()
	{
		String generatedString1=RandomStringUtils.randomNumeric(3);
		String generatedString2=RandomStringUtils.randomNumeric(3);
		return generatedString1+"@"+generatedString2;
	}
	

	public String captureScreen(String tname) {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}

}
