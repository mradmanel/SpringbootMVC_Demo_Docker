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

public class Actualite {
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
        
		@Column(name = "titre")
	    private String titre;
		
		@Column(name = "picture")
	    private String picture;
		
		@DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date datePublication;
	    
		
		@Column(name = "description")
	    private String description;


		public Actualite(long id, String titre, String picture, Date dateExpiration, String description) {
			super();
			this.id = id;
			this.titre = titre;
			this.picture = picture;
			this.datePublication = datePublication;
			this.description = description;
		}


		public Actualite() {
			super();
		}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getTitre() {
			return titre;
		}


		public void setTitre(String titre) {
			this.titre = titre;
		}


		public String getPicture() {
			return picture;
		}


		public void setPicture(String picture) {
			this.picture = picture;
		}


		public Date getDatePublication() {
			return datePublication;
		}


		public void setDatePublication(Date datePublication) {
			this.datePublication = datePublication;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}
}
