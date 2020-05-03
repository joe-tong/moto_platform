package com.tulin.common.utlis;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.beans.PropertyEditorSupport;

/**
 * 
 * @Description 防御XSS攻击：基于白名单的XSS后端过滤（jsoup）
 * @author ShiXian
 * @date 2018-5-1
 * @version 1.0
 *
 */
public class StringEscapeEditor extends PropertyEditorSupport {

	/**设置白名单; **/
	private static Whitelist whitelist = Whitelist.relaxed().addAttributes(":all", "style");

	public StringEscapeEditor() {
	}

	@Override
	public String getAsText() {
		Object value = getValue();
		return value != null ? value.toString() : "";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null) {
			setValue(null);
		} else {
			//清除白名单之外的标签
			setValue(Jsoup.clean(text, whitelist));
		}
	}

}
