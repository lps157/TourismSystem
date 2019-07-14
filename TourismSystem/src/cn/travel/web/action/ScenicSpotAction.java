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
	// 上传的文件会自动封装到File对象中
	private File upload;
	// 在提交的名后面加上固定后缀FileName,文件名称会自动封装到属性中
	private String uploadFileName;
	// 在提交的名后面加上固定后缀ContentType,文件MIME类型会自动封装到属性中
	private String uploadContentType;

	public String list() throws Exception {
		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(ScenicSpot.class);
		// 判断并封装参数
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
		// 1.调用Service查询分页数据(PageBean)
		PageBean pb = sss.getPageBean(dc, currentPage, pageSize);
		// 2.将PageBean放入request域,转发到列表显示
		ActionContext.getContext().put("scenicSpotPageBean", pb);
		return "list";
	}
	
	public String spotList() throws Exception {
		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(ScenicSpot.class);
		// 判断并封装参数
		if (StringUtils.isNotBlank(scenicSpot.getScenic_name())) {
			dc.add(Restrictions.like("scenic_name", "%" + scenicSpot.getScenic_name()
					+ "%"));
		}
		
		// 1.调用Service查询分页数据(PageBean)
		PageBean pb = sss.getPageBean(dc, currentPage, pageSize);
		// 2.将PageBean放入request域,转发到列表显示
		ActionContext.getContext().put("pageBean", pb);
		return "spotList";
	}


	public String add() throws Exception {
		ServletContext servletContext = (ServletContext) ActionContext.getContext().get(ServletActionContext.SERVLET_CONTEXT);
		
		if (upload != null) {
			//将文件名转换为上传时间
			String str = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
	        String[] s=uploadFileName.split("\\.");
	        str=str+"."+s[1];
	        // 上传文件保存到指定位置
	        upload.renameTo(new File(servletContext.getRealPath("/")+"images/scenic/"
					+ str));
			
	        System.out.println("路径"+servletContext.getRealPath("/")+"images/scenic/"
					+ str);
	        scenicSpot.setScenic_image("images/scenic/"+str);
		}
		
		// --------------------------------------------------------
		// 1.调用service实现保存逻辑
		scenicSpot.setScenic_image(scenicSpot.getScenic_image());
		sss.save(scenicSpot);
		// 2.重定向到客户列表
		return "toList";
	}

	public String toEdit() throws Exception {
		// 1.调用Service根据id获得客户对象
		ScenicSpot s = sss.getById(scenicSpot.getScenic_id());
		
		// 2.将客户对象放到request域,并转发到编辑页面
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
