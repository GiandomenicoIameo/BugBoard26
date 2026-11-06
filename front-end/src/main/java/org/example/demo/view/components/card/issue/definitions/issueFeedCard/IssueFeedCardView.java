package org.example.demo.view.components.card.issue.definitions.issueFeedCard;

import org.example.demo.view.components.card.issue.definitions.*;

public interface IssueFeedCardView extends IssueCardView, DuplicateView,
        TypologyView, PriorityView, StateView, AssigneeView {
    void setId(Integer id);
}
