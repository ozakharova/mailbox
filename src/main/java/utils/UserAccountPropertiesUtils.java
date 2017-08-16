package utils;

import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAccountPropertiesUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserAccountPropertiesUtils.class);
  private final Properties props = new Properties();

  private UserAccountPropertiesUtils() {
    InputStream stream = null;
    try {
      stream = UserAccountPropertiesUtils.class.getClassLoader()
          .getResourceAsStream("usersCredentials.properties");
      props.load(stream);
    } catch (Exception e) {
      LOGGER.error("Ошибка получения файла свойств");
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(stream);
    }
  }

  public static String getUserLogin() {
    return UserAccountPropertiesUtils.getInstance().props.getProperty("user.login");
  }

  public static String getUserDomain() {
    return UserAccountPropertiesUtils.getInstance().props.getProperty("user.domain");
  }

  public static String getUserPassword() {
    return UserAccountPropertiesUtils.getInstance().props.getProperty("user.password");
  }

  private static UserAccountPropertiesUtils getInstance() {
    return PropHolder.INSTANCE;
  }

  private static class PropHolder {

    private static final UserAccountPropertiesUtils INSTANCE = new UserAccountPropertiesUtils();
  }
}
