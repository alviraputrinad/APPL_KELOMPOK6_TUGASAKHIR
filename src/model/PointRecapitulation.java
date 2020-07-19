package model;

public class PointRecapitulation {
	
	private int idStudent;
    private int point;
    
    public PointRecapitulation() {}
    
    public PointRecapitulation(int idStudent, int point) {
    	this.idStudent=idStudent;
    	this.point=point;
    }
    
	public int getIdStudent() {
		return idStudent;
	}
	
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
}