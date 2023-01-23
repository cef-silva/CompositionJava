package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
		
	private Client client;
	private List<OrderItem> orders = new ArrayList<>();
	
	public Order() {	
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrders() {
		return orders;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		orders.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orders.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for (OrderItem o: orders) {
			sum += o.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMARY: \n");
		sb.append("Order moment: " + sdf2.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + " (" + sdf.format(client.getBirthDate()) + ") - " + client.getEmail() +"\n");
		sb.append("Order items:\n");
		
		for(OrderItem o: orders) {
			sb.append(o.getProduct().getName() + ", Quantity: " + o.getQuantity() + ", Subtotal: " + o.subTotal() + "\n");
		}
		
		sb.append("Total price: " + total());
		return sb.toString();
	}
}
