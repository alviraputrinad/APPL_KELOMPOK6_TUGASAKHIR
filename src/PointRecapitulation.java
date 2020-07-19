public class PointRecapitulation {
	
	private int idStudent;
    private double point;
    
    public PointRecapitulation() {}
    
    public PointRecapitulation(int idStudent, double point) {
    	this.idStudent=idStudent;
    	this.point=point;
    }
    
	public int getIdStudent() {
		return idStudent;
	}
	
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	public double getPoint() {
		return point;
	}
	
	public void setPoint(double point) {
		this.point = point;
	}

}