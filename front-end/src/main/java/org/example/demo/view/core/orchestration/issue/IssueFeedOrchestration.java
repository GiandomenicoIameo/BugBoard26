package org.example.demo.view.core.orchestration.issue;

import org.example.demo.view.components.card.issue.definitions.issueFeedCard.IssueFeedCardView;
import org.example.demo.view.components.modal.definitions.NewIssueModalView;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public interface IssueFeedOrchestration {
    <T extends IssueFeedCardView> T create(
            NewIssueModalView issue, T card)
            throws IOException, InterruptedException;
    <T extends IssueFeedCardView> List<T> getAll(
            Supplier<T> supplier)
            throws IOException, InterruptedException;
    <T extends IssueFeedCardView> T close(
            Integer id, T card)
            throws IOException, InterruptedException;
    <T extends IssueFeedCardView> T duplicate(
            Integer id, T card)
            throws IOException, InterruptedException;
    boolean assigned(Integer bugId, Integer userId)
            throws IOException, InterruptedException;
}
