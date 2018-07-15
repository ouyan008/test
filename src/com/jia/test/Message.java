package com.jia.test;

import java.util.ArrayList;

public final class Message implements Cloneable  {
    public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public ArrayList<String> getRecipients() {
		return recipients;
	}


	public void setRecipients(ArrayList<String> recipients) {
		this.recipients = recipients;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	private String sender;
    private ArrayList<String> recipients;
    private String text;
   
   public void addRecipient(String recipient) {  };
   
   
   public static void main(String [] args) {
	   
	      Message msg = new Message();
	      msg.setText("hello quinn");
	      msg.setSender("jia");
	      
	      
	      try {
			Message clonedMsg = (Message) msg.clone();
			
			System.out.print(clonedMsg.getText());
			System.out.print(clonedMsg.getSender());
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
   }
   
   
}