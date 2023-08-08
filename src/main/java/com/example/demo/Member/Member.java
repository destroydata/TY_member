package com.example.demo.Member;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "members")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer number;
    private String image;

}
