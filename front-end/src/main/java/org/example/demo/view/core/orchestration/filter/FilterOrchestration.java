package org.example.demo.view.core.orchestration.filter;

import org.example.demo.view.components.card.issue.definitions.issueFeedCard.IssueFeedCardView;
import org.example.demo.view.components.modal.definitions.FilterModalView;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public interface FilterOrchestration {
    <T extends IssueFeedCardView> List<T> getAll(
            FilterModalView filter, Supplier<T> supplier)
            throws IOException, InterruptedException;

    <T extends IssueFeedCardView> List<T> getAllBySearch(
            FilterModalView filter, Supplier<T> supplier)
            throws IOException, InterruptedException;
}
