package com.blog.sample.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageReceiver {

	private final JmsTemplate jmsTemplate;

	@Autowired
	public MessageReceiver(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	// @JmsListener(destination = "TestQueue", containerFactory =
	// "jmsContainerFactory")
	public SimpleMessage retrieveMessage() {

		SimpleMessage simpleMessage = (SimpleMessage) jmsTemplate.receiveAndConvert("TestQueue");
		log.info("Retrieved message from queue: " + simpleMessage.toString());
		return simpleMessage;
	}
}