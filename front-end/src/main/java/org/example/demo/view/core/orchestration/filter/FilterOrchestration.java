package org.example.demo.view.core.orchestration.filter;

import org.example.demo.view.components.card.issue.definitions.issueFeedCard.IssueFeedCardView;
import org.example.demo.view.components.modal.definitions.FilterView;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public interface IssueFilterOrchestration {
    <T extends IssueFeedCardView> List<T> getAll(
            FilterView filter, Supplier<T> supplier)
            throws IOException, InterruptedException;

    <T extends IssueFeedCardView> List<T> getAllBySearch(
            FilterView filter, Supplier<T> supplier)
            throws IOException, InterruptedException;
}
