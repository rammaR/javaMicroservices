package com.rammar.me.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.ArrayList;
import java.util.List;

@Document(indexName = "cart")
@Data
@AllArgsConstructor
@Builder
public class Cart {
    @Id
    private String id;
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }
}
