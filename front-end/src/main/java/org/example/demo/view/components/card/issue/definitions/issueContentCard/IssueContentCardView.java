package org.example.demo.view.components.card.issue.definitions.issueContentCard;

import org.example.demo.view.components.card.issue.definitions.*;

import java.time.LocalDateTime;

public interface IssueContentCardView extends IssueCardView,
        DateView, ImageView, DuplicateView, StateView {
    void setDescpription(String descpription);
    void setNameCard(String name);
    void setDateCard(LocalDateTime date);
}
