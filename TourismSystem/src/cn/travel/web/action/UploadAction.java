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
    private String uploadFileName;//�ϴ�ͼƬ������
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
			//���ļ���ת��Ϊ�ϴ�ʱ��
			String str = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
	        String[] s=uploadContentType.split("\\.");
	        str=str+"."+s[1];
	        // �ϴ��ļ����浽ָ��λ��
	        upload.renameTo(new File(servletContext.getRealPath("/")+"images/scenic/"
					+ str));
			
	        System.out.println("·��"+servletContext.getRealPath("/")+"images/scenic/"
					+ str);
	      //��Ҫ����ҳ������ݱ��json��ʽ
            JSONObject jsonObject=new JSONObject();
            String path2 = "images/scenic/"+str;
            jsonObject.put("path", path2);
            //����̨�����ʽ����json����
            ServletActionContext.getResponse().getWriter().print(jsonObject);
		}
        
    }
}
