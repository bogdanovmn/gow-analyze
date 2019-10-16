package com.github.bogdanovmn.gowanalyze.model.entity;

import com.github.bogdanovmn.common.spring.jpa.BaseEntityWithUniqueName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Kingdom extends BaseEntityWithUniqueName {
	private Collection<BannerColorComponent> colors;
	private Collection<Troop> troops;
	private Image image;
	private Banner banner;
	private Tribute tribute;
	private Skill skillBonus;
	private Traitstone traitstone;
	private String title;
	private String note;
}
