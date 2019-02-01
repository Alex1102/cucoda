package com.mycompany.cucoda.api;

public class VersionData {
	public static final String MAJOR = "${project.version.major}";
	public static final String MINOR = "${project.version.minor}";
	public static final String MICRO = "${project.version.micro}";
	public static final String VERSION_QUALIFIER = "${project.version.suffix}";

	public static final String JNDI_MODULE_NAME = "${cucoda-core.finalName}";
	public static final String JNDI_APP_NAME = "${cucoda-ear.finalName}";

	public static final String MAJOR_MINOR = "${project.version.major}.${project.version.minor}";
	public static final String MAJOR_MINOR_QUALIFIER = "${project.version.major}.${project.version.minor}${project.version.suffix}";
	public static final String JMS_VERSION = "${project.version.major}.${project.version.minor}${project.version.suffix}";
}