package thirdTask;

public class Field {

    public static void main(String[] args) {
        Sentient whale1 = new Whale();
//        System.out.println(whale1.getxCoord()+", "+whale1.getyCoord()+", "+whale1.getzCoord());
        System.out.println(whale1.whoAmI());

        whale1.changePosition(9, -48, 45); //ok
        System.out.println(whale1.whoAmI());//whale

        whale1.changePosition(9, -48, 65);//not ok
        System.out.println(whale1.whoAmI());// not whale

//        whale1.changePosition(9, -48, 45);
//        System.out.println(whale1.whoAmI());

        whale1.setEmotionalState(EmotionalState.UNHAPPY);

    }



}
