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
class Traitstone extends BaseEntityWithUniqueName {
	private Image image;
	private Rarity rarity;
}
