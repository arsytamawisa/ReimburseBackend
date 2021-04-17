package com.enigma.reimbursment.online.models.pagination;

import org.springframework.data.domain.Sort;

import javax.validation.constraints.Max;

public class PageSearch {

    @Max(100)
    private Integer size = 10;
    private Integer page = 0;
    private Sort.Direction sort = Sort.Direction.ASC;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Sort.Direction getSort() {
        return sort;
    }

    public void setSort(Sort.Direction sort) {
        this.sort = sort;
    }

}
