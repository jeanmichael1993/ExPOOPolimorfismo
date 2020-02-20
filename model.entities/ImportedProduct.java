package model.entities;

	public class ImportedProduct extends Product{

		private Double customsFee;
	
		public ImportedProduct(){
			super();
		}

		public ImportedProduct(String name, double price, double customsFee){
			super(name, price);
			this.customsFee = customsFee;
		}

		public Double getCustomsFee(){
			return customsFee;
		}

		public void setCustomsFee(Double customsFee){
			this.customsFee = customsFee;
		}
		@Override
		public String priceTag(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.getName());
		sb.append(" $ ");
		sb.append(String.format("%.2f",totalPrice()));
		sb.append(" (Customs fee: $ ");
		sb.append(String.format("%.2f",getCustomsFee()) + ")");
		return sb.toString();
		}

		public Double totalPrice(){
			return customsFee + super.getPrice();
		}



	}