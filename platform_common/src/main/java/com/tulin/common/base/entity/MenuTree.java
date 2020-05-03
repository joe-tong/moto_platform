package com.tulin.common.base.entity;

import java.io.Serializable;
import java.util.List;

public class MenuTree implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;

	private String icon;
	private boolean spread;
	private String href;
	private List<MenuTree> children;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<MenuTree> getChildren() {
		return children;
	}

	public void setChildren(List<MenuTree> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "MenuTree [title=" + title + ", icon=" + icon + ", spread=" + spread + ", href=" + href + ", children="
				+ children + "]";
	}

}
