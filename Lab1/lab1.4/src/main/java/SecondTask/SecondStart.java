package SecondTask;


public class SecondStart {
    public static void main(String[] args) {
        RBTree t = new RBTree();
        t.root=t.nil;
//        t.RBInsert( 5);
//        t.RBInsert( 7);
//        t.RBInsert( 3);
//        t.RBInsert( 1);
//        t.RBInsert( 9);
//        t.RBInsert( 8);
//        t.RBInsert( 10);
//        t.RBInsert( 15);
//        t.RBInsert( 13);
//        t.RBInsert( 12);
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

        System.out.println(t.getlog());



//        t.AllKey(t.root);


    }
}