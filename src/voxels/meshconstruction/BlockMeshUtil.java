package voxels.meshconstruction;

import voxels.map.Coord3;

import com.jme3.math.Vector3f;

public class BlockMeshUtil {
	   /*
     * Make four verts,
     * 6 indices and 4 UV vector2s
     * add them to mesh Set
     */
    public static void AddFaceMeshData(Coord3 pos, MeshSet mset, int direction, int triIndexStart)
    {
        FaceVertices(mset, pos, direction);
        UVsForDirection(mset, direction);
        IndicesForDirection(mset, triIndexStart);
    }
    

    public static Vector3f[][] faceVertices = new Vector3f[][] {
        //Xneg
        new Vector3f[] {
            new Vector3f(-0.5f, -0.5f, -0.5f),
            new Vector3f(-0.5f,  0.5f, -0.5f),
            new Vector3f(-0.5f,  0.5f,  0.5f),
            new Vector3f(-0.5f, -0.5f,  0.5f),    
        },
        //Xpos
        new Vector3f[] {
            new Vector3f(0.5f, -0.5f,  0.5f),
            new Vector3f(0.5f,  0.5f,  0.5f),
            new Vector3f(0.5f,  0.5f, -0.5f),
            new Vector3f(0.5f, -0.5f, -0.5f),
        },
        //Yneg
        new Vector3f[] {
            new Vector3f( 0.5f, -0.5f, -0.5f),
            new Vector3f(-0.5f, -0.5f, -0.5f),
            new Vector3f( 0.5f, -0.5f,  0.5f),
            new Vector3f( 0.5f, -0.5f,  0.5f),    
        },
        //Ypos
            new Vector3f[] {
            new Vector3f( 0.5f,  0.5f, -0.5f),
            new Vector3f(-0.5f,  0.5f, -0.5f),
            new Vector3f(-0.5f,  0.5f, -0.5f),
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
            new Vector3f( 0.5f, -0.5f,  0.5f),
            new Vector3f( 0.5f,  0.5f,  0.5f),
            new Vector3f(-0.5f,  0.5f,  0.5f),
            new Vector3f(-0.5f, -0.5f,  0.5f),
            }
    };

private static void FaceVertices(MeshSet mset, Coord3 position, int dir ) {
	Vector3f[] fourFaceVerts = faceVertices[dir];
	for ( int i = 0 ; i < fourFaceVerts.length; i++) {
	    Vector3f cornerVert = fourFaceVerts[i];
	    mset.vertices.add( cornerVert );
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


