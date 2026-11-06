package org.example.demo.view.assembler.issue;

import org.example.demo.view.components.modal.definitions.NewIssueCardView;
import org.example.demo.view.dto.issue.NewIssueCardRequestDTO;
import java.io.IOException;

public class AssembleIssue {
    private static void assembleTitle(NewIssueCardView issue,
                                      NewIssueCardRequestDTO request) {
        request.setTitle(issue.getTitle());
    }

    private static void assembleDescription(NewIssueCardView issue,
                                           NewIssueCardRequestDTO request) {
        request.setDescription(issue
                .getDescription());
    }

    private static void assembleTypology(NewIssueCardView issue,
                                        NewIssueCardRequestDTO request) {
        request.setTypology(issue
                .getTypology()
                .toUpperCase());
    }

    private static void assemblePriority(NewIssueCardView issue,
                                        NewIssueCardRequestDTO request) {
        request.setPriority(issue
                .getPriority()
                .toUpperCase());
    }

    private static void assembleImage(NewIssueCardView issue,
                                     NewIssueCardRequestDTO request) throws IOException {
        request.setImage(issue.getImage());
    }

    public static NewIssueCardRequestDTO assemble(NewIssueCardView issue) throws IOException {
        NewIssueCardRequestDTO request =
                new NewIssueCardRequestDTO();

        assembleTitle(issue,
                request);
        assembleDescription(issue,
                request);
        assembleTypology(issue,
                request);
        assemblePriority(issue,
                request);
        assembleImage(issue,
                request);

        return request;
    }

}
