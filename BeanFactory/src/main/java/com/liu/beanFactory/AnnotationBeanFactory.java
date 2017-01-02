package com.liu.beanFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import com.liu.annotation.Bean;
import com.liu.annotation.Singleton;

public class AnnotationBeanFactory extends AbstractBeanFactory{
	   public AnnotationBeanFactory(String packageName) {
	        refreshBeans(packageName);

	        resolveDependence();
	    }
	    
	    private void refreshBeans(String packageName) {
	        List<String> classList = scanPackage(packageName);

	        for (String className : classList) {
	            debug("parse class: " + className);

	            try {
	                Class<?> c = Class.forName(className);
	                if (!c.isAnnotationPresent(Bean.class)) {
	                    debug("Skipped the non-bean class: " + c.getName());
	                    continue;
	                }

	                Bean bean = (Bean) c.getAnnotation(Bean.class);
	                String beanName = bean.value();
	                boolean isSingleton = true;
	                if (c.isAnnotationPresent(Singleton.class)) {
	                	Singleton singleton = (Singleton) c.getAnnotation(Singleton.class);
	                    isSingleton = singleton.value();
	                }

	                remainBean(beanName, c, isSingleton);
	            } catch (ClassNotFoundException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }

	    private void resolveDependence() {
	        for (Object object : singletonMap.values()) {
	            resovleDependence(object);
	        }
	    }
	    
	    private List<String> scanPackage(String packageName) {
	        List<String> clazzList = new ArrayList<String>();

	        String packagePath = packageName.replace(".", File.separator);
	        debug("packagePath: " + packagePath);

	        String systemPath = ClassLoader.getSystemResource("").getPath();
	        File systemDir = new File(systemPath);
	        debug("systemDir: " + systemDir.getAbsolutePath());

	        File packageDir = new File(systemPath, packagePath);
	        debug("packageDir: " + packageDir.getAbsolutePath());

	        clazzList = listClass(packageDir, systemDir);

	        return clazzList;
	    }

	    private List<String> listClass(File packageDir, File systemDir) {
	        List<String> classList = new ArrayList<>();

	        for (File childFile : packageDir.listFiles()) {
	            String filename = childFile.getAbsolutePath();

	            if (childFile.isDirectory()) {
	                debug("load the classes from sub-directory: " + childFile.getAbsolutePath());
	                classList.addAll(listClass(childFile, systemDir));
	                continue;
	            }

	            if (!filename.endsWith(".class")) {
	                debug("Skipped the non-class file: " + childFile.getAbsolutePath());
	                continue;
	            }

	            String systemPath = systemDir.getAbsolutePath();
	            String className = filename.replace(".class", "")
	                    .replace(systemPath + File.separator, "").replace(File.separator, ".");
	            debug("className: " + className);

	            classList.add(className);
	        }

	        return classList;
	    }
}
