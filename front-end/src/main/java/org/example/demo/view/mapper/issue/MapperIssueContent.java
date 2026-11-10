package org.example.demo.view.mapper.issue;

import org.example.demo.view.components.card.issue.definitions.issueContentCard.IssueContentCardView;
import org.example.demo.view.core.contract.IssueState;
import org.example.demo.view.dto.issue.IssueResponseDTO;

public class MapperIssueContent {
    private static void mapperTitle(IssueContentCardView issue,
                                    IssueResponseDTO response) {
        issue.setTitle(response.getTitle());
    }

    private static void mapperName(IssueContentCardView issue,
                                   IssueResponseDTO response) {
        issue.setName(response
                .getCreatorName());
    }

    private static void mapperDescription(IssueContentCardView issue,
                                          IssueResponseDTO response) {
        issue.setDescpription(response
                .getDescription());
    }

    private static void mapperImage(IssueContentCardView issue,
                                    IssueResponseDTO response) {
        issue.setImage(response.getId());
    }

    private static void mapperState(IssueContentCardView card,
                                    IssueResponseDTO response) {
        card.setState(toState(response
                .getState()));
    }

    private static IssueState toState(String state) {
        if("TODO".equals(state))
            return IssueState.TODO;
        else if("CHIUSO".equals(state))
            return IssueState.CHIUSO;
        else
            throw new IllegalArgumentException(
                    "Stato sconosciuto");
    }

    private static void mapperDate(IssueContentCardView issue,
                                   IssueResponseDTO response) {
        issue.setDate(response.getDate());
    }

    private static void mapperDuplicate(IssueContentCardView issue,
                                        IssueResponseDTO response) {
        if(response.getDuplicated() != null)
            issue.setDuplicated(response
                    .getDuplicated());
    }

    public static <T extends IssueContentCardView> T mapper(
            IssueResponseDTO response,
            T card) {

        mapperTitle(card,
                response);
        mapperDescription(card,
                response);
        mapperImage(card,
                response);
        mapperDate(card,
                response);
        mapperName(card,
                response);
        mapperState(card,
                response);
        mapperDuplicate(card,
                response);

        return card;
    }
}
