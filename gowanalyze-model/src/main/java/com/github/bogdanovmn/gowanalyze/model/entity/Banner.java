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
public class Banner extends BaseEntityWithUniqueName {
	private Collection<BannerColorComponent> colors;
}
