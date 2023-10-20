package hcmute.utils;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class UploadUtils {
	public String processUpload(String fileName, HttpServletRequest req, String storeFolder, String storeFilename) throws IOException, ServletException {
		Part filePart = req.getPart(fileName);
		if(filePart == null || filePart.getSize() == 0) {
			return "";
		}
		if(storeFolder == null) {
			storeFolder = Constant.DIR;
		}
		if(storeFileName== null) {
			storeFilename = Paths
		}
		return storeFilename;
	}
}
