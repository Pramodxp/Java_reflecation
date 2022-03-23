package com.pramod.ref.constructorswebserver;

import java.net.InetSocketAddress;

//deeply immutable singleton class.
//this class is not only singleton its also fully immutable.
public class ServerConfiguration {

	private ServerConfiguration serverConfigurationInstance;

	private InetSocketAddress inetSocketAddress;
	private String greetingMessage;

	private ServerConfiguration(InetSocketAddress inetSocketAddress, String greetingMessage) {
		super();
		this.inetSocketAddress = inetSocketAddress;
		this.greetingMessage = greetingMessage;
		// single tone Design patteren
		if (serverConfigurationInstance == null) {
			serverConfigurationInstance = this;
		}
	}

	public ServerConfiguration getInstance() {
		return serverConfigurationInstance;
	}

	public InetSocketAddress getInetSocketAddress() {
		return inetSocketAddress;
	}

	public String getGreetingMessage() {
		return greetingMessage;
	}

}
