package model;

public class UserCredentials {

  private String login;
  private String domain;
  private String password;

  public UserCredentials(String login, String domain, String password) {
    this.login = login;
    this.domain = domain;
    this.password = password;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
