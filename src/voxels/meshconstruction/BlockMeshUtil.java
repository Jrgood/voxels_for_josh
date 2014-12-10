package voxels.meshconstruction;

import java.util.Arrays;

import voxels.map.Coord3;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;

public class BlockMeshUtil {
	   /*
     * Make four verts,
     * 6 indices and 4 UV vector2s
     * add them to mesh Set
     */
	// JOSH: FIND COMMENTS HERE THAT EXPLAIN SOME FIXES
    public static void AddFaceMeshData(Coord3 pos, MeshSet mset, int direction, int triIndexStart)
    {
        FaceVertices(mset, pos, direction);
        //JOSH: YOU NEEDED THESE TWO LINES TO BE UNCOMMENTED 
        UVsForDirection(mset, direction);
        IndicesForDirection(mset, triIndexStart);
    }
    //JOSH: YOU ALSO NEEDED THIS ARRAY.
    private static final int[] FaceIndices = new int[] {0,3,2, 0,2,1};
    //AND THIS METHOD
    private static void IndicesForDirection(MeshSet mset, int triIndexStart) {
        for (int index = 0; index < FaceIndices.length; index++) {
            int i = FaceIndices[index];
            mset.indices.add(i + triIndexStart);
        }
    }
    private static void UVsForDirection(MeshSet mset, int dir) {
//      mset.uvs.addAll(uvs); // DELETE THIS!
      /*
       * CHANGE THE X AND Y OF OFFSETSTART. X AND Y CAN EACH BE 0f, .25f, .5f, or .75f 
       * TRY ANY OF THE 16 COMBINATIONS: (.25f, .25f) for stone, (0f, .75f) for side grass
       * LOOK AT THE TEXTURE "dog_64d_.jpg" TO SEE THAT YOUR CHOICE CORRESPONDS TO THE 
       * TILE OFFSET INDICATED BY X AND Y. YOU MUST EDIT THE FRAGMENT SHADER, AS DESCRIBED HERE:
       * http://voxel.matthewpoindexter.com/class/block-faces-part-2-1-fixing-the-annoyingly-mis-aligned-texture/
       * FOR THIS TO WORK (WELL). 
       */
      Vector2f offsetStart = new Vector2f(.5f,0f);
      mset.uvs.addAll(Arrays.asList(
              offsetStart ,
              new Vector2f(offsetStart.x, offsetStart.y +.25f),
              new Vector2f(offsetStart.x + .25f, offsetStart.y + .25f),
              new Vector2f(offsetStart.x + .25f, offsetStart.y)
              ));
  }

    public static Vector3f[][] faceVertices = new Vector3f[][] {
    	/*
    	 * TODO: WORK FOR JOSH: EDIT YOUR VECTOR ARRAYS YPOS AND YNEG
    	 * THEY CURRENTLY HAVE DUPLICATE VERTS IN THEM--MAKING YOUR CUBE LOOK UN-CUBE-LIKE.
    	 * 1.)CHANGE ONE VECTOR3F IN BOTH YNEG AND YPOS SO THAT ALL FOR ARE DIFFERENT.
    	 * 2.)RUN YOUR PROGRAM. YOU WILL NOT SEE TEXTURES ON ALL SIDES OF YOUR CUBE BECAUSE
    	 * THE ORDER OF THE VECTORS WITHIN CERTAIN SETS OF FOUR NEEDS TO BE CHANGED.
    	 * (TIP: USE OPTION + ARROW UP OR DOWN TO MOVE ENTIRE LINES UP OR DOWN.)
    	 * PLEASE, ASK ME FOR HELP TWEAKING VECTOR ORDER! 
    	 * 
    	 */
        //Xneg
        new Vector3f[] {
            new Vector3f(-0.5f, -0.5f, -0.5f),
            new Vector3f(-0.5f,  0.5f, -0.5f),
            new Vector3f(-0.5f,  0.5f,  0.5f),
            new Vector3f(-0.5f, -0.5f,  0.5f),    
        },
        //Xpos
        new Vector3f[] {
            new Vector3f(0.5f,  0.5f,  0.5f),
            new Vector3f(0.5f,  0.5f, -0.5f),
            new Vector3f(0.5f, -0.5f, -0.5f),
        
            new Vector3f(0.5f, -0.5f,  0.5f),
        },
        //Yneg
        new Vector3f[] {
            new Vector3f( 0.5f, -0.5f, -0.5f),
            new Vector3f(-0.5f, -0.5f, -0.5f),
            new Vector3f(-0.5f, -0.5f,  0.5f),
            new Vector3f( 0.5f, -0.5f,  0.5f), //TODO: THIS ONE IS THE SAME AS THE LAST ONE   
        },
        //Ypos
            new Vector3f[] {
        	new Vector3f(-0.5f,  0.5f,  0.5f), //TODO: THIS ONE IS THE SAME AS THE LAST ONE
        	
            new Vector3f(-0.5f,  0.5f, -0.5f),
            new Vector3f( 0.5f,  0.5f, -0.5f),
            new Vector3f( 0.5f,  0.5f,  0.5f),
            },
        
        //Zneg
            new Vector3f[] {
            new Vector3f( 0.5f, -0.5f, -0.5f),
            new Vector3f( 0.5f,  0.5f, -0.5f),
            new Vector3f(-0.5f,  0.5f, -0.5f),
            new Vector3f(-0.5f, -0.5f, -0.5f),    
        },
        //Zpos
            new Vector3f[] {
        	new Vector3f(-0.5f,  0.5f,  0.5f),
            new Vector3f( 0.5f,  0.5f,  0.5f),
            
            new Vector3f( 0.5f, -0.5f,  0.5f),
            new Vector3f(-0.5f, -0.5f,  0.5f),
            }
    };

private static void FaceVertices(MeshSet mset, Coord3 position, int dir ) {
	Vector3f[] fourFaceVerts = faceVertices[dir];
	for ( int i = 0 ; i < fourFaceVerts.length; i++) {
//	    Vector3f cornerVert = fourFaceVerts[i];
//	    mset.vertices.add( cornerVert ); //COMMENTED OUT THIS LINE AND ABOVE
	    mset.vertices.add(fourFaceVerts[i].add(position.toVector3f())); 
	    //Vector3f cornerVert = fourFaceVerts[i];
	    //Vector3f positionAsVector3f = position.toVector3f();
	    //Vector3f finalVector = cornerVert.add(positionAsVector3f);
	    //mset.vertices.add(finalVector); 
	}
}


public class Direction {
    public static final int XNEG = 0, XPOS = 1, YNEG = 2, YPOS = 3, ZNEG=4, ZPOS=5;
}
}


