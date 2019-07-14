package cn.travel.web.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONObject;

public class UploadAction {

    private File upload;
    private String uploadContentType;
    private String uploadFileName;//上传图片的名字
    public File getUpload() {
        return upload;
    }
    public void setUpload(File upload) {
        this.upload = upload;
    }
    public String getUploadContentType() {
        return uploadContentType;
    }
    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }
    public String getUploadFileName() {
        return uploadFileName;
    }
    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void fileUpload() throws IOException{
    	ServletContext servletContext = (ServletContext) ActionContext.getContext().get(ServletActionContext.SERVLET_CONTEXT);
		if (upload != null) {
			//将文件名转换为上传时间
			String str = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
	        String[] s=uploadContentType.split("\\.");
	        str=str+"."+s[1];
	        // 上传文件保存到指定位置
	        upload.renameTo(new File(servletContext.getRealPath("/")+"images/scenic/"
					+ str));
			
	        System.out.println("路径"+servletContext.getRealPath("/")+"images/scenic/"
					+ str);
	      //将要传入页面的数据变成json格式
            JSONObject jsonObject=new JSONObject();
            String path2 = "images/scenic/"+str;
            jsonObject.put("path", path2);
            //控制台输出格式化的json数据
            ServletActionContext.getResponse().getWriter().print(jsonObject);
		}
        
    }
}
