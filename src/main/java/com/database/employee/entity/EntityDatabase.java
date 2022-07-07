package com.database.employee.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "employee")
public class EntityDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "uuid", nullable = false)
    private String uuid;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "designation", nullable = false)
    private String designation;
    @Column(name = "age", nullable = false)
    private String age;
}
