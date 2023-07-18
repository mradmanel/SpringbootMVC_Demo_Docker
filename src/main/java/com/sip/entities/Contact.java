package com.sip.entities;



	 
	 import java.io.Serializable;
     import java.util.Date;

    import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.validation.constraints.Email;
	import javax.validation.constraints.NotBlank;
	import javax.validation.constraints.Pattern;
	import javax.validation.constraints.Size;
	
	import org.hibernate.annotations.Cache;
	import org.hibernate.annotations.CacheConcurrencyStrategy;
    import org.springframework.format.annotation.DateTimeFormat;
    import org.springframework.validation.annotation.Validated;
	 
	@Validated
	@Entity
	@Table(name = "contact")
	
	public class Contact  {
	 
	    
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "name")
	    private String name;
	    
	    @Email(message = "Email")
	    private String email;

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date dateHeursMessage;
	    

	    @Column(name = "Objet")
	    private String objet;
	    
	    @Column(length = 4000)
	    private String message;

		public Contact() {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.dateHeursMessage = dateHeursMessage;
			this.objet = objet;
			this.message = message;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getDateHeursMessage() {
			return dateHeursMessage;
		}

		public void setDateHeursMessage(Date dateHeursMessage) {
			this.dateHeursMessage = dateHeursMessage;
		}

		public String getObjet() {
			return objet;
		}

		public void setObjet(String objet) {
			this.objet = objet;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}