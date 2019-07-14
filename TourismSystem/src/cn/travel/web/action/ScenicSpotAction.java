package cn.travel.web.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.travel.domain.ScenicSpot;
import cn.travel.service.ScenicSpotService;
import cn.travel.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScenicSpotAction extends ActionSupport implements
		ModelDriven<ScenicSpot> {
	private ScenicSpot scenicSpot = new ScenicSpot();
	private ScenicSpotService sss;
	private Integer currentPage;
	private Integer pageSize;
	// �ϴ����ļ����Զ���װ��File������
	private File upload;
	// ���ύ����������Ϲ̶���׺FileName,�ļ����ƻ��Զ���װ��������
	private String uploadFileName;
	// ���ύ����������Ϲ̶���׺ContentType,�ļ�MIME���ͻ��Զ���װ��������
	private String uploadContentType;

	public String list() throws Exception {
		// �������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(ScenicSpot.class);
		// �жϲ���װ����
		if (StringUtils.isNotBlank(scenicSpot.getScenic_name())) {
			dc.add(Restrictions.like("scenic_name", "%" + scenicSpot.getScenic_name()
					+ "%"));
		}
		if (StringUtils.isNotBlank(scenicSpot.getScenic_location())) {
			dc.add(Restrictions.like("scenic_location", "%" + scenicSpot.getScenic_location()
					+ "%"));
		}
		/*if (StringUtils.isNotBlank(scenicSpot.getStype().getType())) {
			dc.add(Restrictions.like("scenic_tid.type","%" + scenicSpot.getStype().getType()+ "%"));
		}*/
		// 1.����Service��ѯ��ҳ����(PageBean)
		PageBean pb = sss.getPageBean(dc, currentPage, pageSize);
		// 2.��PageBean����request��,ת�����б���ʾ
		ActionContext.getContext().put("scenicSpotPageBean", pb);
		return "list";
	}
	
	public String spotList() throws Exception {
		// �������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(ScenicSpot.class);
		// �жϲ���װ����
		if (StringUtils.isNotBlank(scenicSpot.getScenic_name())) {
			dc.add(Restrictions.like("scenic_name", "%" + scenicSpot.getScenic_name()
					+ "%"));
		}
		
		// 1.����Service��ѯ��ҳ����(PageBean)
		PageBean pb = sss.getPageBean(dc, currentPage, pageSize);
		// 2.��PageBean����request��,ת�����б���ʾ
		ActionContext.getContext().put("pageBean", pb);
		return "spotList";
	}


	public String add() throws Exception {
		ServletContext servletContext = (ServletContext) ActionContext.getContext().get(ServletActionContext.SERVLET_CONTEXT);
		
		if (upload != null) {
			//���ļ���ת��Ϊ�ϴ�ʱ��
			String str = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
	        String[] s=uploadFileName.split("\\.");
	        str=str+"."+s[1];
	        // �ϴ��ļ����浽ָ��λ��
	        upload.renameTo(new File(servletContext.getRealPath("/")+"images/scenic/"
					+ str));
			
	        System.out.println("·��"+servletContext.getRealPath("/")+"images/scenic/"
					+ str);
	        scenicSpot.setScenic_image("images/scenic/"+str);
		}
		
		// --------------------------------------------------------
		// 1.����serviceʵ�ֱ����߼�
		scenicSpot.setScenic_image(scenicSpot.getScenic_image());
		sss.save(scenicSpot);
		// 2.�ض��򵽿ͻ��б�
		return "toList";
	}

	public String toEdit() throws Exception {
		// 1.����Service����id��ÿͻ�����
		ScenicSpot s = sss.getById(scenicSpot.getScenic_id());
		
		// 2.���ͻ�����ŵ�request��,��ת�����༭ҳ��
		ActionContext.getContext().put("scenicSpot", s);
		return "toEdit";
	}

	@Override
	public ScenicSpot getModel() {
		return scenicSpot;
	}

	

	public void setSss(ScenicSpotService sss) {
		this.sss = sss;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

}
