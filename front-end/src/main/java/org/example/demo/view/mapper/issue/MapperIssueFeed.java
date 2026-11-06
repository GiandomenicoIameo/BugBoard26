package org.example.demo.view.mapper.issue;

import org.example.demo.view.components.card.issue.definitions.issueFeedCard.IssueFeedCardView;
import org.example.demo.view.core.contract.IssuePriority;
import org.example.demo.view.core.contract.IssueState;
import org.example.demo.view.core.contract.IssueTypology;
import org.example.demo.view.dto.issue.IssueCardResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MapperIssueFeed {
    private static void mapperTitle(IssueFeedCardView card,
                                    IssueCardResponseDTO response) {
        card.setTitle(response
                .getTitle());
    }

    private static void mapperId(IssueFeedCardView card,
                                 IssueCardResponseDTO response) {
        card.setId(response.getId());
    }

    private static void mapperName(IssueFeedCardView card,
                                   IssueCardResponseDTO response) {
        card.setName(response.getCreator()
                .getName());
    }

    private static void mapperTypology(IssueFeedCardView card,
                                       IssueCardResponseDTO response) {
        card.setTypology(toTypology(response
                .getTypology()));
    }

    private static IssueTypology toTypology(String typology) {
        if("BUG".equals(typology))
            return IssueTypology
                    .BUG;
        else if("FEATURE".equals(typology))
            return IssueTypology
                    .FEATURE;
        else if("QUESTION".equals(typology))
            return IssueTypology
                    .QUESTION;
        else if("DOCUMENTATION".equals(typology))
            return IssueTypology
                    .DOCUMENTATION;
        else
            return null;
    }

    private static void mapperPriority(IssueFeedCardView card,
                                       IssueCardResponseDTO response) {
        card.setPriority(toPriority(response
                .getPriority()));
    }

    private static IssuePriority toPriority(String priority) {
        if("ALTA".equals(priority))
            return IssuePriority
                    .ALTA;
        else if("MEDIA".equals(priority))
            return IssuePriority
                    .MEDIA;
        else if("BASSA".equals(priority))
            return IssuePriority
                    .BASSA;
        else
            return null;
    }

    private static void mapperAssegnee(IssueFeedCardView card,
                                       IssueCardResponseDTO response) {
        card.setAssignee(response.getAssignee() !=  null);
    }

    private static void mapperState(IssueFeedCardView card,
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

    private static void mapperDuplicated(IssueFeedCardView card,
                                         IssueCardResponseDTO response) {
        if(response.getDuplicated() != null)
            card.setDuplicated(response
                    .getDuplicated());
    }

    public static <T extends IssueFeedCardView> T mapper(
            IssueCardResponseDTO response, T card) {

        mapperId(card,
                response);
        mapperTypology(card,
                response);
        mapperPriority(card,
                response);
        mapperAssegnee(card,
                response);
        mapperDuplicated(card,
                response);

        mapperTitle(card,
                response);
        mapperName(card,
                response);
        mapperState(card,
                response);

        return card;
    }

    public static <T extends IssueFeedCardView> List<T> mapper(
            List<IssueCardResponseDTO> list, Supplier<T> supplier) {
        List<T> cards = new ArrayList<>();

        for(IssueCardResponseDTO issue : list)
            cards.add(mapper(issue,
                    supplier.get()));
        return cards;
    }
}
