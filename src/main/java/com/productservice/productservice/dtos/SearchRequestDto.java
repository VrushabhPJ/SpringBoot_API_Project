package com.productservice.productservice.dtos;

import com.productservice.productservice.models.SortParam;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
public class SearchRequestDto {
    private String title;
    private int pageNumber;
    private int itemsPerPage;
    private List<SortParam> sortParams;
}
