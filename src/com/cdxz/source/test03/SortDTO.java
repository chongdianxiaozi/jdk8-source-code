package com.cdxz.source.test03;

public class SortDTO {
    private String sortTarget;

    public SortDTO(String sortTarget) {
        this.sortTarget = sortTarget;
    }

    public String getSortTarget() {
        return sortTarget;
    }

    public void setSortTarget(String sortTarget) {
        this.sortTarget = sortTarget;
    }

    @Override
    public String toString() {
        return "SortDTO{" +
                "sortTarget='" + sortTarget + '\'' +
                '}';
    }
}
