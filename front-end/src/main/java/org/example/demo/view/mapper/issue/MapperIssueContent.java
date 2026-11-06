package org.example.demo.view.mapper.issue;

import org.example.demo.view.components.card.issue.definitions.issueContentCard.IssueContentCardView;
import org.example.demo.view.core.contract.IssueState;
import org.example.demo.view.dto.issue.IssueCardResponseDTO;

public class MapperIssueContent {
    private static void mapperTitle(IssueContentCardView issue,
                                    IssueCardResponseDTO response) {
        issue.setTitle(response.getTitle());
    }

    private static void mapperName(IssueContentCardView issue,
                                   IssueCardResponseDTO response) {
        issue.setName(response
                .getCreatorName());
    }

    private static void mapperDescription(IssueContentCardView issue,
                                          IssueCardResponseDTO response) {
        issue.setDescpription(response
                .getDescription());
    }

    private static void mapperImage(IssueContentCardView issue,
                                    IssueCardResponseDTO response) {
        issue.setImage(response.getId());
    }

    private static void mapperState(IssueContentCardView card,
                                    IssueCardResponseDTO response) {
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
                                   IssueCardResponseDTO response) {
        issue.setDate(response.getDate());
    }

    private static void mapperDuplicate(IssueContentCardView issue,
                                        IssueCardResponseDTO response) {
        if(response.getDuplicated() != null)
            issue.setDuplicated(response
                    .getDuplicated());
    }

    public static <T extends IssueContentCardView> T mapper(
            IssueCardResponseDTO response,
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
