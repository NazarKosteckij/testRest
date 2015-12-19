package com.test.rest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Назар on 19.12.2015.
 */
@Table(name="commands")
@Entity
public class CommandRequestModel {
    @Id
    @GeneratedValue
    private int id;

}
