package org.example.demo.view.core.orchestration;

import org.example.demo.view.core.orchestration.filter.FilterOrchestration;
import org.example.demo.view.core.orchestration.issue.IssueFeedOrchestration;
import org.example.demo.view.core.orchestration.issue.IssueItemOrchestration;
import org.example.demo.view.core.orchestration.login.LoginOrchestration;
import org.example.demo.view.core.orchestration.notice.NoticeOrchestration;
import org.example.demo.view.core.orchestration.user.UserOrchestration;

public interface Orchestration {
    LoginOrchestration login();
    IssueFeedOrchestration issueFeed();
    FilterOrchestration issueFilter();
    IssueItemOrchestration issueItem();
    NoticeOrchestration notice();
    UserOrchestration user();
}
