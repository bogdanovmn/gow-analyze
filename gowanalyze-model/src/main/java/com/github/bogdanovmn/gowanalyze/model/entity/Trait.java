package com.github.bogdanovmn.gowanalyze.model.entity;

import com.github.bogdanovmn.common.spring.jpa.BaseEntityWithUniqueName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Trait extends BaseEntityWithUniqueName {
	private String description;
}
