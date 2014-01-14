package com.mql.strut.web.actions;

import java.io.File;

import javax.ejb.Stateless;

import org.apache.commons.io.FileUtils;

@Stateless
public class ImporterExcelAction {

	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String url;
	
	
	
	
	public String execute(){
		try {
			System.out.println("Debut uploaded");
			url=System.getProperty("java.io.tmpdir");
			System.out.println("le src nom du fichier "+myFile);
			System.out.println("le dest nom du fichier "+myFileFileName);
			File destFile=new File(url+"/",myFileFileName);
			FileUtils.copyFile(myFile, destFile);
			System.out.println("Fin uploaded");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
	public File getMyFile() {
		return myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public String getUrl() {
		return url;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
