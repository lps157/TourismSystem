package cn.travel.domain;

public class Customer {

	/*
	 * CREATE TABLE `cst_customer` ( `cust_id` BIGINT(32) NOT NULL
	 * AUTO_INCREMENT COMMENT '�ͻ����(����)', `cust_name` VARCHAR(32) NOT NULL
	 * COMMENT '�ͻ�����(��˾����)', `cust_source` VARCHAR(32) DEFAULT NULL COMMENT
	 * '�ͻ���Ϣ��Դ', `cust_industry` VARCHAR(32) DEFAULT NULL COMMENT '�ͻ�������ҵ',
	 * `cust_level` VARCHAR(32) DEFAULT NULL COMMENT '�ͻ�����', `cust_linkman`
	 * VARCHAR(64) DEFAULT NULL COMMENT '��ϵ��', `cust_phone` VARCHAR(64) DEFAULT
	 * NULL COMMENT '�̶��绰', `cust_mobile` VARCHAR(16) DEFAULT NULL COMMENT
	 * '�ƶ��绰', PRIMARY KEY (`cust_id`) ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT
	 * CHARSET=utf8;
	 */
	private Long cust_id;

	private String cust_name;
	// private String cust_source;
	// private String cust_industry;
	// private String cust_level;
	private String cust_linkman;
	private String cust_phone;
	private String cust_mobile;

	// ���ù����������ֵ����
	private BaseDict cust_source; // �ͻ���Դ cust_source.dict_id
	private BaseDict cust_industry; // �ͻ���ҵ
	private BaseDict cust_level; // �ͻ�����

	public BaseDict getCust_source() {
		return cust_source;
	}

	public void setCust_source(BaseDict cust_source) {
		this.cust_source = cust_source;
	}

	public BaseDict getCust_industry() {
		return cust_industry;
	}

	public void setCust_industry(BaseDict cust_industry) {
		this.cust_industry = cust_industry;
	}

	public BaseDict getCust_level() {
		return cust_level;
	}

	public void setCust_level(BaseDict cust_level) {
		this.cust_level = cust_level;
	}

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_linkman() {
		return cust_linkman;
	}

	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name
				+ "]";
	}

}
