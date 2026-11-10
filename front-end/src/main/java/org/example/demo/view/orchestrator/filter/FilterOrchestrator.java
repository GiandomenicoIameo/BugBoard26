package org.example.demo.view.orchestrator.filter;

import org.example.demo.view.assembler.filter.AssembleFilter;
import org.example.demo.view.components.card.issue.definitions.issueFeedCard.IssueFeedCardView;
import org.example.demo.view.components.modal.definitions.FilterModalView;
import org.example.demo.view.core.orchestration.filter.FilterOrchestration;
import org.example.demo.view.dto.filter.FilterRequestDTO;
import org.example.demo.view.dto.issue.IssueResponseDTO;
import org.example.demo.view.mapper.issue.MapperIssueFeed;
import org.example.demo.view.service.issue.IssueService;
import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class FilterOrchestrator implements FilterOrchestration {
    private final IssueService issueService
            = new IssueService();

    public <T extends IssueFeedCardView> List<T> getAll(
            FilterModalView filter, Supplier<T> supplier)
            throws IOException, InterruptedException {
        FilterRequestDTO request = AssembleFilter
                .assemble(filter);
        List<IssueResponseDTO> response = issueService
                .searchByFilter(request);
        return MapperIssueFeed
                .mapper(response, supplier);
    }

    public <T extends IssueFeedCardView> List<T> getAllBySearch(
            FilterModalView filter, Supplier<T> supplier)
            throws IOException, InterruptedException {
        FilterRequestDTO request = AssembleFilter
                .assemble(filter);
        List<IssueResponseDTO> response = issueService
                .searchByKeyword(request);
        return MapperIssueFeed
                .mapper(response, supplier);
    }
}
