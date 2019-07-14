package cn.travel.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.travel.domain.NewsInfo;
import cn.travel.service.NewsInfoService;
import cn.travel.utils.PageBean;

public class NewsInfoAction extends ActionSupport implements ModelDriven<NewsInfo> {
	
	private NewsInfo newsInfo = new NewsInfo();
	private NewsInfoService newsInfoService;
	private Integer currentPage;
	private Integer pageSize;
	
	public String getNewsById() throws Exception{
		NewsInfo news = newsInfoService.getById(newsInfo.getId());
		ActionContext.getContext().put("news", news);
		return "toNewItem";
		
	}
	
	public String getNewsByStatus() throws Exception{
		DetachedCriteria dc = DetachedCriteria.forClass(NewsInfo.class);
		dc.add(Restrictions.eq("status", new Long(0)));
		
		PageBean pb = newsInfoService.getPageBean(dc, currentPage, pageSize);
		List<NewsInfo> list = pb.getList();
		ActionContext.getContext().put("examinenews", pb);
		return "toNewExamine";
	}
	public String list() throws Exception {
		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(NewsInfo.class);
		// 判断并封装参数
		dc.add(Restrictions.not(Restrictions.eq("status",new Long(2))));
		if(StringUtils.isNotBlank(newsInfo.getTitle())){
			dc.add(Restrictions.like("title", "%"+newsInfo.getTitle()+"%"));
		}
		if(StringUtils.isNotBlank(newsInfo.getAuthor())){
			dc.add(Restrictions.like("author", "%"+newsInfo.getAuthor()+"%"));
		}
		
		// 1.调用Service查询分页数据(PageBean)
		PageBean pb = newsInfoService.getPageBean(dc, currentPage, pageSize);
		// 2.将PageBean放入request域,转发到列表显示
		ActionContext.getContext().put("newsPageBean", pb);
		return "list";
	}
	
	public String add() throws Exception {
		// 1.调用service实现保存逻辑
		newsInfoService.save(newsInfo);
		// 2.重定向到客户列表
		return "toList";
	}
	
	public String userAddNews() throws Exception {
		// 1.调用service实现保存逻辑
		newsInfoService.save(newsInfo);
		// 2.重定向到客户列表
		return "toList";
	}
	public String userNewsList() throws Exception {
		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(NewsInfo.class);
		// 判断并封装参数
		dc.add(Restrictions.not(Restrictions.eq("status",new Long(2))));

		// 1.调用Service查询分页数据(PageBean)
		PageBean pb = newsInfoService.getPageBean(dc, currentPage, pageSize);
		// 2.将PageBean放入request域,转发到列表显示
		ActionContext.getContext().put("newsPageBean", pb);
		return "userlist";
	}
	
	@Override
	public NewsInfo getModel() {
		return newsInfo;
	}


	public void setNewsInfoService(NewsInfoService newsInfoService) {
		this.newsInfoService = newsInfoService;
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
