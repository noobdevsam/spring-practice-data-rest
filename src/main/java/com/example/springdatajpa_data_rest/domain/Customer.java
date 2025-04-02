package com.example.springdatajpa_data_rest.domain;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Customer {
    private UUID id;
    private String name;
}