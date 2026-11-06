package org.example.demo.view.core.orchestration.issue;

import javafx.scene.image.Image;
import org.example.demo.view.components.card.issue.definitions.issueContentCard.IssueContentCardView;
import org.example.demo.view.components.card.issue.definitions.issueItemCard.IssueItemCardView;
import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public interface IssueItemOrchestration {
    <T extends IssueItemCardView, S extends IssueContentCardView> List<T>
    getAllAssigned(Supplier<T> itemFactory, Supplier<S> contentFactory)
            throws IOException, InterruptedException;
    Image loadImage(Integer id);
}
