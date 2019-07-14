package cn.travel.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.travel.domain.Stype;
import cn.travel.service.StypeService;


public class StypeAction extends ActionSupport implements ModelDriven<Stype> {
	
	private Stype stype = new Stype();
	private StypeService ss;
	private Integer currentPage;
	private Integer pageSize;
	
	public void getAll() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Stype.class);
		List<Stype> list = ss.getAll(dc);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);
	}
	
	
	@Override
	public Stype getModel() {
		return stype;
	}
	
	public void setSs(StypeService ss) {
		this.ss = ss;
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

	
}
