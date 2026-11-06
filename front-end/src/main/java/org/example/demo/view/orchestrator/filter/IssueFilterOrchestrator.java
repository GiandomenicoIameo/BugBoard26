package org.example.demo.view.orchestrator.filter;

import org.example.demo.view.assembler.filter.AssembleFilter;
import org.example.demo.view.components.card.issue.definitions.issueFeedCard.IssueFeedCardView;
import org.example.demo.view.components.modal.definitions.FilterView;
import org.example.demo.view.core.orchestration.filter.IssueFilterOrchestration;
import org.example.demo.view.dto.filter.FilterRequestDTO;
import org.example.demo.view.dto.issue.IssueCardResponseDTO;
import org.example.demo.view.mapper.issue.MapperIssueFeed;
import org.example.demo.view.service.issue.IssueService;
import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class IssueFilterOrchestrator implements IssueFilterOrchestration {
    private final IssueService issueService
            = new IssueService();

    public <T extends IssueFeedCardView> List<T> getAll(
            FilterView filter, Supplier<T> supplier)
            throws IOException, InterruptedException {
        FilterRequestDTO request = AssembleFilter
                .assemble(filter);
        List<IssueCardResponseDTO> response = issueService
                .searchByFilter(request);
        return MapperIssueFeed
                .mapper(response, supplier);
    }

    public <T extends IssueFeedCardView> List<T> getAllBySearch(
            FilterView filter, Supplier<T> supplier)
            throws IOException, InterruptedException {
        FilterRequestDTO request = AssembleFilter
                .assemble(filter);
        List<IssueCardResponseDTO> response = issueService
                .searchByKeyword(request);
        return MapperIssueFeed
                .mapper(response, supplier);
    }
}
