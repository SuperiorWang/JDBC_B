package com.security.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class securityCode {
	private String PlainText;
	
	public void setPlainText(String PlainText)
	{
		this.PlainText = PlainText ;
	}
	
	public String getSecurity()
	{
		System.out.println("收到数据:" + PlainText);
		
		int i = 0;
		StringBuffer buf = new StringBuffer("") ;
		
		try{
			MessageDigest md = MessageDigest.getInstance("MD5") ;
			md.update(PlainText.getBytes()) ;
			byte b[] = md.digest() ;
			
		    for(int offset=0;offset<b.length;offset++) {
		    	i = b[offset] ;
		    	if (i < 0){
		    		i += 256;
		    	}
		    	if (i < 16){
		    		buf.append("0") ;
		    		buf.append(Integer.toHexString(i)) ;
		    	}
		    }
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
		System.out.println("MD5 result: " + buf.toString());
        return buf.toString();       
	}

}
