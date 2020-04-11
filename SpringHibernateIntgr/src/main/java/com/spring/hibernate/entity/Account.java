package com.spring.hibernate.entity;
	
	import javax.persistence.*;
	@Entity
	@Table(name = "ACCOUNT_SPRING")
	public class Account 
	{
		@GeneratedValue
		@Id
		@Column(name="ACC_ID")
		private int id;
		
		@Column(name="NAME")
		private String name;

		@Column(name="BALANCE")
		private String balance;

		public Account() {
			super();
		}

		public Account(int id, String name, String balance) {
			super();
			this.id = id;
			this.name = name;
			this.balance = balance;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBalance() {
			return balance;
		}

		public void setBalance(String balance) {
			this.balance = balance;
		}

		@Override
		public String toString() {
			return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
		}

}
