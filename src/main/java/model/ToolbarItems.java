package model;

public enum ToolbarItems {
  INBOX("Письма"),
  MORE_THEMES("Темы"),
  MORE_SETTINGS("Настройки"),
  MORE_HELP("Помощь"),
  MORE_VIDEOHELP("Видеоподсказки"),
  MORE_MOBILE("Мобильная Почта"),
  MORE_BUSINESS("Почта для Бизнеса"),
  MORE_AGENT("История Агента");

  private String text;

  ToolbarItems(String text) {
    this.text = text;
  }

  public String text() {
    return text;
  }
}
