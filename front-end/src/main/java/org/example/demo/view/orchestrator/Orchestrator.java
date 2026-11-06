package org.example.demo.view.orchestrator;


import org.example.demo.view.core.orchestration.Orchestration;
import org.example.demo.view.core.orchestration.filter.IssueFilterOrchestration;
import org.example.demo.view.core.orchestration.issue.IssueFeedOrchestration;
import org.example.demo.view.core.orchestration.issue.IssueItemOrchestration;
import org.example.demo.view.core.orchestration.login.LoginOrchestration;
import org.example.demo.view.core.orchestration.notice.NoticeOrchestration;
import org.example.demo.view.core.orchestration.user.UserOrchestration;
import org.example.demo.view.orchestrator.filter.IssueFilterOrchestrator;
import org.example.demo.view.orchestrator.issue.IssueFeedOrchestrator;
import org.example.demo.view.orchestrator.issue.IssueItemOrchestrator;
import org.example.demo.view.orchestrator.login.LoginOrchestrator;
import org.example.demo.view.orchestrator.notice.NoticeOrchestrator;
import org.example.demo.view.orchestrator.user.UserOrchestrator;

public class Orchestrator implements Orchestration {
    // final impedisce di sostituire questi riferimenti
    // dopo la loro creazione.
    private final LoginOrchestration loginOrchestration =
            new LoginOrchestrator();
    private final IssueFeedOrchestration issueFeedOrchestration =
            new IssueFeedOrchestrator();
    private final IssueItemOrchestration issueItemOrchestration =
            new IssueItemOrchestrator();
    private final IssueFilterOrchestration issueFilterOrchestration =
            new IssueFilterOrchestrator();
    private final NoticeOrchestration noticeOrchestration =
            new NoticeOrchestrator();
    private final UserOrchestration userOrchestration =
            new UserOrchestrator();

    public LoginOrchestration login() {
        return loginOrchestration;
    }

    public IssueFeedOrchestration issueFeed() {
        return issueFeedOrchestration;
    }

    public IssueItemOrchestration issueItem() {
        return issueItemOrchestration;
    }

    public IssueFilterOrchestration issueFilter() {
        return issueFilterOrchestration;
    }

    public NoticeOrchestration notice() {
        return noticeOrchestration;
    }

    public UserOrchestration user() {
        return userOrchestration;
    }
}
