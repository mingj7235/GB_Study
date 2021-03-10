package com.koreait.app.member;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("joshuara7235@gmail.com", "4tkfkdtkfkdwlrl@");
	}
}