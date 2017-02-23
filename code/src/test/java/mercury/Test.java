package mercury;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class Test {
	static String packageName = "com.mercury.entity";// 类包
	static String templateDir = "/src/main/webapp/WEB-INF/velocity/template/";
	static String sourcePath = System.getProperty("user.dir") + templateDir;
	static String resultDir = "/src/main/java/";
	static String targetPath = System.getProperty("user.dir") + resultDir + packageName.replace(".", "/");;

	public static void main(String[] args) throws IOException {
		String templateFile = "classTemplate.java";
		Properties pro = new Properties();
		pro.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
		pro.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
		pro.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, sourcePath);
		VelocityEngine ve = new VelocityEngine(pro);

		VelocityContext context = new VelocityContext();
		context.put("packageName", packageName);

		Template t = ve.getTemplate(templateFile, "UTF-8");
		String targetFile = "test2.java";
		File file = new File(targetPath, targetFile);
		System.out.println(file.getAbsolutePath());
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream outStream = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(outStream, "UTF-8");
		BufferedWriter sw = new BufferedWriter(writer);
		t.merge(context, sw);
		sw.flush();
		sw.close();
		outStream.close();
	}

}
