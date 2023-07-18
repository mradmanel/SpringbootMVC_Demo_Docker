	package com.sip.entities;

	import java.util.Date;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	


	import org.hibernate.annotations.OnDelete;
	import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.unit.DataSize;

    import com.fasterxml.jackson.annotation.JsonBackReference;
	import com.fasterxml.jackson.annotation.JsonCreator;
	import com.fasterxml.jackson.annotation.JsonIgnore;


	@Entity


	public class Article {
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;


	    @Column(name = "label")
	    private String label;
	    
	    @Column(name = "picture")
	    private String picture;
	    
	    @Column(name = "price")
	    private float price;
	    
	    @Column(name = "description")
	    private String description;
        
	    @Column(name = "quantiteStock")
	    private int quantiteStock ;
	    
	    @Column(name = "prixPromotion")
	    private double prixPromotion;
        
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date dateExpiration;
	    
	    @Column(name = "idProvider")
	    private int idProvider;
		
		public Article() {
			super();
		}

		public long getId() {
			return id;
		}





		public void setId(long id) {
			this.id = id;
		}





		public String getLabel() {
			return label;
		}





		public void setLabel(String label) {
			this.label = label;
		}





		public String getPicture() {
			return picture;
		}





		public void setPicture(String picture) {
			this.picture = picture;
		}





		public float getPrice() {
			return price;
		}





		public void setPrice(float price) {
			this.price = price;
		}





		public String getDescription() {
			return description;
		}





		public void setDescription(String description) {
			this.description = description;
		}





		public int getQuantiteStock() {
			return quantiteStock;
		}





		public void setQuantiteStock(int quantiteStock) {
			this.quantiteStock = quantiteStock;
		}





		public double getPrixPromotion() {
			return prixPromotion;
		}





		public void setPrixPromotion(double prixPromotion) {
			this.prixPromotion = prixPromotion;
		}





		public Date getDateExpiration() {
			return dateExpiration;
		}





		public void setDateExpiration(Date dateExpiration) {
			this.dateExpiration = dateExpiration;
		}





		




		public int getIdProvider() {
			return idProvider;
		}





		public void setIdProvider(int idProvider) {
			this.idProvider = idProvider;
		}





		public Article(long id, String label, String picture, float price, String description, int quantiteStock,
				double prixPromotion, Date dateExpiration, int idProvider, Provider provider) {
			super();
			this.id = id;
			this.label = label;
			this.picture = picture;
			this.price = price;
			this.description = description;
			this.quantiteStock = quantiteStock;
			this.prixPromotion = prixPromotion;
			this.dateExpiration = dateExpiration;
			this.idProvider = idProvider;
			this.provider = provider;
		}





		/**** Many To One ****/
		
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "provider_id", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    private Provider provider;
		
		public Provider getProvider() {
			return provider;
		}


		public void setProvider(Provider provider) {
			this.provider = provider;
		}
		
	   
		    




			
}
