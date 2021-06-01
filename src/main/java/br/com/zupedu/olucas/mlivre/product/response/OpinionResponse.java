package br.com.zupedu.olucas.mlivre.product.response;

import br.com.zupedu.olucas.mlivre.product.model.Opinion;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class OpinionResponse {
    private Double averageGrades;
    private Long totalGrades;
    private List<OpinionDetailResponse> opinionDetails;


    public OpinionResponse(List<Opinion> opinions) {
        IntSummaryStatistics statistics = opinions.stream()
                .mapToInt(opinion -> opinion.getGrade())
                .summaryStatistics();

        this.opinionDetails = opinions.stream()
                .map(opinion -> new OpinionDetailResponse(opinion))
                .collect(Collectors.toList());

        this.averageGrades = statistics.getAverage();
        this.totalGrades = statistics.getCount();
    }

    public Double getAverageGrades() {
        return averageGrades;
    }

    public Long getTotalGrades() {
        return totalGrades;
    }

    public List<OpinionDetailResponse> getOpinionDetails() {
        return opinionDetails;
    }
}
