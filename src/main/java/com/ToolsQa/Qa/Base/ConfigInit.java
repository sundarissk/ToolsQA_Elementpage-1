package com.ToolsQa.Qa.Base;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigInit {
	public static Properties prop;

	public ConfigInit() {
		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream(
					"C:\\Users\\skuma\\Local-Repo\\ToolsQA\\src\\main\\java\\com\\ToolsQa\\Qa\\Config\\Config.properties");
			prop.load(ip);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
	}
}
