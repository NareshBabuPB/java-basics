package com.naresh.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreaming {

	public static void main(String[] args) {
		copyImage();

	}

	private static void copyImage() {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("D:\\Naresh\\naresh.jpg");
			os = new FileOutputStream("D:\\Naresh\\naresh_copy.jpg");

			for(int nxtByte = is.read(); nxtByte >= 0; nxtByte=is.read()){
				System.out.println(nxtByte);
				os.write(nxtByte);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(is != null){
					is.close();
				}
				
				if(os != null){
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
