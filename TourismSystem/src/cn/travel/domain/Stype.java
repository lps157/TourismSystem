package cn.travel.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Stype entity. @author MyEclipse Persistence Tools
 */

public class Stype {

	// Fields

	private Long tid;
	private String type;

	public Stype() {
		super();
	}

	public Stype(Long tid, String type) {
		super();
		this.tid = tid;
		this.type = type;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}