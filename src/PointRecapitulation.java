public class PointRecapitulation {
	
	private String idStudent;
    private double point;
    
    public PointRecapitulation() {}
    
    public PointRecapitulation(String idStudent, double point) {
    	this.idStudent=idStudent;
    	this.point=point;
    }
    
	public String getIdStudent() {
		return idStudent;
	}
	
	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}
	
	public double getPoint() {
		return point;
	}
	
	public void setPoint(double point) {
		this.point = point;
	}

}