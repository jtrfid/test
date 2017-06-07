package buzi;
class Sphere {
	
	Point center;
	double radius;
	
	Sphere(int x, int y, int z, double r){
		// TODO
		center = new Point(x,y,z);  // djt
		radius = r;
//		x = center.getX();
//		y = center.getY();
//		z = center.getZ();
//		r = radius;
	}
	
	Sphere(Point c, double r){
		// TODO
		center = c;
//		c = center;
        radius = r;
	}
	
	double getX(){
		return center.getX(); // TODO
	}

	double getY(){
		return center.getY(); // TODO
	}

	double getZ(){
		return center.getZ(); // TODO
	}


	double getRadius(){
		return radius; // TODO
	}

	double calculateDiameter(){
		return 2*radius; // TODO
	}	
	
	double calculatePerimeter(){
		return 2*Math.PI*radius; // TODO
	}
	
	double calculateVolume(){
		return 4*Math.PI*Math.pow(radius,3)/3; // TODO
	}

}

