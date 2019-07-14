package cn.travel.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.travel.domain.ScenicSpot;
import cn.travel.domain.Topic;
import cn.travel.service.TopicService;
import cn.travel.utils.PageBean;

public class TopicAction extends ActionSupport implements ModelDriven<Topic> {
	
	private Topic topic = new Topic();
	private TopicService topicService;
	private Integer currentPage;
	private Integer pageSize;
	
	public void getAll() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Topic.class);
		List<Topic> list = topicService.getAll(dc);
		System.out.println(list.get(0));
		Gson gson = new Gson();
		String json = gson.toJson(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);
		
	}
	

	public String list() throws Exception {
		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Topic.class);
		// 判断并封装参数
		if (StringUtils.isNotBlank(topic.getName())) {
			dc.add(Restrictions.like("name", "%" + topic.getName()
					+ "%"));
		}

		// 1.调用Service查询分页数据(PageBean)
		PageBean pb = topicService.getPageBean(dc, currentPage, pageSize);
		// 2.将PageBean放入request域,转发到列表显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	
	@Override
	public Topic getModel() {
		return topic;
	}


	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
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
