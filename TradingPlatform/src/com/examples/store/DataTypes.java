package com.examples.store;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JPA_DATATYPE")
public class DataTypes {
	
	@Id
	@Column(name = "D_INT")
	int intId;

	@Column(name = "D_SHORT")
	short shortId;
	
	@Column(name = "D_LONG")
	long longId;
	
	@Column(name = "D_BYTE")
	byte byteId;
	
	@Column(name = "D_FLOAT")
	float floatId;
	
	@Column(name = "D_DOUBLE")
	double doubleId;
	
	@Column(name = "D_BIGDECIMAL")
	BigDecimal bigDecimalId;		
	
	@Column(name = "D_NUMBER")
	Number numberId;		
	
	@Column(name = "D_INTEGER")
	Integer integerId;	
	
	@Column(name = "D_STRING")
	String stringName1;
	
	@Column(name = "D_CHAR")
	char charName;

	@Column(name = "C_D_STRING", length=500)
	String stringName2;
	
	@Column(name = "C_D_INT", columnDefinition="NUMBER(5,0) NOT NULL UNIQUE")
	int intId1;
	
	@Column(name = "C_D_BIGDECIMAL", precision=12, scale=4)
	BigDecimal bigDecimalId2;	

}
