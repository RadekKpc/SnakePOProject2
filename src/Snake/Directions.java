package Snake;

public enum Directions {
    FORWARD, BACKWARD, RIGHT, LEFT;

    public Part toPart(Directions d){
        switch (d){
            case LEFT:
                return new Part(-1,0);

            case RIGHT:
                return new Part(1,0);

            case FORWARD:
                return new Part(0,-1);

            case BACKWARD:
                return new Part(0,1);

                //not need default
        }
        return new Part(0,0);
    }
}
