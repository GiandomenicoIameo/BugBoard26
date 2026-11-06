package org.example.demo.view.orchestrator.issue;

import javafx.scene.image.Image;
import org.example.demo.view.assembler.issue.AssembleImage;
import org.example.demo.view.components.card.issue.definitions.issueContentCard.IssueContentCardView;
import org.example.demo.view.components.card.issue.definitions.issueItemCard.IssueItemCardView;
import org.example.demo.view.core.orchestration.issue.IssueItemOrchestration;
import org.example.demo.view.dto.issue.ImageResponseDTO;
import org.example.demo.view.dto.issue.ImageRequestDTO;
import org.example.demo.view.dto.issue.IssueCardResponseDTO;
import org.example.demo.view.mapper.issue.MapperImage;
import org.example.demo.view.mapper.issue.MapperIssueContent;
import org.example.demo.view.mapper.issue.MapperIssueItem;
import org.example.demo.view.service.issue.IssueService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class IssueItemOrchestrator implements IssueItemOrchestration {
    private final IssueService issueService  =
            new IssueService();

    public <T extends IssueItemCardView,
            S extends IssueContentCardView> List<T>
    getAllAssigned(Supplier<T> itemFactory, Supplier<S> contentFactory)
            throws IOException, InterruptedException {

        List<IssueCardResponseDTO> list =
                issueService.assigned();
        List<T> lista = new ArrayList<>();

        for(IssueCardResponseDTO card: list) {
            T item = MapperIssueItem
                    .mapper(card, itemFactory.get());
            S content = MapperIssueContent
                    .mapper(card, contentFactory.get());

            item.setSelectionListener(content);
            lista.add(item);
        }

        return lista;
    }

    public Image loadImage(Integer id) {
        ImageRequestDTO request = AssembleImage
                .assemble(id);
        ImageResponseDTO response = issueService.
                download(request);
        return MapperImage
                .mapper(response);
    }
}
