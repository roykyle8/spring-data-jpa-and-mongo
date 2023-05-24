package com.example.demo.mongo;

import com.example.demo.jpa.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Product {

    @Id
    private String id;

    private String name;

    @DocumentReference
    private User testedBy;

}
