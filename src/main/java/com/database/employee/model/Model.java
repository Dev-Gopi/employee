package com.database.employee.model;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Model {
    private String name;
    private String designation;
    private String age;
}
