package com.nomani.ordermanagement.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {
    @Embeddable
    public class EntityPropertyPK {
        @Column(name = "name")
        private String name;

        @ManyToOne
        @JoinColumn(name = "entity_id")
        private Entity entity;

    }
}
