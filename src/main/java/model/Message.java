package model;

@SuppressWarnings("unused")
public class Message {

  private String subject;
  private String email;
  private String text;

  public Message(String subject, String email) {
    this.subject = subject;
    this.email = email;
  }

  public Message(String subject, String email, String text) {
    this.subject = subject;
    this.email = email;
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
