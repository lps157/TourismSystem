package cn.travel.domain;

/**
 * ScenicSpot entity. @author MyEclipse Persistence Tools
 */

public class ScenicSpot {

	// Fields

	private Long scenic_id;
	private String scenic_name;
	private String scenic_flow;
	private String scenic_image;
	private String daily_price;
	private String low_price;
	private String scenic_location;
	private String scenic_website;
	// 表达一对多关系
	private Stype stype;

	// --------------------------------------
	// 不与数据库的列对应，只为了接收表单参数
	private Long scenic_tid;

	public Long getScenic_id() {
		return scenic_id;
	}

	public void setScenic_id(Long scenic_id) {
		this.scenic_id = scenic_id;
	}

	public String getScenic_website() {
		return scenic_website;
	}

	public void setScenic_website(String scenic_website) {
		this.scenic_website = scenic_website;
	}

	public String getScenic_name() {
		return scenic_name;
	}

	public void setScenic_name(String scenic_name) {
		this.scenic_name = scenic_name;
	}

	public String getScenic_flow() {
		return scenic_flow;
	}

	public void setScenic_flow(String scenic_flow) {
		this.scenic_flow = scenic_flow;
	}

	public String getScenic_image() {
		return scenic_image;
	}

	public void setScenic_image(String scenic_image) {
		this.scenic_image = scenic_image;
	}

	public String getDaily_price() {
		return daily_price;
	}

	public void setDaily_price(String daily_price) {
		this.daily_price = daily_price;
	}

	public String getLow_price() {
		return low_price;
	}

	public void setLow_price(String low_price) {
		this.low_price = low_price;
	}

	public String getScenic_location() {
		return scenic_location;
	}

	public void setScenic_location(String scenic_location) {
		this.scenic_location = scenic_location;
	}

	public Stype getStype() {
		return stype;
	}

	public void setStype(Stype stype) {
		this.stype = stype;
	}

	public Long getScenic_tid() {
		return scenic_tid;
	}

	public void setScenic_tid(Long scenic_tid) {
		this.scenic_tid = scenic_tid;
	}

	@Override
	public String toString() {
		return "ScenicSpot [scenic_id=" + scenic_id + ", scenic_name=" + scenic_name + ", scenic_flow=" + scenic_flow
				+ ", scenic_image=" + scenic_image + ", daily_price=" + daily_price + ", low_price=" + low_price
				+ ", scenic_location=" + scenic_location + ", scenic_website=" + scenic_website + ", stype=" + stype
				+ ", scenic_tid=" + scenic_tid + "]";
	}

}