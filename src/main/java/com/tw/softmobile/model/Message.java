package com.tw.softmobile.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="message",
uniqueConstraints = {@UniqueConstraint(columnNames= {"messageId"})}) //messageId為唯一值
public class Message {
	@Id //PK
	@Column(name="messageId", nullable = false)
	private Integer messageId;

	@Column(name="messageBody", nullable = false)
	private String messageBody;
	
	@Column(name="messageBookId", nullable = false)
	private Integer messageBookId;
	
	@Column(name="timeStamp", nullable = false)
	private Timestamp timeStamp;
	
	public Message() {}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public Integer getMessageBookId() {
		return messageBookId;
	}

	public void setMessageBookId(Integer messageBookId) {
		this.messageBookId = messageBookId;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}




