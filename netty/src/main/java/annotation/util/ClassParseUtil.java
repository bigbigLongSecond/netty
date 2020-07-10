package annotation.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassParseUtil {

	public static List<Class<?>> getClass(String packagename) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		getPropertiesFolder();

		boolean flag = true;
		String packDir = packagename.replace('.', '/');
		//
		Enumeration<URL> dirs;

		try {
			dirs = Thread.currentThread().getContextClassLoader().getResources(packDir);
			while (dirs.hasMoreElements()) {
				URL url = (URL) dirs.nextElement();
				String protocol = url.getProtocol();

				if ("file".equals(protocol)) {
					String filePath = URLDecoder.decode(protocol, "UTF-8");
					findAndAddClassesInPackageByFile(url.getPath(), filePath, flag, classes);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return classes;
	}

	private static void findAndAddClassesInPackageByFile(String packagename, String filePath, final boolean flag,
			List<Class<?>> classes) {

		File dir = new File(packagename);
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		File[] dirFiles = dir.listFiles(new FileFilter() {

			public boolean accept(File pathname) {
				return (flag && pathname.isDirectory()) || (pathname.getName().endsWith(".class"));
			}
		});

		for (File file : dirFiles) {
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(file.getPath(), filePath, flag, classes);
			} else {
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					classes.add(Class.forName(packagename +"\\" +className+".class"));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

	}
	public static String getPropertiesFolder() {
		String path = "";
		String jarFilePath = getJarPath();
		try {
			jarFilePath = URLDecoder.decode(jarFilePath, "UTF-8");
			if (null != jarFilePath) {
				String[] filepaths = jarFilePath.split("/");
				path = jarFilePath.replace("/" + filepaths[filepaths.length - 1], "");
				if (!path.endsWith("/")) {
					path += "/";
				}
				// path = path.substring(1, path.length());
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return path;
	}


	public static String getJarPath() {
		return ClassParseUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	}

}
