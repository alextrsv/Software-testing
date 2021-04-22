package SecondTask;



public class RBTree {
    public Node root = new Node("black");
    public Node nil = new Node("black");
    public String log = "";


    public void LeftRotate(Node x){
        
        Node y = x.getRight();
        x.setRight(y.getLeft());
        if(y.getLeft()!=this.nil){
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == this.nil){
            this.root = y;
        }
        else if(x == x.getParent().getLeft()){
            x.getParent().setLeft(y);
        }
        else {
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
        log +="lrt_";
    }

    public void RightRotate(Node x){
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        if(y.getRight()!=this.nil){
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == this.nil){
            this.root = y;
        }
        else if(x == x.getParent().getRight()){
            x.getParent().setRight(y);
        }
        else {
            x.getParent().setLeft(y);
        }
        y.setRight(x);
        x.setParent(y);
        log +="rrt_";
    }


    public void RBInsert(int key){
        Node t = new Node();
        t.setKey(key);
        Node y = this.nil;
        Node x = this.root;
        while(x != this.nil){
            y = x;
            if(t.getKey() < x.getKey()){
                x = x.getLeft();
            }
            else x = x.getRight();
        }
        t.setParent(y);
        if(y == this.nil){
            this.root = t;
        }
        else if(t.getKey()<y.getKey()){
            y.setLeft(t);
        }
        else{
            y.setRight(t);
        }
        t.setLeft(this.nil);
        t.setRight(this.nil);
        t.setColor("red");
        log +="I_";
        RBInsertFixUp(t);
    }



    public void delete(int key) {
        Node t = new Node();
        t.setKey(key);
        Node x = this.root;
        // находим узел с ключом key
        while (x.getKey() != t.getKey()) {
            if (x.getKey() < t.getKey())
                x = x.getRight();
            else
                x = x.getLeft();
        }
        if (x.getLeft() == this.nil && x.getRight() == this.nil) {
            if (x == this.root)
                root = nil;
            else if (x == x.getParent().getLeft())
               x.getParent().setLeft(nil);
            else if (x == x.getParent().getRight())
                x.getParent().setRight(nil);
            return;
        }
        Node y = nil;
        Node q = nil;
        if (x.getLeft() != nil && x.getRight() == nil) { //|| (x.getLeft() == nil && x.getRight() != nil)){
            if (x == x.getParent().getLeft()) x.getParent().setLeft(x.getLeft());
            else if (x == x.getParent().getRight()) x.getParent().setRight(x.getLeft());
        }else if ((x.getLeft() == nil && x.getRight() != nil)){
            if (x == x.getParent().getLeft()) x.getParent().setLeft(x.getRight());
            else if (x == x.getParent().getRight()) x.getParent().setRight(x.getRight());
        }

        else if (x.getLeft() != nil && x.getRight() != nil){
            // НЕДОДЕЛАЛ
        }
    }



    public void RBInsertFixUp(Node z){
        if (z == this.root) {
            log +="R_";
            z.setColor("black");
            return;
        }
        while (z.getParent().getColor()=="red"){
            log +="p-rd_";
            if(z.getParent() == z.getParent().getParent().getLeft()){ // если отец - левый
                Node y = z.getParent().getParent().getRight();//дядя
                log +="pl_";
                if(y.getColor() == "red"){
                    log +="pl1_";
                    y.setColor("black");
                    z.getParent().setColor("black");
                    z.getParent().getParent().setColor("red");
                    z = z.getParent().getParent();
                }else {
                    if (z == z.getParent().getRight()) {
                        log +="pl2.if_";
                        z = z.getParent();
                        LeftRotate(z);
                    }
                    log +="pl2_";
                    z.getParent().setColor("black");
                    z.getParent().getParent().setColor("red");
                    RightRotate(z.getParent().getParent());
                }
            }
            else{//если отец - правый
                log +="pr_";
                Node y = z.getParent().getParent().getLeft(); //дядя
                if(y.getColor() != "red"){ //если дядя красный
//                    System.out.println("IF ОТЕЦ - ПРАВЫЙ и дядя - КРАСНЫЙ, новый: " + z.getKey());
                    log +="pr1";
                    y.setColor("black");
                    z.getParent().setColor("black");
                    z.getParent().getParent().setColor("red");
                    z = z.getParent().getParent();
                } else {    //если дяди нет
                    if (z == z.getParent().getLeft()) {
                        log +="pr2.if_";
//                        System.out.println("IF ОТЕЦ - ПРАВЫЙ и дядя - ЧЕРНЫЙ или его НЕТ и новый - ЛЕВЫЙ, новый: " + z.getKey());
                        z = z.getParent();
                        RightRotate(z);
                    }
                    log +="pr2_";
//                    System.out.println("IF ОТЕЦ - ПРАВЫЙ и ДЯДЯ - ЧЕРНЫЙ или его НЕТ и новый - ПРАВЫЙ, новый: " + z.getKey());
                    z.getParent().setColor("black");
                    z.getParent().getParent().setColor("red");
                    LeftRotate(z.getParent().getParent());
                }
            }
        }
        this.root.setColor("black");
    }



    public Node Search(int k){
        Node x = this.root;
        while(x!=this.nil && k!=x.getKey()){
            if(k<x.getKey()){
                x = x.getLeft();
            }
            else {
                x = x.getRight();
            }
        }
        return x;
    }

    public String getlog(){
        return log;
    }
    public void AllKey(Node x){
        if(x!=this.nil){
            AllKey(x.getLeft());
            System.out.println(x.getKey());
            AllKey(x.getRight());
        }
    }
}
