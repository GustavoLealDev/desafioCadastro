package model.entities;

public class PetAddress {

	private String road;
	private Integer numberHouse;
	private String neighborhood;

	public PetAddress() {
	}

	public PetAddress(String road, Integer numberHouse, String neighborhood) {
		this.road = road;
		this.numberHouse = numberHouse;
		this.neighborhood = neighborhood;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public Integer getNumberHouse() {
		return numberHouse;
	}

	public void setNumberHouse(Integer numberHouse) {
		this.numberHouse = numberHouse;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	@Override
	public String toString() {
		return road + ", " + numberHouse + ", " + neighborhood;
	}
}
