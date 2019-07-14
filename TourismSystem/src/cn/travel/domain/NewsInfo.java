package cn.travel.domain;

public class NewsInfo {

	private Long id;
	private String title;
	private String author;
	private String create_date;
	private String content;
	private String summary;
	private Long status;
	// 表达一对多关系
	private Topic topic;

	// 不与数据库的列对应，只为了接收表单参数
	private Long tid;

	public NewsInfo() {
		super();
	}


	public NewsInfo(Long id, String title, String author, String create_date, String content, String summary,
			Long status, Long tid) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.create_date = create_date;
		this.content = content;
		this.summary = summary;
		this.status = status;
		this.tid = tid;
	}
	

	public Long getStatus() {
		return status;
	}


	public void setStatus(Long status) {
		this.status = status;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "NewsInfo [id=" + id + ", title=" + title + ", author=" + author + ", create_date=" + create_date
				+ ", content=" + content + ", summary=" + summary + ", status=" + status + ", topic=" + topic + ", tid="
				+ tid + "]";
	}

}
