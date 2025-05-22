/**
 * Cassidoo Interview question of the week @ https://buttondown.com/cassidoo/archive/imagination-is-more-important-than-knowledge/
 * Solution inspired by algorithm from https://codepen.io/Tzyinc/pen/GggaJpM
 */
public class ASCIICubeArt{
    public static void main(String[] args){
        cubeArt(2);
        cubeArt(4);
        cubeArt(6);
    }

    public static void cubeArt(int height){
        String horizontalChar = "-";
        String cornerChar = "+";
        String verticalChar = "|";
        String diagonalChar = "/";
        String space = " ";
        int horizontalFactor = 2;
        int horizontalCorners = 2;
        int horizontalLength = horizontalFactor * height;
        int paddingFirstRow = height / 2 + 1;
        int cubeArtHeight = 3 + (3 * height) / 2;

        int firstRowCube = height * horizontalFactor + horizontalCorners;
        String horizontalEdgeOfCube = "";
        for (int i = 0; i < firstRowCube; i++) {
            if(i == 0 || i == (firstRowCube -1)){
                horizontalEdgeOfCube = horizontalEdgeOfCube.concat(cornerChar);
            } else {
                horizontalEdgeOfCube = horizontalEdgeOfCube.concat(horizontalChar);
            }
        }
        for (int i = 0; i < cubeArtHeight; i++) {
            if(i == 0){
                System.out.println(space.repeat(paddingFirstRow).concat(horizontalEdgeOfCube));
            }
            else if (i > 0 && i < paddingFirstRow) {
                System.out.println(space.repeat(paddingFirstRow-i).concat(diagonalChar).concat(space.repeat(horizontalLength))
                .concat(diagonalChar).concat(space.repeat(Math.max(i-1, 0))).concat(verticalChar));
            }
            else if(i == paddingFirstRow){
                System.out.println(horizontalEdgeOfCube.concat(space.repeat(paddingFirstRow-1)).concat(verticalChar));
            }
            else if(i > paddingFirstRow && i < cubeArtHeight-1){
                String endChar = verticalChar;
                int paddingSideCube = paddingFirstRow-1;
                if (i == height + 1) {
                    endChar = cornerChar;
                }
                if (i > height + 1) {
                    endChar = diagonalChar;
                    paddingSideCube = cubeArtHeight - i - 2;
                }
                System.out.println(verticalChar.concat(space.repeat(horizontalLength)).concat(verticalChar).
                concat(space.repeat(paddingSideCube)).concat(endChar));
            }
            else if( i == cubeArtHeight -1){
                System.out.println(horizontalEdgeOfCube);
            }
        }
    }
}