package com.lazerycode.jmeter.analyzer.config;

import com.lazerycode.jmeter.analyzer.ResultRenderHelper;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Properties;

/**
 * Stores information used by several objects
 *
 * @author caiqiuliang
 */
public enum Environment {

  /**
   * This is the only instance of this enum.
   */
  ENVIRONMENT;

  public static final int DEFAULT_MAXSAMPLES = 50000;

  public static final String ISO8601_FORMAT = "yyyyMMdd'T'HHmmssZ";

  /**
   * true, if charts should be generated
   */
  private boolean generateCharts;

  /**
   * true, if response sizes and response durations should be provided for each uri
   */
  private boolean generateCSVs;

  /**
   * Template directory where custom freemarker templates are stored.
   */
  private File templateDirectory;
  private ResultRenderHelper resultRenderHelper;
  private Properties remoteResources;
  private LinkedHashMap<String,String> requestGroups;
  private int maxSamples = DEFAULT_MAXSAMPLES;
  private Configuration configuration;
  private File targetDirectory;
  /**
   * database configuration
   */
  private String username;
  private String pwd;
  private String host;
  private String database;

  public void clear() {
    this.templateDirectory = null;
    this.resultRenderHelper = null;
    this.remoteResources = null;
    this.requestGroups = null;
    this.maxSamples = 0;
    this.configuration = null;
    this.targetDirectory = null;
    this.username = null;
    this.pwd = null;
    this.host = null;
    this.database = null;
  }

  public File getTargetDirectory() {
    return targetDirectory;
  }

  public void setTargetDirectory(File targetDirectory) {
    this.targetDirectory = targetDirectory;
  }

  public boolean isGenerateCharts() {
    return generateCharts;
  }

  public void setGenerateCharts(boolean generateCharts) {
    this.generateCharts = generateCharts;
  }

  public boolean isGenerateCSVs() {
    return generateCSVs;
  }

  public void setGenerateCSVs(boolean generateCSVs) {
    this.generateCSVs = generateCSVs;
  }

  public File getTemplateDirectory() {
    return templateDirectory;
  }

  public void setTemplateDirectory(File templateDirectory) {
    this.templateDirectory = templateDirectory;
  }

  public ResultRenderHelper getResultRenderHelper() {
    return resultRenderHelper;
  }

  public void setResultRenderHelper(ResultRenderHelper resultRenderHelper) {
    this.resultRenderHelper = resultRenderHelper;
  }

  public Properties getRemoteResources() {
    return remoteResources;
  }

  public void setRemoteResources(Properties remoteResources) {
    this.remoteResources = remoteResources;
  }

  public LinkedHashMap<String, String> getRequestGroups() {
    return requestGroups;
  }

  public void setRequestGroups(LinkedHashMap<String, String> requestGroups) {
    this.requestGroups = requestGroups;
  }

  public int getMaxSamples() {
    return maxSamples;
  }

  public void setMaxSamples(int maxSamples) {
    this.maxSamples = maxSamples;
  }

  public Configuration getConfiguration() {
    return configuration;
  }

  /**
   * Initialize Freemarker Configuration
   */
  public void initializeFreemarkerConfiguration() {

    configuration = new Configuration();

    //make maps work in Freemarker when map key is not a String
    BeansWrapper beansWrapper = BeansWrapper.getDefaultInstance();
    beansWrapper.setSimpleMapWrapper(true);
    configuration.setObjectWrapper(beansWrapper);

    //make sure that numbers are not formatted as 1,000 but as 1000 instead
    configuration.setNumberFormat("computer");

    //TODO: make configurable?
    configuration.setDateFormat(ISO8601_FORMAT);

    configuration.setAutoFlush(true);
  }

/**
 * @return the username
 */
public String getUsername() {
	return username;
}

/**
 * @param username the username to set
 */
public void setUsername(String username) {
	this.username = username;
}

/**
 * @return the pwd
 */
public String getPwd() {
	return pwd;
}

/**
 * @param pwd the pwd to set
 */
public void setPwd(String pwd) {
	this.pwd = pwd;
}

/**
 * @return the host
 */
public String getHost() {
	return host;
}

/**
 * @param host the host to set
 */
public void setHost(String host) {
	this.host = host;
}

/**
 * @return the database
 */
public String getDatabase() {
	return database;
}

/**
 * @param database the database to set
 */
public void setDatabase(String database) {
	this.database = database;
}

}
