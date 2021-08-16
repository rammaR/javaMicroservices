package com.rammar.me.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    private Integer productID;
    private Integer quantity;
}
