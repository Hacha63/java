package com.mycompany.java1;

class Aparell
{
    private int consum;
    private boolean encès;
    private static int consumTotal = 0;

    public Aparell(int consum)
    {
        this.consum = consum;
        this.encès = false;
    }

    public void encendre()
    {
        if (!encès){
            encès = true;
            consumTotal += consum;
        }
    }
    public void apagar()
    {
        if (encès){
            encès = false;
            consumTotal -= consum;
        }
    }

    public static int getConsumTotal(){
        return consumTotal;
    }
}

public class Habitatge {
    public static void main(String[] args) {
        Aparell bombeta = new Aparell(100);
        Aparell radiador = new Aparell(2000);
        Aparell planxa = new Aparell(1200);

        System.out.println("Consum Total: "+Aparell.getConsumTotal());

        bombeta.encendre();
        planxa.encendre();
        System.out.println("Consum Total: "+ Aparell.getConsumTotal());

        planxa.apagar();
        radiador.encendre();
        System.out.println("Consum Total: "+ Aparell.getConsumTotal());
    }
}
