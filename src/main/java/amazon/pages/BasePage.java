package amazon.pages;

import amazon.config.EnvFactory;
import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for all page classes.
 * Helper class for common driver-operations(click, type, etc.)
 */
@Slf4j
public class BasePage {
    protected static Config config = EnvFactory.getInstance().getConfig();

    private WebDriver driver;

    protected WebDriverWait wait;

    protected final Duration NORMAL_WEBDRIVERWAIT_TIMEOUT_IN_DURATION = Duration.ofSeconds(20);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
