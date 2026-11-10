package org.example.demo.view.assembler.issue;

import org.example.demo.view.components.modal.definitions.NewIssueModalView;
import org.example.demo.view.dto.issue.IssueRequestDTO;
import java.io.IOException;

public class AssembleIssue {
    private static void assembleTitle(NewIssueModalView issue,
                                      IssueRequestDTO request) {
        request.setTitle(issue.getTitle());
    }

    private static void assembleDescription(NewIssueModalView issue,
                                            IssueRequestDTO request) {
        request.setDescription(issue
                .getDescription());
    }

    private static void assembleTypology(NewIssueModalView issue,
                                         IssueRequestDTO request) {
        request.setTypology(issue
                .getTypology()
                .toUpperCase());
    }

    private static void assemblePriority(NewIssueModalView issue,
                                         IssueRequestDTO request) {
        request.setPriority(issue
                .getPriority()
                .toUpperCase());
    }

    private static void assembleImage(NewIssueModalView issue,
                                      IssueRequestDTO request) throws IOException {
        request.setImage(issue.getImage());
    }

    public static IssueRequestDTO assemble(NewIssueModalView issue) throws IOException {
        IssueRequestDTO request =
                new IssueRequestDTO();

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
