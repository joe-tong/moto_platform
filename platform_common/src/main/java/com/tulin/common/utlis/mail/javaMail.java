package com.tulin.common.utlis.mail;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wujing
 */
@Component
public class javaMail {
	private static final String template = "mail/roncoo.ftl";

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Autowired
	private JavaMailSenderImpl javaMailSender;

	public void sendMail(String email) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		try {
			String text = getTextByTemplate(template, map);
			send(email, text);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private String getTextByTemplate(String template, Map<String, Object> model) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate(template), model);
	}

	private String send(String email, String text) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		InternetAddress from = new InternetAddress();
		from.setAddress(javaMailSender.getUsername());
		from.setPersonal("龙果学院", "UTF-8");
		helper.setFrom(from);
		helper.setTo(email);
		helper.setSubject("测试邮件");
		helper.setText(text, true);
		javaMailSender.send(message);
		return text;
	}

}
