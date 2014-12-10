package voxels.generate;

import voxels.map.Coord3;

/*
 * 
 */
	/*
	 * 
	 */
	public class Chunk {
	    public final static int XLENGTH = 16;
	    public final static int YLENGTH = 16;
	    public final static int ZLENGTH = 16;
	    
	    /*
	     * Chunk Position Methods
	     * Chunk Positions are always the same as 
	     * the position of the first block in the chunk (block at lower, xneg, zneg corner with local pos: (0,0,0))
	     * divided by their lengths (16 in other words)
	     * example: if ChunkPos is (1, 0, 0)
	     * its "first" block is at world pos (16, 0, 0)
	     * (16, 0, 0) would also be the chunk's "WorldPosition"
	     * Conversely, a block with world pos (16, 0, 2)
	     * would have chunk local pos (0, 0, 2)
	     */
	    public static Coord3 ToChunkPosition(int pointX, int pointY, int pointZ) {
	      	        return new Coord3(pointX/XLENGTH, pointY/YLENGTH, pointZ/ZLENGTH);
	    }
	    public static Coord3 toChunkLocalCoord(Coord3 woco) {
	        return toChunkLocalCoord(woco.x, woco.y, woco.z);
	    }
	    public static Coord3 toChunkLocalCoord(int x, int y, int z) {
	        // TRICKY FOR NEGATIVE NUMBERS!
	        // FOR NOW, USE MOD TO MAKE A SOLUTION THAT 
	        // WORKS FOR POSITIVE NUMBERS
	    
	        return new Coord3(x%XLENGTH, y%YLENGTH, z%ZLENGTH);
	    }
	    
	    public static Coord3 ToWorldPosition(Coord3 chunkPosition) {
	        return null; // HINT: use the method below to find the world position of a block at localPosition = (0,0,0)
	    }
	    public static Coord3 ToWorldPosition(Coord3 chunkPosition, Coord3 localPosition) {
	        /*
	         * Opposite of ToChunkPosition
	         */
	    	Coord3 global = new Coord3(chunkPosition.x*XLENGTH, chunkPosition.y*YLENGTH, chunkPosition.z*ZLENGTH);
	    	return global.plus(localPosition);
	    }
	}


