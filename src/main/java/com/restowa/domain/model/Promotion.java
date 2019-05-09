/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.domain.model;

import java.util.Date;
import javax.persistence.*;
import static javax.persistence.TemporalType.DATE;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Amane
 */
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(name = "key")
    private String key;
    
    @NotEmpty
    @Column(name = "title")
    private String Title;
    
    @NotEmpty
    @Column(name = "shortdescription")
    private String ShortDescription;
    
    @NotEmpty
    @Column(name = "longdescription")
    private String LongDescription;
    
    @NotEmpty
    @Column(name = "position")
    private int Position;
    
    @NotEmpty
    @Column(name = "disabled")
    private boolean Disabled;
    
    @Temporal(DATE)
    @NotEmpty
    @Column(name = "startdate")
    private Date StartDate;
    
    @Temporal(DATE)
    @NotEmpty
    @Column(name = "enddate")
    private Date EndDate;
    
    @Column(name = "Imageurl")
    private String ImageURL;

}
