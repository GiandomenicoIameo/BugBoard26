package org.example.demo.view.mapper.issue;

import org.example.demo.view.components.card.issue.definitions.issueItemCard.IssueItemCardView;
import org.example.demo.view.core.contract.IssuePriority;
import org.example.demo.view.dto.issue.IssueCardResponseDTO;

public class MapperIssueItem {
    private static void mapperId(IssueItemCardView issue,
                                 IssueCardResponseDTO response) {
        issue.setId(response.getId());
    }

    private static void mapperTitle(IssueItemCardView issue,
                                    IssueCardResponseDTO response) {
        issue.setTitle(response.getTitle());
    }

    private static void mapperName(IssueItemCardView issue,
                                   IssueCardResponseDTO response) {
        issue.setName(response
                .getCreatorName());
    }

    private static void mapperPriority(IssueItemCardView card,
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

    private static void mapperDate(IssueItemCardView issue,
                                   IssueCardResponseDTO response) {
        issue.setDate(response.getDate());
    }

    public static <T extends IssueItemCardView> T mapper(
            IssueCardResponseDTO response,
            T issue) {

        mapperId(issue,
                response);
        mapperTitle(issue,
                response);
        mapperName(issue,
                response);

        mapperPriority(issue,
                response);
        mapperDate(issue,
                response);

        return issue;
    }

//    public static List<IssueItemCard> mapper(List<IssueCardResponseDTO> response) {
//        List<IssueItemCard> list = new ArrayList<>();
//
//        for(IssueCardResponseDTO issue : response)
//            list.add(mapper(issue));
//        return list;
//    }
}
