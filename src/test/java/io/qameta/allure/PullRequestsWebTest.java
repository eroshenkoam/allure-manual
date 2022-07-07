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
@Feature("Pull Requests")
public class PullRequestsWebTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private static final String BRANCH = "new-feature";

    @Test
    @Manual
    @JiraIssue("AE-2")
    @Story("Create new pull request")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("smoke")})
    @DisplayName("Creating new issue for authorized user")
    public void shouldCreatePullRequest() {
        step(format("Open pull requests page `%s/%s`", OWNER, REPO));
        step(format("Create pull request with title `%s`", BRANCH));
        step(format("Should see pull request with title `%s`", BRANCH));
    }

    @Test
    @Manual
    @JiraIssue("AE-2")
    @Story("Close existing pull request")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Deleting existing issue for authorized user")
    public void shouldClosePullRequest() {
        step(format("Open pull requests page `%s/%s`", OWNER, REPO));
        step(format("Create pull request with title `%s`", BRANCH));
        step(format("Close pull request with title `%s`", BRANCH));
        step(format("Should not see pull request with title `%s`", BRANCH));
    }

}
