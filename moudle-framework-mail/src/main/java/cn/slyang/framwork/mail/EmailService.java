package cn.slyang.framwork.mail;


public interface EmailService {

	/**
	 * 发送简单邮件
	 *
	 * @param sendTo  收件人地址
	 * @param titel   邮件标题
	 * @param content 邮件内容
	 */
	void sendSimpleMail(String sendTo,
						String titel,
						String content);

}
