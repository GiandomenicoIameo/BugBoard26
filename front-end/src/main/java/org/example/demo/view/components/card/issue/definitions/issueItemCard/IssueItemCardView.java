package org.example.demo.view.components.card.issue.definitions.issueItemCard;

import org.example.demo.view.components.card.issue.definitions.DateView;
import org.example.demo.view.components.card.issue.definitions.IssueCardView;
import org.example.demo.view.components.card.issue.definitions.PriorityView;
import org.example.demo.view.components.card.issue.definitions.issueContentCard.IssueContentCardView;

import java.util.function.Consumer;

public interface IssueItemCardView extends IssueCardView, DateView, PriorityView {
    void setId(Integer id);
    void setSelectionListener(
            IssueContentCardView listener);
    void setCallback(
            Consumer<IssueContentCardView> callback);
    String getId();
}
