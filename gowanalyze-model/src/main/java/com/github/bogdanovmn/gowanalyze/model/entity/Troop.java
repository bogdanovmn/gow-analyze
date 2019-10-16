package com.github.bogdanovmn.gowanalyze.model.entity;

import com.github.bogdanovmn.common.spring.jpa.BaseEntityWithUniqueName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Troop extends BaseEntityWithUniqueName {
	private List<GemColor> colors;
	private int spellCost;
	private String spellText;
	private int attack;
	private int life;
	private int armor;
	private int magic;
	private TraitSet traitSet;
	private String note;
	private Image image;
	private Image spellImage;

}
