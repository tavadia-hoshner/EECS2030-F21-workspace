package Lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Vector3DTester {
	
	private double rand() {
		return (int) ((Math.random() * 100.0)*10)/10.0;
	}

	private double negRand() {
		return (int) ((Math.random() * 100.0)*10)/-10.0;
	}

	@Test
	void testCnstr1() {
		double r = Math.random(); 
		double x = 0; 
		double y = 0; 
		double z = 0;
		if (r < 0.5) x = negRand(); 
		else x = rand(); 
		r = Math.random(); 
		if (r < 0.5) y = negRand(); 
		else y = rand(); 
		r = Math.random(); 
		if (r < 0.5) z = negRand(); 
		else z = rand(); 
		Vector3D vect = new Vector3D(x, y, z); 
		testGetX(x, vect); 
		testGetY(y, vect); 
		testGetZ(z, vect); 
	}
	private void testGetX(double x, Vector3D vect) {
		boolean equal = Math.abs(x - vect.getX()) < 0.00001; 
		String message = "getX() or the Constructor is wrong/missing for x = " + x;
		assertTrue(equal, message);
	}

	private void testGetY(double y, Vector3D vect) {
		boolean equal = Math.abs(y - vect.getY()) < 0.00001;
		String message = "getY() or the Constructor is wrong for y = " + y;
		assertTrue(equal, message);
	}
	private void testGetZ(double z, Vector3D vect) {
		boolean equal = Math.abs(z - vect.getZ()) < 0.00001;
		String message = "getX() or the Constructor is wrong for z = " + z;
		assertTrue(equal, message);
	}
	@Test
	void testSetX() {
		Vector3D vect = new Vector3D(5, 6.0, 7.0); 
		vect.setX(99.0);
		boolean equal = Math.abs(99.0 - vect.getX()) < 0.00001;
		String message = "getX() or setX() is wrong/missing";
		assertTrue(equal, message);
	}	

	@Test
	void testAttributeType1() {
		Vector3D vect = new Vector3D(0, 0, 0); 
		boolean equal = (((Object) vect.getX()).getClass().getSimpleName().compareTo("Double") == 0);
		String message = "Type of x is not double";
		assertTrue(equal, message);
	}	

	@Test
	void testAdd2() {
		double r = Math.random(); 
		double x1 = 0; 
		double y1 = 0; 
		double z1 = 0;
		if (r < 0.5) x1 = negRand(); 
		else x1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) y1 = negRand(); 
		else y1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) z1 = negRand(); 
		else z1 = rand(); 
		Vector3D vect1 = new Vector3D(x1, y1, z1); 
		
		r = Math.random(); 
		double x2 = 0; 
		double y2 = 0; 
		double z2 = 0;
		if (r < 0.5) x2 = negRand(); 
		else x2 = rand(); 
		r = Math.random(); 
		if (r < 0.5) y2 = negRand(); 
		else y2 = rand(); 
		r = Math.random(); 
		if (r < 0.5) z2 = negRand(); 
		else z2 = rand(); 
		Vector3D vect2 = new Vector3D(x2, y2, z2); 
		Vector3D vect3 = vect1.add(vect2);

		testGetX(x1 + x2 , vect3); 
		testGetY(y1 + y2, vect3); 
		testGetZ(z1 + z2, vect3); 
	}
	@Test
	void testSubtract1() {
		double x1 = 0; 
		double y1 = 0; 
		double z1 = 0;
		Vector3D vect1 = new Vector3D(x1, y1, z1); 
		double x2 = 10; 
		double y2 = 10; 
		double z2 = 10;
		Vector3D vect2 = new Vector3D(x2, y2, z2); 
		Vector3D vect3 = vect1.subtract(vect2);

		testGetX(x1 - x2 , vect3); 
		testGetY(y1 - y2, vect3); 
		testGetZ(z1 - z2, vect3); 
	}

	@Test
	void testScalarMultiplication1() {
		double r = Math.random(); 
		double x1 = 0; 
		double y1 = 0; 
		double z1 = 0;
		if (r < 0.5) x1 = negRand(); 
		else x1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) y1 = negRand(); 
		else y1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) z1 = negRand(); 
		else z1 = rand(); 
		Vector3D vect1 = new Vector3D(x1, y1, z1); 
		
		r = 0; 
		vect1 = vect1.scalarMultiplication(r);
		testGetX(0, vect1); 
		testGetY(0, vect1); 
		testGetZ(0, vect1); 
	}

	@Test
	void testDotProduct1() {
		double r = Math.random(); 
		double x1 = 0; 
		double y1 = 0; 
		double z1 = 0;
		if (r < 0.5) x1 = negRand(); 
		else x1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) y1 = negRand(); 
		else y1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) z1 = negRand(); 
		else z1 = rand(); 
		Vector3D vect1 = new Vector3D(x1, y1, z1); 
		
		r = Math.random(); 
		double x2 = 0; 
		double y2 = 0; 
		double z2 = 0;
		if (r < 0.5) x2 = negRand(); 
		else x2 = rand(); 
		r = Math.random(); 
		if (r < 0.5) y2 = negRand(); 
		else y2 = rand(); 
		r = Math.random(); 
		if (r < 0.5) z2 = negRand(); 
		else z2 = rand(); 
		Vector3D vect2 = new Vector3D(x2, y2, z2); 

		double prod = vect1.dotProduct(vect2);
		boolean equal = Math.abs((x1*x2+y1*y2+z1*z2)-prod) < 0.00001;
		String message = "dot product is not correct for ["+x1+ ", " + y1 + ", "+ z1 + "] and ["+x2+ ", " + y2 + ", "+ z2 + "]";
		assertTrue(equal, message);

	}

	@Test
	void testMagnitude() {
		double r = Math.random(); 
		double x1 = 0; 
		double y1 = 0; 
		double z1 = 0;
		if (r < 0.5) x1 = negRand(); 
		else x1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) y1 = negRand(); 
		else y1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) z1 = negRand(); 
		else z1 = rand(); 
		Vector3D vect1 = new Vector3D(x1, y1, z1); 
		
		r = Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1); 
		double m = vect1.magnitude();
		boolean equal = Math.abs(m - r) < 0.00001;
		String message = "magnitude() is not correct for ["+x1+ ", " + y1 + ", "+ z1 + "]";
		assertTrue(equal, message);
	}
	@Test
	void testToString() {
		double r = Math.random(); 
		double x1 = 0; 
		double y1 = 0; 
		double z1 = 0;
		if (r < 0.5) x1 = negRand(); 
		else x1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) y1 = negRand(); 
		else y1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) z1 = negRand(); 
		else z1 = rand(); 
		Vector3D vect1 = new Vector3D(x1, y1, z1); 
		String s1 = vect1.toString();
		String s2 = "[" + x1 + ", "+ y1 + ", "+ z1 + "]";
		
		int eq = s1.compareTo(s2);
		boolean equal = eq == 0 ? true : false; 
		String message = "toString() is not correct for ["+x1+ ", " + y1 + ", "+ z1 + "]";
		assertTrue(equal, message);
	}
	@Test
	void testEqual() {
		double r = Math.random(); 
		double x1 = 0; 
		double y1 = 0; 
		double z1 = 0;
		if (r < 0.5) x1 = negRand(); 
		else x1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) y1 = negRand(); 
		else y1 = rand(); 
		r = Math.random(); 
		if (r < 0.5) z1 = negRand(); 
		else z1 = rand(); 
		Vector3D vect1 = new Vector3D(x1, y1, z1); 
		
		r = Math.random(); 
		double x2 = 0; 
		double y2 = 0; 
		double z2 = 0;
		if (r < 0.5) x2 = negRand(); 
		else x2 = rand(); 
		r = Math.random(); 
		if (r < 0.5) y2 = negRand(); 
		else y2 = rand(); 
		r = Math.random(); 
		if (r < 0.5) z2 = negRand(); 
		else z2 = rand(); 
		Vector3D vect2 = new Vector3D(x2, y2, z2); 
		r = Math.random();
		boolean magExpected = vect1.equalTo(vect2, r);
		boolean magActual = Math.abs((Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1)- Math.sqrt(x2 * x2 + y2 * y2 + z2 * z2)))< r; 
		
		boolean equal = (magExpected == magActual);
		String message = "equalTo() is not correct for ["+x1+ ", " + y1 + ", "+ z1 + "], ["+x2+ ", " + y2 + ", "+ z2 + "] and threshold = " + r ;
		assertTrue(equal, message);
	}
	
	@Test
	void testAllFunct() {
		Vector3D vec  = new Vector3D(3.5,4.5,5.5);
		assertTrue(vec.getX()==3.5&&vec.getY()==4.5&&vec.getZ()==5.5,"GetX,Y,Z() Does not work correctly");
		vec.setX(5.5);
		vec.setY(4.5);
		vec.setZ(3.5);
		assertTrue(vec.getX()==5.5&&vec.getY()==4.5&&vec.getZ()==3.5,"SetX,Y,Z() Does not work correctly");
		Vector3D vec2  = new Vector3D();
		assertTrue(vec2.getX()==0&&vec2.getY()==0&&vec2.getZ()==0,"Constructor1 Does not work correctly");
		vec2  = new Vector3D(vec);
		assertTrue(vec2.getX()==5.5&&vec2.getY()==4.5&&vec2.getZ()==3.5,"Constructor2 Does not work correctly");
		vec2 = new Vector3D(5.5,5.5,5.5);
		assertTrue(vec2.getX()==5.5&&vec2.getY()==5.5&&vec2.getZ()==5.5,"Constructor3 Does not work correctly");
		vec = vec.add(vec2);
		assertTrue(vec.getX()==11&&vec.getY()==10&&vec.getZ()==9,"add() Does not work correctly");
		vec = vec.subtract(vec2);
		assertTrue(vec.getX()==5.5&&vec.getY()==4.5&&vec.getZ()==3.5,"subtract() Does not work correctly");
		vec = vec.scalarMultiplication(2.0);
		assertTrue(vec.getX()==11&&vec.getY()==9&&vec.getZ()==7,"scalarMultiplication() Does not work correctly");
		vec = vec.scalarMultiplication(0.5);
		assertTrue(vec.getX()==5.5&&vec.getY()==4.5&&vec.getZ()==3.5,"scalarMultiplication() Does not work correctly");
		assertTrue(vec.dotProduct(vec2)==74.25,"dotProduct() Does not work correctly");
		assertTrue(vec.magnitude()==Math.sqrt(3.5*3.5+4.5*4.5+5.5*5.5)&&vec2.magnitude()==Math.sqrt(5.5*5.5+5.5*5.5+5.5*5.5),"magnitude() Does not work correctly");
		assertTrue(vec.equalTo(vec2, 0)==false,"equalTo() Does not work correctly");
		assertTrue(vec.equalTo(vec2, 1.605),"equalTo() Does not work correctly");
		assertTrue(vec2.equalTo(vec, 1.605),"equalTo() Does not work correctly");
		assertTrue(vec.equalTo(vec, 0),"equalTo() Does not work correctly");
		assertTrue(vec.equalTo(vec2, 1.6047896)==false,"equalTo() Does not work correctly");
		assertTrue(vec.equalTo(vec2, 1.6047897),"equalTo() Does not work correctly");
		
	}
	
}

