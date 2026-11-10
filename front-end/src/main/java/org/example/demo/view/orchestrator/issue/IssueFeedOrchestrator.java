package org.example.demo.view.orchestrator.issue;

import org.example.demo.view.assembler.issue.AssembleIssue;
import org.example.demo.view.components.modal.definitions.NewIssueModalView;
import org.example.demo.view.core.orchestration.issue.IssueFeedOrchestration;
import org.example.demo.view.dto.issue.IssueResponseDTO;
import org.example.demo.view.dto.issue.IssueRequestDTO;
import org.example.demo.view.mapper.issue.MapperIssueFeed;
import org.example.demo.view.components.card.issue.definitions.issueFeedCard.IssueFeedCardView;
import org.example.demo.view.service.issue.IssueService;
import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class IssueFeedOrchestrator implements IssueFeedOrchestration {
    private final IssueService issueService
            = new IssueService();

    public <T extends IssueFeedCardView> T create(
            NewIssueModalView issue, T card)
            throws IOException, InterruptedException {
        IssueRequestDTO request = AssembleIssue
                .assemble(issue);
        IssueResponseDTO response = issueService
                .createIssue(request);
        return MapperIssueFeed
                .mapper(response, card);
    }

    public <T extends IssueFeedCardView> List<T> getAll(
            Supplier<T> supplier)
            throws IOException, InterruptedException {
        List<IssueResponseDTO> list = issueService
                .listIssues();
        return MapperIssueFeed.mapper(list,
                supplier);
    }

    public <T extends IssueFeedCardView> T close(
            Integer id, T card) throws IOException,
            InterruptedException {
        IssueResponseDTO response = issueService
                .close(id);
        return MapperIssueFeed
                .mapper(response, card);
    }

    public <T extends IssueFeedCardView> T duplicate(
            Integer id, T card) throws IOException,
            InterruptedException {
        IssueResponseDTO response = issueService
                .duplicate(id);
        return MapperIssueFeed
                .mapper(response, card);
    }

    public boolean assigned(Integer bugId, Integer userId)
            throws IOException, InterruptedException {
        IssueResponseDTO response =
                issueService.assign(bugId, userId);
        return response != null;
    }
}
