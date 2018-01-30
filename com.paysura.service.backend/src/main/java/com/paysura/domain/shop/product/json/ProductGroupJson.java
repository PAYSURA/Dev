package com.paysura.domain.shop.product.json;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductGroupJson implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotEmpty
	@NotBlank
	private String productGroupName;

	/**
	 * Advanced constructor
	 * 
	 * @param productGroupName
	 *            Name of the group.
	 */
	@JsonCreator
	public ProductGroupJson(@JsonProperty(value = "productGroupName") final String productGroupName) {
		super();
		this.setProductGroupName(productGroupName);
	}

}
