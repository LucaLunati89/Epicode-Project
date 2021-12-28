
public class Posizione {
	
	private int longitudineX;
	private int latitudineY;
	int getLongitudineX() {
		return longitudineX;
	}
	void setLongitudineX(int longitudineX) {
		this.longitudineX = longitudineX;
	}
	int getLatitudineY() {
		return latitudineY;
	}
	void setLatitudineY(int latitudineY) {
		this.latitudineY = latitudineY;
	}
	@Override
	public String toString() {
		return "Posizione [longitudineX=" + longitudineX + ", latitudineY=" + latitudineY + "]";
	}
	
	
	
}
