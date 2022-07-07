package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
@Layer("web")
@Owner("eroshenkoam")
@Feature("Issues")
public class IssuesWebTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private static final String ISSUE_TITLE = "Some issue title here";

    @Test
    @Manual
    @JiraIssue("AE-1")
    @Story("Create new issue")
    @Tags({@Tag("web"), @Tag("critical")})
    @DisplayName("Creating new issue authorized user")
    public void shouldCreateIssue() {
        step(format("Open issues page `%s/%s`", OWNER, REPO));
        step(format("Create issue with title `%s`", ISSUE_TITLE));
        step(format("Should see issue with title `%s`", ISSUE_TITLE));
    }

    @Test
    @Manual
    @JiraIssue("AE-1")
    @Story("Close existing issue")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Closing new issue for authorized user")
    public void shouldCloseIssue() {
        step(format("Open issues page `%s/%s`", OWNER, REPO));
        step(format("Create issue with title `%s`", ISSUE_TITLE));
        step(format("Close issue with title `%s`", ISSUE_TITLE));
        step(format("Should not see issue with title `%s`", ISSUE_TITLE));
    }

}
