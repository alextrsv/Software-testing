package SecondTask;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RBTreeTest {
    private RBTree t;


    @BeforeEach
    public void initRBTree(){
        t = new RBTree();
        t.root=t.nil;

    }

    @ParameterizedTest
    @CsvSource({
            "3, red",
            "5, black",
            "7, red"
    })
    public void testColor1(int key, String color){
        t.RBInsert( 5);
        t.RBInsert(7);
        t.RBInsert(3);

        assertEquals(color, t.Search(key).getColor());
    }

    @ParameterizedTest
    @CsvSource({
            "1, red",
            "3, black",
            "7, black",
            "5, red",
            "15, red",
            "12, red",
            "13, black",
            "9, black",
            "10, red",
            "8, black"
    })
    public void testColor2(int key, String color){
        t.RBInsert( 5);
        t.RBInsert( 7);
        t.RBInsert( 3);
        t.RBInsert( 1);
        t.RBInsert( 9);
        t.RBInsert( 8);
        t.RBInsert( 10);
        t.RBInsert( 15);
        t.RBInsert( 13);
        t.RBInsert( 12);

        assertEquals(color, t.Search(key).getColor());

    }


    @ParameterizedTest
    @CsvSource({
            "1, 3",
            "3, 5",
            "7, 5",
            "5, 8",
            "15, 13",
            "12, 13",
            "13, 10",
            "9, 10",
            "10, 8"
    })
    public void testParentAfterInsert0(int childKey, int parentKey){
        t.RBInsert( 5);
        t.RBInsert( 7);
        t.RBInsert( 3);
        t.RBInsert( 1);
        t.RBInsert( 9);
        t.RBInsert( 8);
        t.RBInsert( 10);
        t.RBInsert( 15);
        t.RBInsert( 13);
        t.RBInsert( 12);

        assertEquals(parentKey, t.Search(childKey).getParent().getKey() );

    }

    @ParameterizedTest
    @CsvSource({
            "1, 3",
            "3, 5",
            "5, 8",
            "12, 13",
            "9, 10"
    })
    public void testLeftChild(int childKey, int parentKey){
        t.RBInsert( 5);
        t.RBInsert( 7);
        t.RBInsert( 3);
        t.RBInsert( 1);
        t.RBInsert( 9);
        t.RBInsert( 8);
        t.RBInsert( 10);
        t.RBInsert( 15);
        t.RBInsert( 13);
        t.RBInsert( 12);

        assertEquals(childKey, t.Search(parentKey).getLeft().getKey() );
    }

    @ParameterizedTest
    @CsvSource({
            "7, 5",
            "15, 13",
            "13, 10",
            "10, 8"
    })
    public void testRightChild(int childKey, int parentKey){
        t.RBInsert( 5);
        t.RBInsert( 7);
        t.RBInsert( 3);
        t.RBInsert( 1);
        t.RBInsert( 9);
        t.RBInsert( 8);
        t.RBInsert( 10);
        t.RBInsert( 15);
        t.RBInsert( 13);
        t.RBInsert( 12);

        assertEquals(childKey, t.Search(parentKey).getRight().getKey() );

    }

    @ParameterizedTest
    @CsvSource({
            "7, 8",
            "9, 8",
            "8, 5"
    })
    public void testRotate(int childKey, int parentKey){
        t.RBInsert( 5);
        t.RBInsert( 7);
        t.RBInsert( 3);
        t.RBInsert( 1);
        t.RBInsert( 9);
        t.RBInsert( 8);

        assertEquals(parentKey, t.Search(childKey).getParent().getKey() );
    }


    @ParameterizedTest
    @ValueSource(strings = {"I_R_I_I_I_p-rd_pl_pl1_I_I_p-rd_pr_pr2.if_rrt_pr2_lrt_I_p-rd_pr_pr1I_p-rd_pr_pr2_lrt_I_p-rd_pr_pr1p-rd_pr_pr2_lrt_I_p-rd_pl_pl2_rrt_"})
    public void testLog1(String exLog){
        t.RBInsert( 5);
        t.RBInsert( 7);
        t.RBInsert( 3);
        t.RBInsert( 1);
        t.RBInsert( 9);
        t.RBInsert( 8);
        t.RBInsert( 10);
        t.RBInsert( 15);
        t.RBInsert( 13);
        t.RBInsert( 12);

        assertEquals(exLog, t.getlog());

    }

    @ParameterizedTest
    @ValueSource(strings = {"I_R_I_I_p-rd_pl_pl2_rrt_I_p-rd_pl_pl1_I_p-rd_pl_pl2.if_lrt_pl2_rrt_I_I_p-rd_pr_pr1I_p-rd_pl_pl2.if_lrt_pl2_rrt_I_I_p-rd_pr_pr2_lrt_I_p-rd_pr_pr1p-rd_pl_pl2.if_lrt_pl2_rrt_I_p-rd_pl_pl2.if_lrt_pl2_rrt_I_p-rd_pl_pl2_rrt_I_p-rd_pr_pr1p-rd_pr_pr1I_p-rd_pl_pl1_I_p-rd_pl_pl2.if_lrt_pl2_rrt_I_p-rd_pl_pl2_rrt_I_p-rd_pr_pr1p-rd_pl_pl1_I_p-rd_pr_pr1I_"})
    public void testLog2(String exLog){
        t.RBInsert(68);
        t.RBInsert(34);
        t.RBInsert(33);
        t.RBInsert(1);
        t.RBInsert(6);
        t.RBInsert(66);
        t.RBInsert(7);
        t.RBInsert(9);
        t.RBInsert(2);
        t.RBInsert(3);
        t.RBInsert(12);
        t.RBInsert(19);
        t.RBInsert(45);
        t.RBInsert(21);
        t.RBInsert(40);
        t.RBInsert(30);
        t.RBInsert(35);
        t.RBInsert(33);
        t.RBInsert(46);
        t.RBInsert(38);

        assertEquals(exLog, t.getlog());
    }
}