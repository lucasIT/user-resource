package com.userresource.domain.model;

import com.userresource.domain.enumeration.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Lucas Vieira
 * @version 1.0
 * @since 11/14/2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role", schema = "fl")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
    @SequenceGenerator(name = "seq_role", schema = "fl", allocationSize = 1)
    private Long id;

    @Column(length = 20)
    private String name;


}
