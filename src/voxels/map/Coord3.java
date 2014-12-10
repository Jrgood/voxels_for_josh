package voxels.map;

import com.jme3.math.Vector3f;

public class Coord3 {
	
	public int x;
	public int y;
	public int z;
	
	public Coord3(int xx, int yy, int zz) {
		  x = xx;
		  y = yy;
		  z = zz;
		}
	
	public Vector3f toVector3f() {
		  return new Vector3f(x,y,z);
		} 
	//Write plus minus divide multiply todo
	
}
