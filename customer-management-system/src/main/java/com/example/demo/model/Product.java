package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Product {


		@Id
		@Column(name = "id")
		private int productId;
		@Column(name = "product_name")
		private String productName;
		@Column(name = "product_price")
		private String productPrice;
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Product(int productId, String productName, String productPrice) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productPrice = productPrice;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(String productPrice) {
			this.productPrice = productPrice;
		}
		

}
