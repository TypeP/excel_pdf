package kr.inflearn;

import java.io.*;
import java.net.URL;

public class DownloadBroker implements Runnable{
	private String address;
	private String fileName;
	
	public DownloadBroker() {
		// TODO Auto-generated constructor stub
	}

	public DownloadBroker(String address, String fileName) {
		super();
		this.address = address;
		this.fileName = fileName;
	}
	
	
	@Override
	public void run() {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			 
			URL url= new URL(address);
			
			InputStream is=url.openStream();
			BufferedInputStream input=new BufferedInputStream(is);
			
			int data;
			
			while((data=input.read())!=-1) {
				bos.write(data);
			}
			bos.close();
			input.close();
			System.out.println("download complete...");
			System.out.println(fileName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
