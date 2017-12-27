package com.app;

import org.mule.el.context.MessageContext;

import org.mule.message.ds.ByteArrayDataSource;

import javax.activation.DataHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
public class Core {

	public Object getUpdatedPayload(MessageContext messageContext) throws Exception {

		
FileInputStream fis = null;
		
ByteArrayOutputStream ous = null;
InputStream ios = null;

		try {
			File file = new File("C:/Users/db2admin.bandaru-PC/Desktop/Jet-lido/Tankering/mail/errorMessage.txt");
			 byte[] buffer = new byte[4096];
		        ous = new ByteArrayOutputStream();
		        ios = new FileInputStream(file);
		        int read = 0;
		        while ((read = ios.read(buffer)) != -1) {
		            ous.write(buffer, 0, read);
		        }

			ByteArrayDataSource pdf = new ByteArrayDataSource(ous.toByteArray(), "text/plain",
					"new2");
			
			DataHandler data = new DataHandler(pdf);

			messageContext.getOutboundAttachments().put("files", data);
		} catch (IOException e) {

			fis.close();

		}

		return messageContext.getPayload();
	}
public Object getupdateDate(){
	
	
	return "";
} 
}



