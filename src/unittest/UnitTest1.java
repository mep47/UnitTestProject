package unittest;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class UnitTest1 {
	
static public void main(String[] args)
{
	UnitTest1 unitTest1 = new UnitTest1();
	unitTest1.test1();
}

//@Test
public void test1()
{
	System.out.println("Running UnitTest1");
	File file = new File("/var/lib/jenkins/workspace/JenkinsTest/build/jar/JenkinsTest.jar");
	file.setExecutable(true, true);
	
    ProcessBuilder builder = new ProcessBuilder(
            "java", "-jar", "/var/lib/jenkins/workspace/JenkinsTest/build/jar/JenkinsTest.jar");
        builder.redirectErrorStream(true);
        Process p = null;
		try {
			p = builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        try {
			line = r.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(line);
//        assertEquals("The results of test1 must match", "Jenkins Test\n", line);
}

}
