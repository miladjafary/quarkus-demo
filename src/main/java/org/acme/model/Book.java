package org.acme.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Book extends PanacheEntity {
    public String name;
    public String author;

    public static Book findByName(String name) {
        return find("name", name).firstResult();
    }
}
