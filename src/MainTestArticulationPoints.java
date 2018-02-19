import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTestArticulationPoints {
    Solver solver;

    @Before
    public void setUp(){
        solver = new Solver();
    }

    @Test
    public void test1(){

        assertEquals("[2, 1]",solver.solve(4,3,new int[]{0,1, 1, 2, 2, 3}).toString());

    }
    @Test
    public void test2(){
        assertEquals("[1]",solver.solve(7,8,new int[]{0,1,0,2,2,1,1,6,1,4,1,3,3,5,4,5}).toString());
    }
    @Test
    public void test3(){
        assertEquals("[3, 0]",solver.solve(5,5,new int[]{0,1,1,2,2,0,0,3,3,4}).toString());
    }
//Test cases for bridges

    @Test
    public void test4(){

        assertEquals("[2, 3, 1, 2, 0, 1]",solver.solve1(4,3,new int[]{0,1, 1, 2, 2, 3}).toString());

    }
    @Test
    public void test5(){
        assertEquals("[1, 6]",solver.solve1(7,8,new int[]{0,1,0,2,2,1,1,6,1,4,1,3,3,5,4,5}).toString());
    }
    @Test
    public void test6(){
        assertEquals("[3, 4, 0, 3]",solver.solve1(5,5,new int[]{0,1,1,2,2,0,0,3,3,4}).toString());
    }

}
