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
    private String title;
    
    @NotEmpty
    @Column(name = "shortdescription")
    private String shortDescription;
    
    @NotEmpty
    @Column(name = "longdescription")
    private String longDescription;
    
    @NotEmpty
    @Column(name = "position")
    private int position;
    
    @NotEmpty
    @Column(name = "disabled")
    private boolean disabled;
    
    @Temporal(DATE)
    @NotEmpty
    @Column(name = "startdate")
    private Date startDate;
    
    @Temporal(DATE)
    @NotEmpty
    @Column(name = "enddate")
    private Date endDate;
    
    @Column(name = "Imageurl")
    private String ismageURL;

}
